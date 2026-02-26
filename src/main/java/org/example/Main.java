package org.example;

import org.example.coding.interview.Interview;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var console = System.console();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        console.printf("Hello World!");
        Interview.main(List.of("checkPattern").toArray(new String[0]));
    }
}