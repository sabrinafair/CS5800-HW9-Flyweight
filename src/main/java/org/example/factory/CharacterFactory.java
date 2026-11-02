package org.example.factory;

import org.example.enums.Colors;
import org.example.enums.Fonts;
import org.example.models.Character;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, Character> characterMap = new HashMap<>();

    public Character getCharacter(String font, int size, String color, String character){
        String key = font + "_" + size + "_" + color;

        if(!characterMap.containsKey(key)) characterMap.put(key, new Character(font, size, color));

        Character foundChar = characterMap.get(key);

        foundChar.setCharacter(character);

        return foundChar;
    }
}
