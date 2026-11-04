
import org.HW9_Flyweight.enums.Color;
import org.HW9_Flyweight.factory.CharacterFactory;
import org.HW9_Flyweight.models.CharacterFlyweight;
import org.HW9_Flyweight.models.Document;
import org.HW9_Flyweight.models.TextEditor;
import org.HW9_Flyweight.utils.TextStyles;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyweightTest {

    CharacterFactory factory;
    CharacterFlyweight characterFlyweight;

    //PUSH
    @Test
    public void testFlyweightCount2(){
        factory = new CharacterFactory();
        char c1 = 'a', c2 = 'b', c3 = 'a';
        int size1 = 12, size2 = 10;
        Color color1 = Color.BLUE, color2 = Color.RED;
        String font = "Arial";
        characterFlyweight = factory.getCharacter(c1, size1, color1, font);
        characterFlyweight = factory.getCharacter(c2, size2, color2, font);
        characterFlyweight = factory.getCharacter(c3, size1, color1, font);

        int expected = 2; // because 2 are different
        int actual = factory.getFlyweightCount();
        assertEquals(expected, actual);
    }

    @Test
    public void testFlyweightCount3(){
        factory = new CharacterFactory();
        char c1 = 'a', c2 = 'b', c3 = 'a';
        int size1 = 12, size2 = 10;
        Color color1 = Color.BLUE, color2 = Color.RED;
        String font = "Arial";
        characterFlyweight = factory.getCharacter(c1, size1, color1, font);
        characterFlyweight = factory.getCharacter(c2, size2, color2, font);
        characterFlyweight = factory.getCharacter(c3, size1, color2, font);

        int expected = 3; // because 3 are different
        int actual = factory.getFlyweightCount();
        assertEquals(expected, actual);
    }

    @Test
    void editCommandAcceptsTextInput() throws Exception {
        TextEditor editor = new TextEditor();

        String textInput =
                "First line\n" +
                        "Second line\n" +
                        ".\n";

        assertDoesNotThrow(() -> {
            editor.handleCommand(
                    new StringReader(textInput),
                    ":edit"
            );
        });
    }

    @Test
    void documentContainsSavedText(
            @TempDir Path temporaryDirectory)
            throws Exception {

        Document document = new Document();

        TextStyles style = new TextStyles();

        document.addLine(
                "Hello World",
                style
        );
        Path outputFile =
                temporaryDirectory.resolve("text.docx");

        document.saveAsDocx(
                outputFile.toString()
        );

        try (InputStream input =
                     Files.newInputStream(outputFile);
             XWPFDocument wordDocument =
                     new XWPFDocument(input)) {

            String text =
                    wordDocument
                            .getParagraphArray(0)
                            .getText();

            assertEquals(
                    "Hello World",
                    text
            );
        }
    }

    @Test
    void defaultStyleHasExpectedValues() {
        TextStyles style = new TextStyles();

        assertEquals("Arial", style.getFont());
        assertEquals(12, style.getSize());
        assertEquals(Color.BLACK, style.getColor());
    }
}
