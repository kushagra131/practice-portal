package org.example;

import org.example.coding.interview.Interview;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var sys = System.out;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        sys.println("Hello! Welcome to Practice Portal!");
        //Interview.main(List.of("rowWithMaxOnes").toArray(new String[0]));
        Interview.main(List.of("longestPalindrome").toArray(new String[0]));
    }
}