package org.example.models;

import org.example.enums.Colors;
import org.example.enums.Fonts;

public class Character {

    Fonts font;
    int Size;
    Colors color;

    public Character(Fonts font, int size, Colors color) {
        this.font = font;
        Size = size;
        this.color = color;
    }
}
