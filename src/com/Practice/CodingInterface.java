package com.Practice;

import java.util.List;

public interface CodingInterface {

    /**
     * default()
     */
    default void defaultMethod() {
        System.out.println("Default() Coding Interface");
    }

    List<Integer> lengthSubsequenceShoppers(List<Character> inputList);

    /**
     * Two Sum variation
     * @param rideDuration
     * @param songDurations
     * @return
     */
    List<Integer> iDsOfSongs(int rideDuration, List<Integer> songDurations) throws IllegalArgumentException;

    /**
     * Method to check if number is only divisible by prime factors 2,3 & 5 only.
     * @param number
     * @return isUgly number true
     */
    boolean isUgly(int number);

    /**
     * Methods checks number is Prime or not
     * @param number
     * @return
     */
    boolean isPrime(int number);

    /**
     * This () returns the count of characters required to make
     * the input String as Palindrome & Anagram.
     * @param word
     * @return
     */
    int changeToAnandrome(String word);

    /**
     * Fibonacci Series()
     * @param n
     */
    void fib(int n);

    /**
     * isPalindrome()
     * @param word
     * @return
     */
    boolean isPalindrome(String word);

    /**
     * maxConsecutiveOnes
     * @param arr
     * @return
     */
    int maxConsecutiveOnes(int[] arr);
}
