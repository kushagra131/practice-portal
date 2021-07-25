package com.Practice;

import java.util.*;

class Anagram {
	
//	static boolean isAnagram(String string1, String string2){
//		String s1 = string1.replaceAll("\\s", "");
//		String s2 = string2.replaceAll("\\s", "");
//
//		boolean status = true;
//
//		if(s1.length()!=s2.length()){
//			return false;
//		}
//		else{
//			char[] chArray1 = s1.toCharArray();
//			char[] chArray2 = s2.toCharArray();
//
//			Arrays.sort(chArray1);
//			Arrays.sort(chArray2);
//
//			status = Arrays.equals(chArray1, chArray2);
//		}
//		return status;
//	}

	static boolean isAnagram(String s, String t) {
		if((s == null || t == null) &&
				((s.length() < 1 || s.length() > 5*Math.pow(10,4)) ||
						(t.length() < 1 || t.length() > 5*Math.pow(10,4)))) {
			return false;
		}
		if(s.length() != t.length()) {
			return false;
		}
		else {
			s = s.toLowerCase();
			t = t.toLowerCase();
			int[] table = new int[26];

			Map<Character, Integer> map = new HashMap<>();
			for(int i = 0; i < s.length(); i++) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
				map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
//				table[s.charAt(i) - 'a']++;
//				table[t.charAt(i) - 'a']--;
			}

			map.forEach((k,v) -> System.out.println(k + ": " + v));
			for(Map.Entry<Character, Integer> entry: map.entrySet()) {
				if(entry.getValue() != 0)
					return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("keep","peek"));
	}

}
