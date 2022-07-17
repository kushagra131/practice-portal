package com.Practice;

import java.util.List;

public interface CodingInterface {

    /**
     * default()
     */
    public default String defaultMethod() {
        return "Default() Invoked";
    }

    public static String sayHi(String msg) {
        return msg;
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
