package org.HW9_Flyweight.factory;

import org.HW9_Flyweight.enums.CharacterKey;
import org.HW9_Flyweight.enums.Color;
import org.HW9_Flyweight.models.CharacterFlyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, CharacterFlyweight>
            characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char value,
                                           int size,
                                           Color color,
                                           String font) {
        String key =  value + "_" +  size + "_" +  color + "_" +  font;
        if (!characters.containsKey(key)) {
            characters.put(
                    key,
                    new CharacterFlyweight(value, size, color, font)
            );
        }

        return characters.get(key);
    }

    public int getFlyweightCount() {
        return characters.size();
    }
}