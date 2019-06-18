package com.Practice;

import java.util.Arrays;

public class ReverseInteger {
	
	public int reverse(int x) {
		String str = String.valueOf(x);
		
		Object[] array = new Object[str.length()];
		int[] intArray = new int[str.length()];
		char[] chArray = new char[str.length()];
        System.out.println("Num -> " + str);
        
        int quotient = Math.abs(x);
        int i = 0;
        int digit;
        
        if(x < 0){
        	array[0] = (Object)str.charAt(0);
        	chArray[0] = (char) array[0];
        	i = 1;
        }
        
        while(i < array.length){
            
            System.out.println("I -> " + i);
            
            digit = quotient % 10;
            System.out.println("Digit -> " + digit);
            
            array[i] = digit;
            System.out.println("Array -> " + Arrays.toString(array));
            
            intArray[i] = Integer.parseInt(String.valueOf(array[i]));
            System.out.println("Int Array -> " + Arrays.toString(intArray));
            
            chArray[i] = (char)(intArray[i] + '0');
            System.out.println("Temp -> " + Arrays.toString(chArray));
            
            quotient = quotient / 10;
            System.out.println("Quotient -> " + quotient);
            i++;
        }
        System.out.println("Reverse Array -> " + Arrays.toString(intArray));
        String reverseNum = new String(chArray);
        System.out.println("Reverse String -> " + reverseNum);
        int reverse;
        
        try{
        	reverse = Integer.parseInt(reverseNum);
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        	return 0;
        }
        
        return reverse;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 98765;
		//ReverseInteger obj = new ReverseInteger();
		//int reverseNum = obj.reverse(x);
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
