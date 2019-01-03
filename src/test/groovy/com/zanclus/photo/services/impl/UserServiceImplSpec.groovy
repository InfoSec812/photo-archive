package com.zanclus.photo.services.impl

import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class UserServiceImplSpec extends Specification {
  def "test userLogin"() {
    given: "An AsyncConditions object"
      def async = new AsyncConditions(1)

    and: "An instance of the UserService"

    when: "The method userLogin is called with correct credentials"
      // TODO implement stimulus
    then: "Expect a positive response"
      // TODO implement assertions
  }
}
