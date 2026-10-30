package org.example.factory;

import org.example.enums.Colors;
import org.example.enums.Fonts;
import org.example.models.Character;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, Character> characterMap = new HashMap<>();

    public Character getCharacter(Fonts font, int size, Colors color){
        String key = font.name() + "_" + size + "_" + color.name();

        if(!characterMap.containsKey(key)) characterMap.put(key, new Character(font, size, color));

        return characterMap.get(key);
    }
}
