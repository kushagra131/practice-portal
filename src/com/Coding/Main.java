package com.Coding;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.process("racecar"));
    }

    // process() returns the length of longest palindromic substring in a string
    public String process(String word) {
        if (word == null || word.length() < 1)
            return null;
        else {
            HashSet<String> set = new HashSet<>();
            for(int i=0; i < word.length(); i++) {
                for(int j=i+1; j < word.length(); j++) {
                    set.add(word.substring(i,j));
                }
            }

            set.forEach(element -> System.out.println(element));
            return null;
        }
    }
}