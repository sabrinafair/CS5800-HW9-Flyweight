package org.HW9_Flyweight.utils;

import org.HW9_Flyweight.enums.Color;

public class TextStyles {
    private String font;
    private int size;
    private Color color;

    public TextStyles() {
        font = "Arial";
        size = 12;
        color = Color.BLACK;
    }

    //this is important because it will keep the old format if not specifically changed
    public TextStyles(TextStyles other) {
        font = other.font;
        size = other.size;
        color = other.color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
