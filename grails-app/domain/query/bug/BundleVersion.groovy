package query.bug

class BundleVersion {

    String name

    static belongsTo = [relation: Bundle]

    static constraints = {
    }
}
