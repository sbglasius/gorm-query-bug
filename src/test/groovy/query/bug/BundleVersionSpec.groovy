package query.bug

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BundleVersionSpec extends Specification implements DomainUnitTest<BundleVersion> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
