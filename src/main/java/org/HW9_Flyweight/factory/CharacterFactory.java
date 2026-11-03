package org.HW9_Flyweight.factory;

import org.HW9_Flyweight.models.CharacterFlyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<Character, CharacterFlyweight>
            characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char value) {
        if (!characters.containsKey(value)) {
            characters.put(
                    value,
                    new CharacterFlyweight(value)
            );
        }

        return characters.get(value);
    }

    public int getFlyweightCount() {
        return characters.size();
    }
}