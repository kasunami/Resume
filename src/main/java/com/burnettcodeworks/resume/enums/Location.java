package com.burnettcodeworks.resume.enums;

public enum Location {
    ONSITE("On site"),
    REMOTE("Remote"),
    HYBRID("Hybrid");

    private final String displayName;

    Location(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
