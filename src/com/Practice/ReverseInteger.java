package com.Practice;

import java.util.Arrays;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 98765;
		// ReverseInteger obj = new ReverseInteger();
		int reverseNum = reverseNum(x);
		System.out.print("Reverse Number -> " + reverseNum);
	}
	
	//Efficient Method with O(log(x)) TC and O(1) SC without using Stack/Array DS
	private static int reverseNum(int x){
		int rev = 0;
		
		while(x != 0){
			int pop = x % 10;
			x = x / 10;
			if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			int temp = rev * 10 + pop;
			rev = temp;
		}
		return rev;
	}
	
}
