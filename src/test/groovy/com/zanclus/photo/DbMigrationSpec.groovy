package com.zanclus.photo

import io.vertx.core.json.JsonObject
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Specification

class DbMigrationSpec extends Specification {

  private PostgreSQLContainer dbContainer

  private Map<String, String> dbConfig

  def initPostgresContainer(String initScriptPath = null) throws Exception {

    // Check to see if we are running inside of Kubernetes/OpenShift
    if (System.getenv('KUBERNETES_NAMESPACE') == null) {

      // If not running in K8s/OCP, use TestContainers to start a PostgreSQL instance
      dbContainer = new PostgreSQLContainer<>()
      if (initScriptPath != null) {
        dbContainer.withInitScript(initScriptPath)
      }
      this.dbContainer
              .withDatabaseName('photoarchive')
              .withUsername('dphillips')
              .withPassword('dphillips')
              .start()
      dbConfig = [
        host: dbContainer.getContainerIpAddress(),
        port: dbContainer.getMappedPort(5432),
        driver: dbContainer.getDriverClassName(),
        username: dbContainer.getUsername(),
        password: dbContainer.getPassword(),
        database: dbContainer.getDatabaseName()
      ]
    } else {

      // When running in K8s/OCP, use environment variables to get database access details
      dbConfig = [
        host: dbContainer.getContainerIpAddress(),
        port: dbContainer.getMappedPort(),
        driver: 'org.postgresql.Driver',
        username: System.getenv('TEST_DATABASE_USER'),
        password: System.getenv('TEST_DATABASE_PASS'),
        database: System.getenv('TEST_DATABASE_NAME')
      ]
    }
  }

  def "Test successful creation of database from scratch"() {
    given: 'An instance of a PostgreSQL Database'
      initPostgresContainer()

    and: 'An instance of MainVerticle'
      def underTest = new MainVerticle()

    and: 'The database configuration'
      def dbJson = new JsonObject([db: dbConfig])

    when: 'The database migration functions are run'
      def result = underTest.databaseMigrations(dbJson)

    then: 'Expect the migrations to have been completed successfully'
      result.blockingGet(false) == true
  }
}