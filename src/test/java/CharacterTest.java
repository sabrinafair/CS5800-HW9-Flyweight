
import org.HW9_Flyweight.factory.CharacterFactory;
import org.HW9_Flyweight.models.CharacterFlyweight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    CharacterFactory factory;
    CharacterFlyweight characterFlyweight;

    //PUSH
    @Test
    public void testFlyweightCount(){
        factory = new CharacterFactory();
        char c1 = 'a';
        char c2 = 'b';
        char c3 = 'a';

        characterFlyweight = factory.getCharacter(c1);
        characterFlyweight = factory.getCharacter(c1);
        characterFlyweight = factory.getCharacter(c1);

        int expected = 2;
        int actual = factory.getFlyweightCount();
        assertEquals(expected, actual);
    }
}
