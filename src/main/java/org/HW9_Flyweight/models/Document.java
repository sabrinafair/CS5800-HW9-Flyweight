package org.HW9_Flyweight.models;

import org.HW9_Flyweight.factory.CharacterFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.HW9_Flyweight.utils.StyledText;
import org.HW9_Flyweight.utils.TextStyles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<StyledText> lines;
    private final CharacterFactory characterFactory;

    public Document() {
        lines = new ArrayList<>();
        characterFactory = new CharacterFactory();
    }

    public void addLine(String text, TextStyles style) {
        lines.add(new StyledText(text, style));
    }

    public void clear() {
        lines.clear();
    }

    public void saveAsDocx(String filePath)
            throws IOException {

        try (XWPFDocument document =
                     new XWPFDocument()) {

            for (StyledText styledText : lines) {
                XWPFParagraph paragraph =
                        document.createParagraph();

                XWPFRun run =
                        paragraph.createRun();

                TextStyles style =
                        styledText.getStyle();

                run.setFontFamily(style.getFont());
                run.setFontSize(style.getSize());
                run.setColor(style.getColor().getHexCode());

                StringBuilder text =
                        new StringBuilder();

                for (int i = 0;
                     i < styledText.getText().length();
                     i++) {

                    char value =
                            styledText.getText().charAt(i);

                    CharacterFlyweight flyweight =
                            characterFactory.getCharacter(value);

                    text.append(
                            flyweight.getValue()
                    );
                }

                run.setText(text.toString());
            }

            try (FileOutputStream output =
                         new FileOutputStream(filePath)) {

                document.write(output);
            }
        }
    }

    public int getFlyweightCount() {
        return characterFactory.getFlyweightCount();
    }
}