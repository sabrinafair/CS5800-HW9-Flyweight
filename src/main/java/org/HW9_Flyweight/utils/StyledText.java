package org.HW9_Flyweight.utils;


public class StyledText {
    private final String text;
    private final TextStyles style;

    public StyledText(String text, TextStyles style) {
        this.text = text;
        this.style = new TextStyles(style);
    }

    public String getText() {
        return text;
    }

    public TextStyles getStyle() {
        return style;
    }
}