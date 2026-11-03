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
        try {
            System.out.print("> ");
            command = ":new";
            editor.handleCommand(new StringReader(command), command);

            command = ":font Arial";
            editor.handleCommand(new StringReader(command), command);

            command = ":color red";
            editor.handleCommand(new StringReader(command), command);

            command = ":size 18";
            editor.handleCommand(new StringReader(command), command);

            command = ":edit\n" +
                    "this is sample first input\n" +
                    ".\n";
            editor.handleCommand(new StringReader(command), command);

            command = ":write test3.docx";
            editor.handleCommand(new StringReader(command), command);

        } catch (IOException exception) {
            System.out.println(
                    "Editor error: " +
                            exception.getMessage()
            );
        }
    }
}