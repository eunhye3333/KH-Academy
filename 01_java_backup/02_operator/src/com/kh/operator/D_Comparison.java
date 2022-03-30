package com.kh.operator;

public class D_Comparison {
	public void method() {
		int a = 10; 
		int b = 25;
		boolean result1;
		boolean result2;
		boolean result3;
		
		result1 = (a == b);
		result2 = a <= b;
		result3 = (a > b);
		
		System.out.println(result1); // false
		System.out.println(result2); // true
		System.out.println(result3); //false
		
		System.out.println("b가 짝수인가? : " + ((b % 2) == 0) );
		System.out.println("b가 홀수인가? : " + ((b % 2) == 1) );
		System.out.println("b가 홀수인가? : " + ((b % 2) != 0) );
		System.out.println("b가 홀수인가? : " + !((b % 2) == 0) );
	}
}
