package org.HW9_Flyweight.models;

public final class CharacterFlyweight {
    private final char value;

    public CharacterFlyweight(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}