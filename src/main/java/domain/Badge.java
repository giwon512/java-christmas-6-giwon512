package domain;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    private Badge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
