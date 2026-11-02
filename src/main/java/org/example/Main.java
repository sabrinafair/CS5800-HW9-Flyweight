package org.example;
import org.apache.poi.xwpf.usermodel.*;
import org.example.factory.CharacterFactory;
import org.example.models.Character;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        String filePath = "C:\\Users\\Sabrina Ferras\\OneDrive - csumb.edu\\Documents\\CPP\\8Fall2026\\CS 5800\\hw\\SampleDoc.docx";

        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph paragraph = document.createParagraph();

            // The text we want to write character by character
            String text = "ThisIsTheInputText";

            // Example style arrays to cycle through for demonstration
            String[] colors = {"FF0000", "FF7F00", "FFFF00", "00FF00", "0000FF", "4B0082", "8B00FF"};
            String[] fonts = {"Arial", "Courier New", "Times New Roman", "Georgia", "Verdana"};
            int baseSize = 14;

            for (int i = 0; i < text.length(); i++) {
                String ch = String.valueOf(text.charAt(i));
                // 1. Create a completely new run for this single character
                XWPFRun run = paragraph.createRun();

                // 2. Cycle or dynamically assign the styling parameters
                String targetColor = colors[i % colors.length];
                String targetFont = fonts[i % fonts.length];
                int targetSize = baseSize + (i * 2); // Gradually increases size

                Character character = factory.getCharacter(targetFont, targetSize, targetColor, ch);
                character.setFields(run);
            }

            saveDoc(filePath, document);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDoc(String filePath, XWPFDocument document) {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Document created successfully with character-by-character styling.");

    }
}