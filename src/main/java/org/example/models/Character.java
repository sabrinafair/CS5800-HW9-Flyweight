package org.example.models;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.enums.Colors;
import org.example.enums.Fonts;

public class Character {

    String font;
    int size;
    String color;
    String character;

    public Character(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void setCharacter(String c){
        this.character = c;
    }

    public void setFields(XWPFRun run){
        run.setText(this.character);
        run.setColor(this.color);
        run.setFontFamily(this.font);
        run.setFontSize(this.size);
    }
}
