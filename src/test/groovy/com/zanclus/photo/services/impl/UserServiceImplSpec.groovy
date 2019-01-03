package com.zanclus.photo.services.impl

import com.zanclus.photo.services.UserService
import com.zanclus.photo.services.types.Credentials
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

import java.sql.Connection
import java.sql.DriverManager

class UserServiceImplSpec extends Specification {

  public static final String JDBC_URL_REGEX = $/^jdbc:postgresql://(\w+):(\d+)/(\w+).*/$
  @Shared
  UserService underTest

  @Shared
  Vertx vertx

  @Shared
  JsonObject config

  @Shared
  PostgreSQLContainer db

  def setupSpec() {
    vertx = Vertx.vertx()

    Map<String, String> configMap

    if (System.getenv('KUBERNETES_NAMESPACE') == null) {
      db = new PostgreSQLContainer<>()

      db.withInitScript('user_service_db_init.sql')
      db.withUsername('testuser')
      db.withPassword('testpass')
      db.withDatabaseName('photoarchive')
      db.start()

      configMap = [
        db: [
          host       : db.getContainerIpAddress(),
          port       : db.getMappedPort(5432),
          username   : db.getUsername(),
          password   : db.getPassword(),
          database   : db.getDatabaseName(),
          sslMode    : 'disable',
          maxPoolSize: 10
        ]
      ]
    } else {
      configMap = [
        db: [
          host       : System.getenv('POSTGRESQL_HOST'),
          port       : System.getenv('POSTGRESQL_PORT'),
          username   : System.getenv('POSTGRESQL_USER'),
          password   : System.getenv('POSTGRESQL_PASS'),
          database   : System.getenv('POSTGRESQL_DB'),
          sslMode    : 'disable',
          maxPoolSize: 10
        ]
      ]
    }
    config = new JsonObject(configMap)
  }

  def setup() {
    underTest = new UserServiceImpl(vertx, config)
  }

  def cleanupSpec() {
    vertx.close()
    if (System.getenv('KUBERNETES_NAMESPACE') == null) {
      db.close()
    }
  }

  def "test successful user login"() {
    given: 'An instance of AsyncConditions'
      def async = new AsyncConditions(1)

    and: 'A valid set of credentials'
      def cred = new Credentials(new JsonObject([username: 'dphillips', password: 'dphillips']))

    when: 'the userLogin method is called with valid credentials'
      underTest.userLogin(cred, { res ->
        if (res.succeeded()) {
          async.evaluate {
            def result = res.result()
            result != null
            def decoded = Base64.decoder.decode(result)
            UUID.fromString(decoded)
          }
        } else {
          async.evaluate {
            throw res.cause()
          }
        }
      })

    then: 'expect that the AsyncConditions will resolve successfully'
      async.await(10)
  }
}
