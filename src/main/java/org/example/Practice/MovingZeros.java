package com.Practice;

import java.util.Arrays;

public class MovingZeros {
	
	static void movingZerosToLeft(int[] array){
		int length = array.length;
		int[] tempArray = new int[length];
		int count =0;
		
		for(int i=0; i<length; i++){
			if(array[i]!=0){
				tempArray[count]=array[i];
				count++;
			}
		}
		while(count<length){
			tempArray[count]=0;
			count++;
		}
		System.out.println("TempArray is: " + Arrays.toString(tempArray));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {14,0,11,2,3,4,0,4,0,34,0,23,67,0,99};
		movingZerosToLeft(array1);
	}

}
