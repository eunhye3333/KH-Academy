package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {
	public void practice1() {
		// 홀수에는 박, 짝수에는 수 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			for(int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					System.out.print("박");
				} else {
					System.out.print("수");
				}
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}
	}

	public void practice2() {
		// 홀수에는 박, 짝수에는 수 출력
		// 틀릴 경우 다시 입력
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if(num <= 0) {
				System.out.println("양수가 아닙니다.");
			} else {
				break;
			}
			
		} while (true);

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 1) {
				System.out.print("박");
			} else {
				System.out.print("수");
			}
		}
	}
	
	public void practice3() {
		// 문자열을 입력받고 검색될 문자를 입력받아 해당 문자열에 그 문자가 몇 개 있는지 구하기
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		
		System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + count);
	}

	public void practice4() {
		// 문자열을 입력받고 검색될 문자를 입력받아 해당 문자열에 그 문자가 몇 개 있는지 구하기
		// 반복
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			System.out.print("문자 : ");
			char ch = sc.nextLine().charAt(0);
			
			int count = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ch) {
					count++;
				}
			}
			
			System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + count);
			
			boolean flag = true; 
			while(flag) {
				System.out.print("더 하시겠습니까? (y/n) : ");
				char re = sc.nextLine().charAt(0);
				switch(re) {
				case 'y':
				case 'Y':
					flag = false;
					break;
				case 'n':
				case 'N':
					System.out.println("종료합니다.");
					return;
				default :
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
				}
				
			}
		}
	}
}
