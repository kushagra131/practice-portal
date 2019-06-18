package com.Algorithms;

import java.util.Arrays;

public class RadixSort {
	
	static int getMax(int[] array, int length){
		int max = array[0];
		for(int i=1; i < length; i++){
			if(array[i] > max)
				max = array[i];
		}
		
		return max;
		
	}
	
	static void countSort(int[] array, int length, int exp){
		int[] count = new int[10];
		int[] outputArray = new int[length];
		
		//fill the count with 0
		for(int i=0; i < 10; i++){
			count[i] = 0;
		}
		
		//Store the count of occurrences of each digit
		for(int i=0; i < length; i++){
			count[(array[i]/exp) % 10]++;
		}
		System.out.println("Count[] -> " + Arrays.toString(count));
		
		//modify the count by adding count with previous
		for(int i=1; i<count.length; i++){
			count[i] = count[i-1] + count[i];
		}
		System.out.println("MD Count[] -> " + Arrays.toString(count));
		
		//fill in the outputArray
		for(int i=length - 1; i >= 0; i--){
			outputArray[count[(array[i]/exp) % 10] - 1] = array[i];
			count[(array[i]/exp) % 10]--;
		}
		
		//copy the outputArray to original array
		for(int i=0; i < length; i++){
			array[i] = outputArray[i];
		}
		System.out.println("Array -> " + Arrays.toString(array));
	}
	
	static void sort(int[] array, int length){
		
		int max = getMax(array, length);
		
		for(int exp=1; max/exp > 0; exp*=10){
			countSort(array, length, exp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {170, 45, 75, 90, 802, 24, 2, 66, 999, 767};
        int length = array.length;
        sort(array, length);
        System.out.println("Sorted Array -> " + Arrays.toString(array));
	}

}
