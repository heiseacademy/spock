package com.github.sparsick.heise.spock


import spock.lang.Specification

class ConditionSpec extends Specification {

    def "simple test" (){
        when:
            println("I'm a simple Test")
        then:
            true

    }

    def "next test" (){
        when:
            println("Next Test")
        then:
            true
    }




}