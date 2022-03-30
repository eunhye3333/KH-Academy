package com.kh.variable;

public class A_Variable {
	public void declareVariable() {
		// 변수 선언 후 초기화
		// A. 변수 선언 :Stack 영역에 공간을 생성(할당)하는 것 -> 자료형 변수명;
		// 1. 논리형
		boolean isTrue;
		
		// 2. 숫자형
		// 2-1. 정수형
		byte bNum;
		short sNum;
		int iNum;
		long lNum;
		
		// 2-2. 싷수형
		float fNum;
		double dNum;
		
		// 3. 문자형
		// 3-1. 문자
		char ch;
		
		// 3-2. 문자열
		String str;

		// B. 초기화 (대입)
		isTrue = false; // true, false만 대입 가능 다른 값 대입 시 오류 발생

		bNum = 1;
		sNum = 2;
		iNum = 4;
		lNum = 8L; // long 값인 것을 알려주기 위해

		fNum = 4.0f;
		dNum = 8.0d;

		ch = 'A'; 
		str = "A"; 

		System.out.println("isTrue의 값 : " + isTrue);

		System.out.println("bNum의 값 : " + bNum);
		System.out.println("sNum의 값 : " + sNum);
		System.out.println("iNum의 값 : " + iNum);
		System.out.println("lNum의 값 : " + lNum);

		System.out.println("fNum의 값 : " + fNum);
		System.out.println("dNum의 값 : " + dNum);

		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
	}

	public void initVariable() {
		// 변수 선언과 동시에 초기화
		// 1. 논리형
		boolean isTrue = true; // 위에 isTrue를 썼는데도 에러가 안 나는 이유: 메소드가 달라서. 지역이 다름.
		
		// 2. 숫자형
		// 2-1. 정수형
		byte bNum = 1;
		short sNum = 2;
		int iNum = 4;
		long lNum = 8L;
		
		// 2-2. 싷수형
		float fNum = 4.0f;
		double dNum = 8.0;
		
		// 3. 문자형
		// 3-1. 문자
		char ch = '박';
		
		// 3-2. 문자열
		String str = "신우";
		
		System.out.println("isTrue의 값 : " + isTrue);

		System.out.println("bNum의 값 : " + bNum);
		System.out.println("sNum의 값 : " + sNum);
		System.out.println("iNum의 값 : " + iNum);
		System.out.println("lNum의 값 : " + lNum);

		System.out.println("fNum의 값 : " + fNum);
		System.out.println("dNum의 값 : " + dNum);

		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
	}
}
