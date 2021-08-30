package query.bug

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class TestIntegrationSpec extends Specification {

    def "test where query is in where block"() {
        given:
        Bundle bundle = new Bundle(name: 'bundle')
        bundle.addToVersions(name: '1.0')
        bundle.save(flush: true)

        when:
        BundleVersion result = BundleVersion.find { name == '1.0' && bundle.name == 'bundle' }

        then:
        with(result) {
            name == '1.0'
            bundle.name == 'bundle'
        }
    }

    def "test where query is in then block with def"() {
        given:
        Bundle bundle = new Bundle(name: 'bundle')
        bundle.addToVersions(name: '1.0')
        bundle.save(flush: true)

        when:
        BundleVersion result = BundleVersion.find { name == '1.0' && bundle.name == 'bundle' }

        then:
        with(result) {
            name == '1.0'
            bundle.name == 'bundle'
        }

        when:
        bundle.addToVersions(name: '1.1')
        bundle.save(flush: true)

        then:
        def newResult = BundleVersion.find({ name == '1.1' && bundle.name == 'bundle' })
        newResult.name == '1.1'
    }

    def "test where query is in then block without def"() {
        given:
        Bundle bundle = new Bundle(name: 'bundle')
        bundle.addToVersions(name: '1.0')
        bundle.save(flush: true)

        when:
        BundleVersion result = BundleVersion.find { name == '1.0' && bundle.name == 'bundle' }

        then:
        with(result) {
            name == '1.0'
            bundle.name == 'bundle'
        }

        when:
        bundle.addToVersions(name: '1.1')
        bundle.save(flush: true)

        then: "this will fail - which is not expected"
        BundleVersion.find({ name == '1.1' && bundle.name == 'bundle' }).name == '1.1'
    }
}
