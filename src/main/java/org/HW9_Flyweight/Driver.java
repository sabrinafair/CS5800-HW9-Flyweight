package org.HW9_Flyweight;

import org.HW9_Flyweight.models.TextEditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Driver {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        String command = "";
        String textInput = "";
        try {
            System.out.print("> ");
            command = ":new";
            editor.handleCommand(new StringReader(""), command);

            command = ":font Arial";
            editor.handleCommand(new StringReader(""), command);

            command = ":color red";
            editor.handleCommand(new StringReader(""), command);

            command = ":size 18";
            editor.handleCommand(new StringReader(""), command);

            command = ":edit";
            textInput = "this is sample input\n" +
                    ".\n";
            editor.handleCommand(new StringReader(textInput), command);

            command = ":font Courier New";
            editor.handleCommand(new StringReader(""), command);

            command = ":color green";
            editor.handleCommand(new StringReader(""), command);

            command = ":size 12";
            editor.handleCommand(new StringReader(""), command);

            command = ":edit";
            textInput = "this is sample input 2\n" +
                    ".\n";
            editor.handleCommand(new StringReader(textInput), command);

            command = ":font Georgia";
            editor.handleCommand(new StringReader(""), command);

            command = ":color blue";
            editor.handleCommand(new StringReader(""), command);

            command = ":size 10";
            editor.handleCommand(new StringReader(""), command);

            command = ":edit";
            textInput = "this is sample input 3\n" +
                    ".\n";
            editor.handleCommand(new StringReader(textInput), command);

            command = ":font Arial";
            editor.handleCommand(new StringReader(""), command);

            command = ":color yellow";
            editor.handleCommand(new StringReader(""), command);

            command = ":size 14";
            editor.handleCommand(new StringReader(""), command);

            command = ":edit";
            textInput = "this is sample input 4\n" +
                    ".\n";
            editor.handleCommand(new StringReader(textInput), command);
            command = ":write HelloWorldCS5800.docx";
            editor.handleCommand(new StringReader(""), command);

        } catch (IOException exception) {
            System.out.println(
                    "Editor error: " +
                            exception.getMessage()
            );
        }
    }
}
