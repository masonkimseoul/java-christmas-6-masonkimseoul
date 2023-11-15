package christmas.Domain;

enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int badgeThreshold;

    Badge(String name, int badgeThreshold) {
        this.name = name;
        this.badgeThreshold = badgeThreshold;
    }

    public String getName() {
        return this.name;
    }

    public int getBadgeThresholdThreshold() {
        return this.badgeThreshold;
    }
}