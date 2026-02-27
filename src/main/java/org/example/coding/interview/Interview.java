package org.example.coding.interview;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Interview {
	
	public static void main(String[] args) {
        var sys = System.out;
		
		// --> Test Data
		var words = new String[]{"lc", "cl", "gg", "lc", "aa", "aa", "ab", "zz", "aa"};
		var matrix = new int[][]{{0,0,0,1}, {0,0,1,1}, {0,1,1,1}, {0,0,0,1}, {1,1,1,1}};
		
		switch (args[0]) {
			case "longestPalindrome":
				sys.println("Longest palindrome is: " + longestPalindrome(words));
				break;
			case "checkPattern":
				checkPattern();
				break;
				case "rowWithMaxOnes":
					sys.println("Row with max ones is: " + rowWithMaxOnes(matrix));
					break;
			default:
				break;
		}
	}
	
	/**
	 * <p>Finds the row in a binary matrix that has the maximum number of 1s.</p>
	 * <p>
	 * Matrix:
	 * 			{	{0,0,0,1},
	 * 				{0,0,1,1},
	 * 				{0,1,1,1},
	 * 				{0,0,0,1}	}
	 * </p>
	 * @param matrix A 2D array of integers, where each subarray represents a row of the matrix.
	 *               The matrix is expected to contain only 0s and 1s, and each row is sorted in non-decreasing order.
	 * @return The index of the row that contains the maximum number of 1s. If there are multiple rows
	 *         with the same maximum count, the method returns the index of the first such row. If the matrix
	 *         is empty, or if no 1s are present, the method returns -1. <br>
	 * <p>
	 *     TC - O(n * m), SC - O(1) <br>
	 *     where n is the number of rows and m is the number of columns.
	 * </p>
	 *
	 */
	public static int rowWithMaxOnes(int[][] matrix) {
		int y = matrix.length;
		int x = matrix[0].length;
		
		// --> As the 0's and 1's are in non-decreasing order,
		// --> start from top-right corner - (row, col) = (0, x-1)
		// --> if cell == 1 then move left
		// --> if cell == 0 then move down, row++
		// --> continue to check till bottom-left corner - (row, col) = (y-1, 0)
		int maxRows = -1;
		int col = x - 1;
		
		for (int row = 0; row < y; row++) {
			while (col >=0 && matrix[row][col] == 1) {
				col--;
				maxRows = row;
			}
		}
		
		return maxRows;
	}
	
	/**
	 * Given an array of words, return the longest palindrome that can be formed by any concatenation of the words. <br>
	 * <p>
	 * Input: words = ["lc","cl","gg"] <br>
	 * Output: "lcggcl"
	 * </p>
	 * <p>
	 * Input: words = ["lc","cl","gg","lc","aa","aa","ab"] <br>
	 * Output: "lcaaggaacl"
	 * </p>
	 * <p>
	 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6. <br>
	 * Note that "clgglc" is another longest palindrome that can be created.
	 * </p>
	 * <p>
	 * TC - O(n * l), SC - O(n * l) <br>
	 * where n is the number of words and l is the length of the longest word.
	 * </p>
	 */
	private static String longestPalindrome(String[] words) {
		// --> Edge Cases
		if (words == null || words.length == 0) return null;
		
		var sys = System.out;
		sys.println("Words List: " + Arrays.toString(words));
		
		// --> Iterate over words[] and fill the Map with word and their counts.
		Map<String, Integer> wordCounts = new HashMap<>();
		for (String word : words) {
			if (word != null && !word.isEmpty())
				wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
		}
		wordCounts.forEach((k, v) -> sys.println(k + " : " + v));
		
		// --> Iterate over Map and check if it contains the reverse of each word.
		StringBuilder sbLeft = null;
		StringBuilder sbRight = null;
		StringBuilder sbCenter = null;
		boolean isCenterPossible = true;
		Deque<String> deque = new ArrayDeque<>();
		
		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			String word = entry.getKey();
			String reverse = getReverse(word);
			
			// --> Case 1: If a word is a self-palindrome {"aa", "bb", "aa", ....}
			if (word.equals(reverse)) {
				// --> If the word is a palindrome, and it is not the center word.
				if (entry.getValue() > 1) {
					if (sbLeft == null)
						sbLeft = new StringBuilder(word);
					else
						sbLeft.append(word);
					deque.addFirst(word);
				}
				// --> If a word is a palindrome, and it is the center word (count == 1).
				else {
					if (isCenterPossible) {
						sbCenter = new StringBuilder(word);
						isCenterPossible = false;
					}
				}
			}
			// --> Case 2: IF a word is a regular word {"lc", "cl", "ab", ....}
			else if (wordCounts.containsKey(reverse)) {
				int count = Math.min(entry.getValue(), wordCounts.get(reverse));
				while (count-- > 0) {
					if (sbLeft == null)
						sbLeft = new StringBuilder(word);
					else
						sbLeft.append(word);
					deque.addFirst(reverse);
					wordCounts.put(word, wordCounts.get(word) - 1);
					wordCounts.put(reverse, wordCounts.get(reverse) - 1);
				}
			}
		}
		// --> Use the Deque as Stack (LIFO) and build the right string using Stack pop().
		while(!deque.isEmpty()) {
			if (sbRight == null)
				sbRight = new StringBuilder(deque.removeFirst());
			else
				sbRight.append(deque.removeFirst());
		}
		String longestPalindrome = null;
		if (sbLeft != null && sbRight != null)
			longestPalindrome = sbLeft.append(sbCenter).append(sbRight).toString();
		else if (sbLeft != null && isPalindrome(sbLeft.toString()))
			longestPalindrome = sbLeft.toString();
		else if (sbCenter != null && isPalindrome(sbCenter.toString()))
			longestPalindrome = sbCenter.toString();
		
		return longestPalindrome;
	}
	
	// --> A BiPredicate to check if the given key has a palindrome in the wordCounts map.
	private static final BiPredicate<Map<?,?>, String> checkKeyHasPalindrome =
			(map, key) -> map.containsKey(getReverse(key));
	
	private static String getReverse(String word) {
		if (word == null || word.isEmpty())
			throw new IllegalArgumentException("Word cannot be null or empty");
		
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString();
	}
	
	private static boolean isPalindrome(String word) {
		if (word == null || word.isEmpty()) return false;
		
		int index = 0;
		while (index < word.length() / 2) {
			if (word.charAt(index) != word.charAt(word.length() - 1 - index)) return false;
			index++;
		}
		return true;
	}
	
	/**
	 * Checks if the given regex pattern is valid or not.
	 * Input: number of test cases to run = 2
	 * Input: regex to test for validity
	 * Output: Valid or Invalid
	 */
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
