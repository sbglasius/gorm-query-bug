package query.bug

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BundleSpec extends Specification implements DomainUnitTest<Bundle> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
