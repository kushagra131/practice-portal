package com.Practice;

class Factorial {

	static double fact(double number){
		if(number >= 1){
			double result = number * fact(number - 1);
			System.out.println(result);
			return result;
		}
		else
			return 1;
	}

	static double factItr(double number) {
		if(number > 1) {
			double result = number;
			while(number > 1) {
				result = result * (number - 1);
				number--;
			}
			return result;
		}
		else {
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("MAX -> " + Double.MAX_VALUE + " , " + "MIN -> " + Double.MIN_VALUE);
		System.out.println(factItr(4));
	}
}
