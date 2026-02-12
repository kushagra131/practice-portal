package org.example.coding;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Interview {

    public static void main(String[] args) {
        if ("checkPattern".equals(args[0])) {
            checkPattern();
        } else {
            System.out.println("Invalid Input");
        }
    }

    private static void checkPattern() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases");
        int number = Integer.parseInt(sc.nextLine());
        while (number > 0) {
            System.out.println("Enter the regex pattern");
            String pattern = sc.nextLine();
            // --> Code Logic here
            try {
                if (isValidPattern(pattern)) System.out.println("Valid");
                else System.out.println("Invalid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            number--;
        }
        sc.close();
    }

    private static boolean isValidPattern(String regex) throws PatternSyntaxException {
        // Edge case
        if (regex == null || regex.isEmpty()) return false;

        Pattern pattern = Pattern.compile(regex);
        return true;
    }
}
