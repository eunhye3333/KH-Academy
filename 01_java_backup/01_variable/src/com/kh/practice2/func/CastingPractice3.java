package com.kh.practice2.func;

public class CastingPractice3 {
	public void method() {
		// 선언 및 소기화된 5개의 변수를 가지고 알맞은 사칙연산과 형변환을 이용하여 주석에 적힌 값과 같은 값이 나오도록 코드를 작성하세요
		
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2); // 2
		System.out.println(iNum1 % iNum2); // 2

		System.out.println(iNum2 * dNum); // 10.0
		System.out.println(fNum * dNum + dNum); // 10.0
		
		System.out.println((double)iNum1 / iNum2); // 2.5
		System.out.println(dNum); // 2.5
		
		System.out.println(iNum1 / (int)fNum); // 3
		System.out.println((int)fNum); // 3
		
		System.out.println(iNum1 / fNum); // 3.333333
		System.out.println((iNum1 / (double)fNum)); // 3.3333333333333335
		
		System.out.println(ch); // 'A'
		System.out.println((int)ch); // 65
		System.out.println(ch + iNum1); // 75
		System.out.println((char)(ch + iNum1)); // 'K'
	}
}
