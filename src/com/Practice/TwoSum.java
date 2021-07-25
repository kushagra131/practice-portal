package com.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
	
	
	//Returns the Index of 2 numbers containing the Sum of 2 numbers equals to Target number
	static int[] twoSum(int[] nums, int target) {
		
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
        	
            int compliment = target - nums[i];
			System.out.println(Arrays.toString(nums));
            System.out.println("Target -> " + target);
            System.out.println("Compliment -> " + target + " - " + nums[i] + " = " + compliment);
            
            if(map.containsKey(compliment))
                return new int[] { map.get(compliment), i };
            
            map.put(nums[i], i);
            map.forEach((k, v) -> System.out.print("{" + k + ": " + v + "}, "));
            System.out.println("\n");
        } throw new IllegalArgumentException("\nNo Two Sum available");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 10, 25, 35, 60, 1, 59};
		int sum = 60;

		try{
			int[] indx = twoSum(nums, sum);
			System.out.println("Index -> " + Arrays.toString(indx));
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

}
