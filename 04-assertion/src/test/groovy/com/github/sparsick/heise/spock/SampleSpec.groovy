package com.github.sparsick.heise.spock

import spock.lang.Shared
import spock.lang.Specification

class SampleSpec extends Specification {

    @Shared
    def person

    def setup() {
        person = new Person("Tom", "Taylor", " Software Developer")
    }


    def "Teste Person nach seinem Vornamen"() {
        when:
        def firstName = person.firstName
        then:
        firstName == "Tom"
    }

    def "Teste Person nach seinem Nachnamen"() {
        when:
        def lastName = person.lastName
        then:
        lastName == "Taylor"
    }

}