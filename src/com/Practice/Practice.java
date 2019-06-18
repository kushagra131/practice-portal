package com.Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Practice {
	
	private static List<Integer> lengthSubsequenceShoppers(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < inputList.size(); i++){
			if(map.containsKey(inputList.get(i))){
				map.put(inputList.get(i), i);
				list.add(i+1);
			}
			else
				map.put(inputList.get(i), 1);
		}
		System.out.println("CH MAP ->> " + map);
		return list;
    }
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	private static List<Integer> IDsOfSongs(int rideDuration, 
	                              List<Integer> songDurations)
	{
		// WRITE YOUR CODE HERE
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map <Integer, Integer> map = new HashMap<Integer, Integer>();
		int target = rideDuration - 30;
		for(int i = 0; i < songDurations.size(); i++){
		    
		    int compliment = target - songDurations.get(i);
		    if(map.containsKey(compliment) && list.size() < 2){
		        list.add(map.get(compliment));
		        list.add(i);
		    }
		    map.put(songDurations.get(i), i);
		        
		}
		System.out.println("MAP->> " + map);
		return list;
	}
	// METHOD SIGNATURE ENDS
	public static void main(String[] args){
		int rideDuration = 90;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(25);
		list.add(35);
		list.add(50);
		//list.add(35);
		
		List<Character> chList = new ArrayList<Character>();
		chList.add('a');
		chList.add('b');
		chList.add('c');
		chList.add('a');
		chList.add('a');
		chList.add('b');
		chList.add('c');
		chList.add('a');
		//list.add(50);
		
		
		//Practice obj = new Practice();
		System.out.println("List->> "+ list);
		
		System.out.println(IDsOfSongs(rideDuration, list));
		
		System.out.println("Ch List ->> " + chList);
		System.out.println(lengthSubsequenceShoppers(chList));
	}
}