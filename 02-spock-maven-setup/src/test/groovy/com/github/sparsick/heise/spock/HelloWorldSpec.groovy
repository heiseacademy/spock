package com.github.sparsick.heise.spock

import spock.lang.Specification

class HelloWorldSpec extends Specification {


    def "Hello World Test"() {
        expect:
        println "Hello World!"
    }

}