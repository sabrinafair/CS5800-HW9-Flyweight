package org.HW9_Flyweight;

import org.HW9_Flyweight.models.TextEditor;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        try {
            editor.start();
        } catch (IOException exception) {
            System.out.println(
                    "Editor error: " +
                            exception.getMessage()
            );
        }
    }
}