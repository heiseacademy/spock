package com.github.sparsick.heise.spock


import spock.lang.Specification

class DataSpec extends Specification {

    def "Data Table"(def expectedPosition, def direction) {
        given:
        def position = new Position(10,10)

        when:
        def newPosition = position.moveForward(direction)

        then:
        newPosition == expectedPosition

        where:
        expectedPosition | direction
        new Position(10, 11) | Direction.NORTH
        new Position(9, 10) | Direction.WEST
        new Position(11, 10) | Direction.EAST
        new Position(10, 9) | Direction.SOUTH
    }

    def "Data Table Variante"() {
        given:
        def position = new Position(10,10)

        when:
        def newPosition = position.moveForward(direction)

        then:
        newPosition == expectedPosition

        where:
        expectedPosition ; direction
        new Position(10, 11) ; Direction.NORTH
        new Position(9, 10) ; Direction.WEST
        new Position(11, 10) ; Direction.EAST
        new Position(10, 9) ; Direction.SOUTH
    }

    def "Data Pipes"() {
        given:
        def position = new Position(10,10)

        when:
        def newPosition = position.moveForward(direction)

        then:
        newPosition == expectedPosition

        where:
        expectedPosition << [new Position(10, 11), new Position(9, 10), new Position(11, 10), new Position(10, 9)]
        direction << Direction.values()
    }

    def "Data Variable"() {
        given:
        def position = new Position(10,10)

        when:
        def newPosition = position.moveForward(direction)

        then:
        newPosition == expectedPosition

        where:
        [x,y] << [[10,11], [x:9, y:10], [y: 10, x:11], [10,9]]
        expectedPosition = new Position(x,y)
        direction << Direction.values()
    }


}