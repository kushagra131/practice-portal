package com.Practice;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class CodingInterfaceImpl implements CodingInterface{

    public static void main(String[] args) {
        List<Integer> songsDuration = new ArrayList<>();
        songsDuration.add(1);
        songsDuration.add(20);
        songsDuration.add(35);
        songsDuration.add(25);
        songsDuration.add(59);
        songsDuration.add(60);
        int[] numbers = {1, 12, 99, 100, 23, 37, 43, 30, 15, 30, 19, 210};
        int[] binaryArr = {1, 1, 0, 0, 0, 1};

        CodingInterface obj = new CodingInterfaceImpl();
//        try {
//            System.out.println(obj.IDsOfSongs(90, songsDuration));
//        }
//        catch(IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

//        for(int i=0; i < numbers.length; i++) {
//    		System.out.println("number -> " + numbers[i] + ", " + obj.isUgly(numbers[i]));
//			System.out.println("-------------------------");
//		  }

//        System.out.println(obj.isPalindrome("  ab cb a  "));
        System.out.println(obj.longestPalindromicSubsequence("rdbfgbaaa"));
//        System.out.println(obj.changeToAnandrome("abaab"));
//        System.out.println(maxConsecutiveOnes(binaryArr));
//		  Scanner scanner = new Scanner(System.in);
//		  System.out.print("Enter a number for Fibonacci Series -> ");
//		  int n = scanner.nextInt();
//		  fib(n);
    }

    public String longestPalindromicSubsequence(String word) {
        Set<String> set = new HashSet<>();
        for(int i=0; i < word.length(); i++) {
            for(int j=i+1; j <= word.length(); j++) {
                set.add(word.substring(i,j));
            }
        }
        int length = Integer.MIN_VALUE;
        String longestPalindromicSubsequence = "";

        for(String element : set) {
            if(isPalindrome(element) && length < element.length()) {
                length = element.length();
                longestPalindromicSubsequence = element;
            }
        }

        return longestPalindromicSubsequence;
    }

    /**
     * Two Sum variation
     * @param rideDuration
     * @param songDurations
     * @return indices of numbers
     */
    public List<Integer> iDsOfSongs(int rideDuration, List<Integer> songDurations) {
        // WRITE YOUR CODE HERE
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int target = rideDuration - 30;
        int i = 0;
        while(i < songDurations.size()){
            int compliment = target - songDurations.get(i);
            if(map.containsKey(compliment)){
                list.add(map.get(compliment));
                list.add(i);
                return list;
            }
            map.put(songDurations.get(i), i);
            i++;
//            map.forEach((k, v) -> System.out.print(k + ": " + v + ", "));
//            System.out.println();
        } throw new IllegalArgumentException("\n" + "ID's not found!!");
        // return list;
    }

    /**
     * Method to check if number is only divisible by prime factors 2,3 & 5 only.
     * @param number
     * @return isUgly number true
     */
    public boolean isUgly(int number) {
        int i = 2;
        int count = 0;

        if(number == 1)
            return true;
        else {
            while(i <= number && isPrime(i) && number%i == 0) {
                if(i == 2 || i == 3 || i == 5)
                    count++;
                i++;
            }
            System.out.println("count -> " + count);
        }
        if(count <= 3)
            return true;
        return false;
    }

    /**
     * Methods checks number is Prime or not
     * @param number
     * @return
     */
    public boolean isPrime(int number) {
        int i = 2;
        int count = 0;
        while(i <= number) {
            if(number == 1)
                return false;
            if(i == number && number % i == 0)
                count++;
            else if(i != number && number % i == 0)
                count++;
            i++;
        }
        if(count > 1)
            return false;
        else
            return true;
    }

    /**
     * This () returns the count of characters required to make
     * the input String as Palindrome & Anagram.
     * @param word
     * @return
     */
    public int changeToAnandrome(String word) {
        System.out.println("Word -> " + word);
        if(word == null || word.length() == 0)
            return -1;
        else {
            int count = 0;
            int idx = 0;
            Map<Character, Integer> map = new HashMap<>();
            while(idx < word.length()) {
                if(map.containsKey(word.charAt(idx))) {
                    count++;
                }
                map.put(word.charAt(idx), count);
                // count--;
                idx++;
            }
            map.forEach((k,v) -> System.out.println("{" + k + ":" + v + "}"));
            return count;
        }
    }

    /**
     * Fibonacci Series()
     * @param n
     */
    public void fib(int n) {
        if(n < 2)
            System.out.println("Series cannot be printed!!");
        else {
            int fib1 = 0, fib2 = 1;
            int i = 1;

            System.out.print(fib1 + " " + fib2 + " ");
            while(i <= n - 2) {
                int sum = 0;
                sum = fib1 + fib2;
                fib1 = fib2;
                fib2 = sum;
                System.out.print(fib2 + " ");
                i++;
            }
        }
    }

    /**
     * isPalindrome()
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {

        if(word == null || word.length() == 0)
            return false;
        else {
            // boolean isValid = Pattern.matches("[abc]", word);
            word = word.replaceAll(" ", "").toLowerCase();
            // System.out.println("Word -> " + word);
            int low = 0, high = word.length() - 1;
            while(low <= high) {
                if(word.charAt(low) != word.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }

    /**
     * maxConsecutiveOnes
     * @param arr
     * @return
     */
    public int maxConsecutiveOnes(int[] arr) {
        int start_ptr = 0;
        int end_ptr = 0;
        int prev_count = 0;
        int curr_count = 0;
        int max_count = Integer.MIN_VALUE;

        int i = 0;
        while(i < arr.length) {
            if(arr[start_ptr] != 1 && arr[end_ptr] != 1) {
                i++;
                end_ptr = i;
                start_ptr = i;
            }
            else if(arr[start_ptr] == 1 && arr[end_ptr] == 1) {
                curr_count++;
                i++;
                end_ptr = i;
            }
            else {
                start_ptr = end_ptr;
                prev_count = curr_count;
                if(max_count <= prev_count)
                    max_count = prev_count;
                curr_count = 0;
            }
        }
        return (max_count <= curr_count) ? curr_count : max_count;
    }
}
