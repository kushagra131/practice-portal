package com.Practice;

import java.util.Arrays;

public class Anagram {
	
	static void isAnagram(String string1, String string2){
		String s1 = string1.replaceAll("\\s", "");
		String s2 = string2.replaceAll("\\s", "");
		
		boolean status = true;
		
		if(s1.length()!=s2.length()){
			status = false;
		}
		else{
			char[] chArray1 = s1.toCharArray();
			char[] chArray2 = s2.toCharArray();
			
			Arrays.sort(chArray1);
			Arrays.sort(chArray2);
			
			status = Arrays.equals(chArray1, chArray2);
		}
		if(status!=false){
			System.out.println(s1 + " and " + s2 + " are Anagrams");
		}
		else{
			System.out.println(s1 + " and " + s2 + " are not Anagrams");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isAnagram(" k e e p  ","  p e e k ");
	}

}
