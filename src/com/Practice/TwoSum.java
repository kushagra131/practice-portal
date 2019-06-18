package com.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	
	//Returns the Index of 2 indexes containing the Sum of 2 numbers equals to Target number
	private static int[] twoSum(int[] nums, int target) {
		
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
        	
            int compliment = target - nums[i];
            System.out.println("Compliment -> " + target + " - " + nums[i] + " = " + compliment);
            
            if(map.containsKey(compliment))
                return new int[]{map.get(compliment), i};
            
            map.put(nums[i], i);
            System.out.println("Map -> " + map + "\n");
        } throw new IllegalArgumentException("\nNo Two Sum available");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 10, 25, 35, 60, 1};
		int sum = 60;
		
		//TwoSum obj = new TwoSum();
		System.out.println("Array - > " + Arrays.toString(nums));
		
		try{
			int[] indx = twoSum(nums, sum);
			System.out.println("Index -> " + Arrays.toString(indx));
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

}
