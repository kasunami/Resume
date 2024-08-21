package com.burnettcodeworks.resume.enums;

public enum Proficiency {
    NOVICE("Novice"),
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    EXPERT("Expert"),
    HOBBY("Hobby");

    private final String displayName;

    Proficiency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}