package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	public void method1() {
		// 입력한 정수값이 1부터 100 사이의 숫자인지 확인하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		// 입력한 숫자가 1~100 사이다
		// = 입력한 숫자가 1보더 크거나 같고 100보다 작거나 같다
		// =                   &&
		// = num >= 1 && num <= 100
		System.out.println("1부터 100 사이의 숫자인지 확인 : " + (num >= 1 && num <= 100));
	}
	
	public void method2() {
		// 입력한 문자 값이 대문자인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 하나 입력 : ");
//		String strCh = sc.nextLine(); 
//		char ch = strCh.charAt(0);
		char ch = sc.nextLine().charAt(0); // 위 두 줄과 같은 내용임. strCh는 sc.nextLine()의 내용을 가지고 있기 때문에 -> 치환
		// 이렇게 써도 줄바꿈 문자까지 저장되는 것은 아니고 순수 데이터만 저장됨
		
		System.out.println("영어 대문자가 맞습니까? : " + (ch >= 'A' && ch <= 'Z')); // 문자는 숫자랑 호환되기 때문에 범위 가능
		
		System.out.print("계속하시려면 Y 또는 y를 입력하세요 : ");
		char ch2 = sc.nextLine().charAt(0);
		
		System.out.println("계속하겠다고 했습니까? : " + (ch2 == 'Y' || ch2 == 'y'));
	}
	
	public void method3() {
		int a = 2;
		int b = 3;
		
		boolean c = a > b;
		boolean d = ++a <= b++;
		
		System.out.println("a : " + a); // 3
		System.out.println("b : " + b); // 4
		System.out.println("c : " + c); // false
		System.out.println("d : " + d); // true
		
		System.out.println();
		
		System.out.println("!c : " + !c); // true
		System.out.println("c != d : " + (c != d)); // true
		
		System.out.println();
		
		System.out.println("(a % b ) == 1 : " + ((a % b ) == 1)); // false (3 % 4 == 3)
		System.out.println("(a == 3) && (b == 4) : " + ((a == 3) && (b == 4))); // true
		System.out.println("!d || (a - b) > 0 : " + (!d || (a - b) > 0)); // false
		
		System.out.println(!(c == d) && ((a * b == 10) || (b % 2 ==0)));
		//                  !(false)         (false)   ||    (true)
		//                    true    &&              true
		//                           true
	}
}
