package com.burnettcodeworks.resume.enums;

public enum Proficiency {
    NOVICE("Novice"),        // Just starting, basic understanding
    BEGINNER("Beginner"),    // Some experience, can perform simple tasks
    INTERMEDIATE("Intermediate"), // Comfortable, can work independently on most tasks
    ADVANCED("Advanced"),    // Highly skilled, can handle complex tasks and problem-solving
    EXPERT("Expert"),        // Deep expertise, can mentor others and tackle challenging problems
    HOBBY("Hobby");          // Passionate about the skill, but not necessarily professional-level expertise

    private final String displayName;

    Proficiency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}