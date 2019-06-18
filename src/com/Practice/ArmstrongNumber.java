package com.Practice;

public class ArmstrongNumber {
	
	static void isArmstrong(int number){
		
		int copyOfNumber = number;
		int sum=0;
		String numberString = String.valueOf(number);
		int length = numberString.length();
		System.out.println("Length is: " + length);
		
		while(copyOfNumber!=0){
			int lastDigit = copyOfNumber % 10;
			int multiplier = 1;
			for(int i=0; i<length; i++){
				multiplier = multiplier * lastDigit;
			}
			sum = sum + multiplier;
			copyOfNumber = copyOfNumber/10;
		}
		
		System.out.println("Number after calculation is: " + sum);
		
		if(sum == number){
			System.out.println(sum + " is Armstrong Number");
		}
		else{
			System.out.println(sum + " is not an Armstrong Nunber");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isArmstrong(153);
	}

}
