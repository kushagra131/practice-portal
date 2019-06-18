package com.Practice;

public class Factorial {
	
	private static double number = 10;
	
	static double fact(double number){
		if(number >= 1){
			double result = number * fact(number - 1);
			System.out.println(result);
			return result;
		}
		else
			return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MAX -> " + Double.MAX_VALUE + " , " + "MIN -> " + Double.MIN_VALUE);
		System.out.println("Factorial of " + number + " is -> " + fact(number));
	}
}
