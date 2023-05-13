package com.github.sparsick.heise.spock


import spock.lang.Specification

class MockingSpec extends Specification {

    def "simple interaction" (){
        given:
        def serviceMock = Mock(Service)
        Service serviceMock2 = Mock()
        def controllerUnderTest = new Controller(serviceMock)

        when:
        controllerUnderTest.handleRequest("Hello World")

        then:
        1 * serviceMock.receiveData("Hello World")
        1 * serviceMock.letMeKnow()
    }

    def "order is important" (){
        given:
        def serviceMock = Mock(Service)
        Service serviceMock2 = Mock()
        def controllerUnderTest = new Controller(serviceMock)

        when:
        controllerUnderTest.handleRequest("Hello World")

        then:
        1 * serviceMock.letMeKnow()

        then:
        1 * serviceMock.receiveData("Hello World")
    }

    def "focus on target object" (){
        given:
        def serviceMock = Mock(Service)
        def controllerUnderTest = new Controller(serviceMock)

        when:
        controllerUnderTest.handleRequest("Hello World")

        then:
        2 * serviceMock._
    }

    def "focus on method" (){
        given:
        def serviceMock = Mock(Service)
        def controllerUnderTest = new Controller(serviceMock)

        when:
        controllerUnderTest.handleRequest(null)

        then:
        1 * serviceMock.letMeKnow()
        1 * serviceMock.receiveData(_)
    }

    def "mixing interaction and condition" (){
        given:
        def serviceMock = Mock(Service)
        def controllerUnderTest = new Controller(serviceMock)

        when:
        def result =controllerUnderTest.handleRequest(null)

        then:
        1 * serviceMock.letMeKnow()
        1 * serviceMock.receiveData(_)
        result == false
    }


}