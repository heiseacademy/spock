package com.github.sparsick.heise.spock

import spock.lang.Specification

class StubbingSpec extends Specification {

    def "simple stubbing" (){
        given:
        def serviceMock = Mock(Service)
        def controllerUnderTest = new Controller(serviceMock)

        when:
        def result =controllerUnderTest.handleRequest(null)

        then:
        serviceMock.receiveData(_) >> true
        result == true
    }

    def "several mock calls" (){
        given:
        def serviceMock = Mock(Service)

        when:
        println(serviceMock.receiveData(""))
        println(serviceMock.receiveData(""))
        println(serviceMock.receiveData(""))

        then:
        serviceMock.receiveData(_) >>> [true, false, false]
    }

    def "computing mock calls" (){
        given:
        def serviceMock = Mock(Service)

        when:
        println(serviceMock.receiveData("12"))
        println(serviceMock.receiveData(""))
        println(serviceMock.receiveData("123"))

        then:
        serviceMock.receiveData(_) >> {String data -> data.length() == 0}
    }

    def "mixing stubbing and mocking"() {
        given:
        def serviceMock = Mock(Service)
        def controllerUnderTest = new Controller(serviceMock)

        when:
        def result = controllerUnderTest.handleRequest("Hello World")

        then:
        1 * serviceMock.letMeKnow()
        1 * serviceMock.receiveData(_) >> true
        result == true
    }





}
