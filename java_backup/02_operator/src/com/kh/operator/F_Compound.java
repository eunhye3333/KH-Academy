package com.kh.operator;

public class F_Compound {
	public void method() {
		int num = 12;
		
		System.out.println("num : " + num);
		
//		num = num + 3;
		num += 3;
		System.out.println("num : " + num);
		
//		num = num - 5;
		num -= 5;
		System.out.println("num : " + num);

//		num = num * 6;
		num *= 6;
		System.out.println("num : " + num);
		
//		num = num / 2;
		num /= 2;
		System.out.println("num : " + num);
		
//		num = num % 4;
		num %= 4;
		System.out.println("num : " + num);		
	}
}
