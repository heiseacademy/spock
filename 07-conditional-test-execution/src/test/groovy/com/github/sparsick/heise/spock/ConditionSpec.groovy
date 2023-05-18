package com.github.sparsick.heise.spock

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification
//@Ignore
//@Ignore(inherited = true)
class ConditionSpec extends Specification {

//    @Ignore
//    @IgnoreRest

    @IgnoreIf({os.linux})
    def "simple test" (){
        when:
            println("I'm a simple Test")
        then:
            true

    }

    @Requires(value={os.windows}, reason = "needs windows")
    def "next test" (){
        when:
            println("Next Test")
        then:
            true
    }




}