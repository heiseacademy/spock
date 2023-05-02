package com.github.sparsick.heise.spock


import spock.lang.Specification

class SampleSpec extends Specification {

    def "Teste Person, ob sein Name richtig gesetzt ist" () {
        when:
        def person = new Person("Tom", "Taylor", " Software Developer")
        then:
        person.firstName == "Tom"
        person.lastName == "Taylor"
    }

    def "Teste Person, ob sein Name richtig gesetzt ist mit helper method" () {
        when:
        def person = new Person("Tom", "Taylor", " Software Developer")
        then:
        matchName(person)
    }

    def matchName(def person) {
        assert person.firstName == "Tom"
        assert person.lastName == "Taylor"
    }

    def "Teste Person, ob sein Name richtig gesetzt ist mit with" () {
        when:
        def person = new Person("Tom", "Taylor", " Software Developer")
        then:
        with(person) {
            firstName == "Tom"
            lastName == "Taylor"
        }
    }

    def "Teste Person, ob sein Name richtig gesetzt ist mit veryAll" () {
        when:
        def person = new Person("Tom", "Taylor", " Software Developer")
        then:
        verifyAll (person) {
            firstName == "Tom"
            lastName == "Taylor"
        }
    }


}