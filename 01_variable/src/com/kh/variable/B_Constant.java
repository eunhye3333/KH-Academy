package com.kh.variable;

public class B_Constant {
	public void finalConstant() {
		int age;
		final int AGE; // 대소문자를 구분하기 때문에 같은 단어임에도 다르게 인식함
		
		age = 20;
		AGE = 20;
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
		System.out.println("---------------------");
		
		// 변수 값 변경
		age = 30;
//		AGE = 30; 상수인 AGE에 이미 값이 들어가 있다고 오류가 뜸
		// The final local variable AGE may already have been assigned
		// : 상수 값 변경 불가
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
	}

}
