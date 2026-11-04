package org.HW9_Flyweight.models;

import org.HW9_Flyweight.enums.Color;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public final class CharacterFlyweight {
    private final char value;
    private final int size;
    private final Color color;
    private final String font;

    public CharacterFlyweight(char value,
                              int size,
                              Color color,
                              String font) {
        this.value = value;
        this.size = size;
        this.color = color;
        this.font = font;
    }
    public void applyTo(XWPFRun run) {
        run.setText(String.valueOf(value));
        run.setFontFamily(font);
        run.setFontSize(size);
        run.setColor(color.getHexCode());
    }

    public char getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public String getFont() {
        return font;
    }
}