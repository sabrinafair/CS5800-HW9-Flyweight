package org.HW9_Flyweight.enums;

public enum Color {
    RED("FF0000"),
    BLUE("0000FF"),
    GREEN("00FF00"),
    BLACK("000000"),
    WHITE("FFFFFF"),
    YELLOW("FFFF00");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}