package com.Algorithms;

import java.util.Arrays;

public class CountingSort {
	
	void sort(int[] array){
		int length = array.length;
		
		//create a count[] of size equals Range+1 of distinct items in Array
		//Range is between 0-9, so 10
		int[] count = new int[10];
		
		int[] outputArr = new int[length];
		
		//initialize count[] with 0
		for(int i = 0; i < 10; ++i)
			count[i] = 0;
		
		//store Counts of all occurrences of the items in Array in Count[]
		for(int i = 0; i < length; i++)
			count[array[i]] = count[array[i]] + 1; 
		
		System.out.println("Count[] -> " + Arrays.toString(count));
		
		//modify the count[] by adding the previous counts
		for(int i = 1; i < count.length; i++)
			count[i] = count[i-1] + count[i];
		
		System.out.println("Count[] -> " + Arrays.toString(count));
		
		//place the items in the correct position in outputArr[] and decrease the count by 1 in count[]
		for(int i = 0; i < length; i++){
			outputArr[count[array[i]]-1] = array[i];
			count[array[i]] = count[array[i]] - 1;
		}
		
		//copy the outputArray[] to original array[]
		for(int i=0; i < length; i++){
			array[i] = outputArr[i];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,1,3,2,6,9,2,1,8,7,1};
		
		System.out.println("Array -> " + Arrays.toString(array));
		CountingSort obj = new CountingSort();
		obj.sort(array);
		System.out.println("Sorted[] -> " + Arrays.toString(array));

	}

}
