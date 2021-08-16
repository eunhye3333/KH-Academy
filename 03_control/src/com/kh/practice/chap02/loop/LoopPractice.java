package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	public void practice1() {
		// 한 개의 값을 입력받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = 1; i <= num; i++) {
				System.out.println(i);
			}
		}

	}
	
	public void practice2() {
		// 1 미만의 숫자가 입력됐다면 다시 값을 입력하도록
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
//		while(num < 1) {
//			System.out.print("1 이상의 숫자를 입력하세요 : ");
//			num = sc.nextInt();
//			if(num < 1) {
//				System.out.println("1 이상의 숫자를 입력해주세요");
//			}
//		}
		
		// flag 사용
		boolean flag = false;
		while(!flag) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
			if(num < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
			} else {
				flag = true;
			}
		}
		
		for(int i = 1; i <= num; i++) {
			System.out.println(i);
		}
	}
	
	public void practice3() {
		// 한 개의 값을 입력받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
//			for(int i = num; i >= 1; i--) {
//				System.out.println(i);
//			}
			
//			for(int i = 0; i < num; i++) { // i++ 사용
//				System.out.println(num - i);
//			}
			
			for(; num >= 1; num--) { // 새로운 변수 선언하지 않기
				System.out.println(num);
			} 
		}
	}
	
	public void practice4() {
		// 1 미만의 숫자 입력 시 재출력
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(num < 1) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
			if(num < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요");
			}
		}
		
		for(; num >= 1; num--) {
			System.out.println(num);
		}
	}
	
	public void practice5() {
		// 1부터 입력받은 수까지의 합을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요(2 이상) : ");
		int num = sc.nextInt();
		int sum = 0;
		
//		if(num >= 2) {
//			for(int i = 1; i <= num; i++) {
//				if(i < num) {
//					System.out.print(i + " + ");
//				} else {
//					System.out.print(i + " = ");
//				}
//				sum += i;
//			}
//			System.out.print(sum);
//		} else {
//			System.out.println("잘못 입력하였습니다");
//		}
		
		// 숫자를 따로
		if(num >= 2) {
			for(int i = 1; i <= num; i++) {
				System.out.print(i);
				if(i < num) {
					System.out.print(" + ");
				} else {
					System.out.print(" = ");
				}
				sum += i;
			}
			System.out.print(sum);
		} else {
			System.out.println("잘못 입력하였습니다");
		}
	}
	
	public void practice6() {
		// 두 개의 값을 입력받아 그 사이의 숫자 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		int start = 0;
		int end = 0;
		
		if (num1 == 0 || num2 == 0) {
			System.out.println("1 이상의 숫자를 입력하세요");
		} else {
			if(num1 <= num2) {
				start = num1;
				end = num2;
			} else {
				start = num2;
				end = num1;
			}
			
			for(; start <= end; start++) {
				System.out.println(start);
			}
		}
	}
	
	public void practice7() {
		// 두 개의 값을 입력받아 그 사이의 숫자 출력
		// 1 미만의 숫자가 입력되면 다시 입력하도록
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		
		while(num1 < 1 || num2 < 1) {
			System.out.print("첫 번째 숫자 : ");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			num2 = sc.nextInt();
			
			if(num1 < 1 || num2 < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
		
		int start = 0;
		int end = 0;
		if(num1 <= num2) {
			start = num1;
			end = num2;
		} else {
			start = num2;
			end = num1;
		}
		
		for(; start <= end; start++) {
			System.out.println(start);
		}
	}
	
	public void practice8() {
		// 입력받은 숫자의 단 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		System.out.println("============ " + dan + "단 ============");
//		for(int i = 1; i < 10; i++) {
//			System.out.printf("%d * %d = %d%n", dan, i, dan*i);
//		}
		
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %2d%n", dan, i, dan*i);
			// 오른쪽 정렬
		}
		
	}
	
	public void practice9() {
		// 입력받은 숫자의 단 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		if(dan > 9) {
			System.out.println("9 이하의 숫자만 입력해 주세요");
		} else {
			for(; dan < 10; dan++) {
				System.out.println("======== " + dan + "단 ========");
				for(int i = 1; i < 10; i++) {
					System.out.printf("%d * %d = %d%n", dan, i, dan * i);
				}
			}
			
		}
	}
	
	public void practice10() {
		// 잘못 입력했을 경우 다시 입력
		Scanner sc = new Scanner(System.in);
		int dan = 0;
		while(dan < 2 || dan > 9) {
			System.out.print("숫자 : ");
			dan = sc.nextInt();
			if (dan < 2 || dan > 9) {
				System.out.println("2 이상, 9 이하의 숫자만 입력해 주세요.");
			}
		}
		
		for(; dan < 10; dan++) {
			System.out.println("======== " + dan + "단 ========");
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d%n", dan, i, dan * i);
			}
		}
	}
	
	public void practice11() {
		// 시작 숫자와 공차를 입력받아 일정한 값으로 숫자가 커지거나 작아지게 하세요
		// 출력되는 숫자 -> 10개
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		System.out.print("공차 : ");
		int gap = sc.nextInt();
		
//		for(int i = 0; i < 10; i++) {
//			System.out.print(start + gap * i + " ");
//		}
		
		
		// 변수 선언 없이
		int end = start + 10 * gap;
		for(; start < end; start += gap) {
//		for(; start < start + 10 * gap; start += gap) { // 하면 안 됨
			System.out.print(start + " ");
		}
	}
	
	public void practice12() {
		// 정수 두 개와 연산자를 입력받아 알맏은 결과 출력
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String op= sc.next();
			
			System.out.print("정수  1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수 2 : ");
			int num2 = sc.nextInt();
			
			switch(op) {
			case "+" :
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 + num2);
				return;
			case "-" :
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 - num2);
				return;
			case "*" :
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 * num2);
				return;
			case "/" :
				if (num2 == 0) {
					System.out.println("0으로는 나눌 수 없습니다. 다시 입력해주세요.");
				} else {
					System.out.printf("%d %s %d = %d", num1, op, num2, num1 / num2);
					return;
				}
				break;
			case "%" :
				if (num2 == 0) {
					System.out.println("0으로는 나눌 수 없습니다. 다시 입력해주세요.");
				} else {
					System.out.printf("%d %s %d = %d", num1, op, num2, num1 % num2);
					return;
				}
				break;
			case "exit":
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void practice13() {
		// 별 찍기
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int line = sc.nextInt();
		
		for(int i = 1; i <= line; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice14() {
		// 별 찍기 (역으로)
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int line = sc.nextInt();
		
//		for(int i = line; i > 0; i--) {
//			for(int j = i; j > 0; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 변수 선언 없이
		for(; line > 0; line--) {
			for(int j = line; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
