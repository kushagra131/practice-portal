package com.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	int index;
	
	//Recursive approach for Binary Search, TC O(LogN), SC O(LogN)
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
	
	//Iterative approach for Binary Search, TC O(LogN), SC O(1)
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] array = {2, 3, 5, 12, 15, 55, 67, 99};
		System.out.print("Array is --> " + Arrays.toString(array));
		
		System.out.print("\nEnter the Element to Search: ");
		int element = input.nextInt();
		
		//do binarySearch on the array -> get the index
		int index = binarySearch(array, 0, array.length - 1, element);
		//int index = binarySearch(array, element);
		
		if(index == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found -> " + array[index] + " at index: " + index); 
		input.close();
	}

}
