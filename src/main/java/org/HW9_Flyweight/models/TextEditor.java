package org.HW9_Flyweight.models;

import org.HW9_Flyweight.enums.Color;
import org.HW9_Flyweight.utils.Config;
import org.HW9_Flyweight.utils.TextStyles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TextEditor {
    private TextStyles currentStyle;
    private Document document;

    public TextEditor() {
        document = new Document();
        currentStyle = new TextStyles();
    }
    public void start() throws IOException {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        boolean running = true;

        System.out.println("Simple Text Editor");
        System.out.println(
                "Commands: :new, :font, :size, :color, " +
                        ":edit, :write, :quit"
        );

        while (running) {
            System.out.print("> ");

            String command = input.readLine();

            if (command == null) {
                break;
            }

            command = command.trim();

            if (command.equals(":quit")) {
                running = false;
                System.out.println("Exiting editor.");
            } else {
                handleCommand(input, command);
            }
        }
    }

    public void handleCommand(Reader inputSource, String command)
            throws IOException {

            if (command.equals(":new")) {
                document.clear();
                System.out.println("New document created.");
            } else if (command.startsWith(":font ")) {
                String font =
                        command.substring(6).trim();

                currentStyle.setFont(font);
                System.out.println("Font set to " + font);
            } else if (command.startsWith(":size ")) {
                int size = Integer.parseInt(
                        command.substring(6).trim()
                );

                currentStyle.setSize(size);
                System.out.println("Font size set to " + size);
            } else if (command.startsWith(":color ")) {
                String colorInput =
                        command.substring(7).trim();

                try {
                    Color color =
                            Color.valueOf(
                                    colorInput.toUpperCase()
                            );

                    currentStyle.setColor(color);

                    System.out.println(
                            "Color set to " + color
                    );

                } catch (IllegalArgumentException exception) {
                    System.out.println(
                            "Invalid color. Available colors: " +
                                    "red, blue, green, black, white, yellow."
                    );
                }
            } else if (command.equals(":edit")) {
                enterText(inputSource);
            } else if (command.startsWith(":write ")) {
                String filePath =
                        Config.FILEPATH + command.substring(7).trim();

                document.saveAsDocx(filePath);

                System.out.println(
                        "Saved document to " + filePath
                );
            }
    }
    private void enterText(Reader inputSource) throws IOException {

        BufferedReader input = new BufferedReader(inputSource);

        System.out.println(
                "Enter text. Type a single period to finish."
        );

        while (true) {
            String line = input.readLine();

            if (line.equals(".")) {
                break;
            }

            document.addLine(line, currentStyle);
        }
    }
}
