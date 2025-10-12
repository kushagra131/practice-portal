package org.example.data_structures;

import java.util.Arrays;
import java.util.HashMap;

//test class with main()
class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children;
    private boolean bIsEnd;

    public TrieNode(char ch) {
        value = ch;
        children = new HashMap<>();
        bIsEnd = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public char getValue() {
        return value;
    }

    public void setIsEnd(boolean val) {
        bIsEnd = val;
    }

    public boolean isEnd() {
        return bIsEnd;
    }
}

// Implements the actual Trie 
class Trie {

    private TrieNode root;

    // Constructor 
    public Trie() {
        root = new TrieNode((char) 0);
    }

    // Method to insert a new word to Trie 
    public void insert(String word) {

        // Find length of the given word 
        int length = word.length();
        TrieNode crawl = root;
        System.out.println("\nInput -> " + word);

        // Traverse through all characters of given word 
        for (int level = 0; level < length; level++) {
            HashMap<Character, TrieNode> child = crawl.getChildren();
            //System.out.println("Child Map -> " + child.toString());

            char ch = word.charAt(level);
            System.out.println("Ch -> " + ch);

            // If there is already a child for current character of given word 
            if (child.containsKey(ch)) {
                System.out.println(ch + " -> already has a child");
                crawl = child.get(ch);
                System.out.println("Crawl has -> " + crawl.getValue() + "\nCrawl Child Map -> " + crawl.getChildren().toString());

            } else   // Else create a child
            {
                System.out.println(ch + " -> has no child");
                TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                crawl = temp;
            }
        }

        // Set bIsEnd true for last character 
        crawl.setIsEnd(true);
    }

    public String getMatchingPrefix(String input) {
        String result = ""; // Initialize resultant string 
        int length = input.length();  // Find length of the input string        

        // Initialize reference to traverse through Trie 
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse 
        // down the Trie 
        int level, prevMatch = 0;
        for (level = 0; level < length; level++) {
            // Find current character of str 
            char ch = input.charAt(level);

            // HashMap of current Trie node to traverse down 
            HashMap<Character, TrieNode> child = crawl.getChildren();

            // See if there is a Trie edge for the current character 
            if (child.containsKey(ch)) {
                result += ch;          //Update result
                crawl = child.get(ch); //Update crawl to move down in Trie

                // If this is end of a word, then update prevMatch
                if (crawl.isEnd()) prevMatch = level + 1;
            } else break;
        }

        // If the last processed character did not match end of a word, 
        // return the previously matching prefix 
        if (!crawl.isEnd()) return result.substring(0, prevMatch);

        else return result;
    }
}

public class Tries {
    public static void main(String[] args) {
        Trie dict = new Trie();

        String[] dictionary = {"xyz", "are", "area", "base", "cat", "cater", "children", "child", "basement"};

        for (int i = 0; i < dictionary.length; i++)
            dict.insert(dictionary[i]);

        System.out.println("\nDictionary -> " + Arrays.toString(dictionary));
	        /*dict.insert("are"); 
	        dict.insert("area"); 
	        dict.insert("base"); 
	        dict.insert("cat"); 
	        dict.insert("cater"); 
	        dict.insert("basement"); 
	  		*/

        String input = "caterer";
        System.out.print("\n" + input + ":   ");
        System.out.println("" + dict.getMatchingPrefix(input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "children";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));
    }
}



