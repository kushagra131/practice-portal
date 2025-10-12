package org.example.practice.interfaces;

import java.util.List;

public interface CodingInterface {

    public static String sayHi(String msg) {
        return msg;
    }

    /**
     * default()
     */
    public default String defaultMethod() {
        return "Default() Invoked";
    }

    String longestPalindromicSubsequence(String word);

    List<Integer> iDsOfSongs(int rideDuration, List<Integer> songDurations) throws IllegalArgumentException;

    boolean isUgly(int number);

    boolean isPrime(int number);

    int changeToAnandrome(String word);

    void fib(int n);

    boolean isPalindrome(String word);

    int maxConsecutiveOnes(int[] arr);
}
