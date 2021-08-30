package query.bug

class Bundle {

    String name

    static hasMany = [versions: BundleVersion]

    static constraints = {
    }
}
