package com.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Search {
	
	//Recursive approach for Binary Search, 
	//TC = O(logN)
	//SC = O(N), AuxSC = O(logN)
	private static int binarySearch(int[] array, int left, int right, int element){
		if(left <= right){
			int mid = left + (right - left)/2;
			
			if(array[mid] == element)
				return mid;
				
			//Mid > Element, then recur for Left Half
			if(array[mid] > element)
				return binarySearch(array, left, mid-1, element);
			
			//Else recur for Right Half as it can only be present in Right Half
			return binarySearch(array, mid+1, right, element);
		}
		return -1;
	}
	
	//Iterative approach for Binary Search, 
	//TC = O(logN)
	//SC = O(N), AuxSC = O(1)
	private static int binarySearch(int[] array, int element){
		int left = 0, right = array.length-1;
		
		while(left <= right){
			int mid = left + (right - left)/2;
			
			if(array[mid] == element)
				return mid;
			if(array[mid] > element)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
	
	//Jump Search falls between Linear Search and Binary Search
	//TC = O(N^1/2)
	//SC = O(N), AuxSC = O(1)
	private static int jumpSearch(int[] array, int x) 
    { 
        int n = array.length; 
        int step = (int)Math.floor(Math.sqrt(n)); // Block size to be jumped, optimal is Square Root N
  
        // Finding the block where element is 
        // present (if it is present) 
        int prev = 0; 
        while (array[Math.min(step, n)-1] < x) 
        { 
            prev = step; 
            step = step + (int)Math.floor(Math.sqrt(n));
            if (prev >= n) 
                return -1; 
        } 
  
        // Doing a linear search for x in block 
        // beginning with prev.
        while (array[prev] < x) 
        { 
            prev++; 
  
            // If we reached next block or end of 
            // array, element is not present. 
            if (prev == Math.min(step, n)) 
                return -1; 
        } 
  
        // If element is found 
        if (array[prev] == x) 
            return prev; 
  
        return -1; 
    }
	
	//Interpolation Search better than Binary Search if elements are evenly distributed, 
	//TC = Average -> O(log log N), Worst -> O(N)
	//SC = O(N), AuxSC = O(1)
	private static int interpolationSearch(int[] array, int element){
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right && element >= array[left] && element <= array[right]){
			if(left == right)
				return left;
			
			//calculate probing position
			int pos = left + (((right - left) / (array[right] - array[left])) * (element - array[left]));
			if(array[pos] == element)
				return pos;
			
			//element present in right part of pos
			if(array[pos] < element)
				left = pos + 1;
			
			//else element present in left part of pos
			else
				right = pos - 1;
		}
		return -1;
	}
	
	//Exponential Search
	//TC = O(log N),
	//SC = O(N), AuxSC = O(logN) for Recursive Binary Search
	//SC = O(N), AuxSC = O(1) for Iterative Binary Search
	private static int exponentialSearch(int[] array, int element){
		if(array[0] == element)
			return 0;
		
		int i = 1; //start with sub array size 1
		
		//increase i = i*2
		while (i < array.length && array[i] <= element)
			i = i*2;
		
		//Recursive Binary Search
		return binarySearch(array, i/2, Math.min(i, array.length - 1), element);
		
		//Iterative Binary Search
		//return binarySearch(array, element);
	}
	
	//Recursive Ternary Search - variation of Binary Search, divides the array in 3 parts
	//TC = O(log N)
	//SC = O(N), AuxSC = O(log N)
	private static int ternarySearch(int[] array, int left, int right, int element){
		if(left <= right){
			int mid1 = left + (right - left) / 3;
			int mid2 = mid1 + (right - mid1) / 3;
			
			if(array[mid1] == element)
				return mid1;
			if(array[mid2] == element)
				return mid2;
			if(array[mid1] > element)
				return ternarySearch(array, left, mid1 - 1, element);
			if(array[mid2] > element)
				return ternarySearch(array, mid1+1, mid2-1, element);
			else
				return ternarySearch(array, mid2+1, right, element);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int index;
		int[] array = {2, 3, 5, 12, 15, 55, 67, 99};
		Scanner input = new Scanner(System.in);
		
		//Sorted Array for Searching Algo
		System.out.println("Array is --> " + Arrays.toString(array));
		System.out.println("Array Length --> " + array.length);
		
		System.out.print("\nEnter the Element to Search: ");
		int element = input.nextInt();
		
		//do binarySearch on the array -> get the index
		//index = binarySearch(array, 0, array.length - 1, element);
		//index = binarySearch(array, element);
		//index = jumpSearch(array, element);
		//index = interpolationSearch(array, element);
		//index = exponentialSearch(array, element);
		index = ternarySearch(array, 0, array.length-1, element);
		
		System.out.println((index < 0) ? "Element Not Present" : "Element present at " + index);
		input.close();
	}

}
