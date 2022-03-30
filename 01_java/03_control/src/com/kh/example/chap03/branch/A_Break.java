package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	public void method() {
		// 문자열을 입력 받아 글자 개수를 출력하는 반복 프로그램
		// 단, end가 입력되면 반복 종료
		Scanner sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.print("문자열 입력 : ");
//			String str = sc.nextLine();
//			System.out.println(str.length());
//			
//			if(str.equals("end")) {
//				break;
//			}
//		}
		
//		String str = "";
//		while(!str.equals("end")) {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("글자 개수 : " + str.length());
//		}
		
		// break 사용
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("end")) {
				break;
			}
			
			System.out.println("글자 개수 : " + str.length());
		}
	}
}
