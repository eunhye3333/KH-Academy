package com.kh.hw.controller;

import java.util.Scanner;

public class Function {
	public void calculator() {
		// 계산기
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자(+, -, x, /) : ");
		char op = sc.next().charAt(0);
		
		switch(op) {
		case '+':
			System.out.printf("%d %c %d = %d%n", num1, op, num2, num1+num2);
			break;
		case '-':
			System.out.printf("%d %c %d = %d%n", num1, op, num2, num1-num2);
			break;
		case 'x':
			System.out.printf("%d %c %d = %d%n", num1, op, num2, num1*num2);
			break;
		case '/':
			if(num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				System.out.printf("%d %c %d = 0%n", num1, op, num2);
			} else {
				System.out.printf("%d %c %d = %d%n", num1, op, num2, num1/num2);
			}
			break;
		default :
			System.out.println("잘못된 연산자를 입력하였습니다.");
		}
	}
	
	public void totalCalculator() {
		// 작은 수에서 큰 수까지 합계
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		int min = 0;
		int max = 0;
		
		if(num1 >= num2) {
			min = num2;
			max = num1;
		} else {
			min = num1;
			max = num2;
		}
		
		int sum = 0;
		
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + "부터 " + max + "까지 정수들의 합 : " + sum);
	}
	
	public void printProfile() {
		// 신상 정보 확인
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("성격 : ");
		String character = sc.next();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("성격 : " + character);
	}
	
	public void printScore() {
		// 학생 정보 확인
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int iClass = sc.nextInt();
		System.out.print("번 : ");
		int num = sc.nextInt();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("성적 : ");
		double score = sc.nextDouble();
		
		gender = gender == 'F' ? '여' : '님';
		
		char cScore = '\u0000';
		if(score >= 90) {
			cScore = 'A';
		} else if (score >= 80) {
			cScore = 'B';
		} else if (score >= 70) {
			cScore = 'C';
		} else if (score >= 60) {
			cScore = 'D';
		} else {
			cScore = 'F';
		}
		
		System.out.printf("%d학년 %d반 %d번 %c학생 %s의 점수는 %.2f이고 %c학점입니다.%n", grade, iClass, num, gender, name, score, cScore);
	}
	
	public void printStarNumber() {
		// 별과 숫자 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num >= 1) {
			for(int i = 1; i <= num; i++) {
				for(int j = 1; j <= i; j++) {
					if(i == j) {
						System.out.print(i);
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	public void sumRandom() {
		// 난수까지의 합계
		int num = (int)(Math.random() * 100 + 1);
		
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1부터 " + num + "까지의 합 : " + sum);
	}
	
	public void exceptGugu() {
		// 구구단
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int dan = sc.nextInt();
		
		if(dan >= 1) {
			for(int i = 1; i < 10; i++) {
				if(i % dan != 0) {
					System.out.printf("%d * %d = %d%n", dan, i, dan*i);
				}
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	public void diceGame() {
		// 주사위 숫자 알아맞히기 게임
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("주사위 두 개의 합을 맞혀 보세요(1~12 입력) : ");
			int answer = sc.nextInt();
			
			int dice1 = (int)(Math.random() * 6 + 1);
			int dice2 = (int)(Math.random() * 6 + 1);
			
			if(dice1 + dice2 == answer) {
				System.out.println("정답입니다.");
				System.out.printf("주사위의 합 : %d + %d = %d%n", dice1, dice2, dice1+dice2);
				boolean flag = false;
				while(!flag) {
					System.out.print("계속 하시겠습니까?(y/n) : ");
					char re = sc.next().charAt(0);
					switch (re) {
					case 'y':
					case 'Y':
						flag = true;
						break;
					case 'n':
					case 'N':
						return;
					default:
						System.out.println("잘못 입력했습니다. 다시 입력하세요.");
					}
				}
			} else {
				System.out.println("틀렸습니다.");
			}
		}
	}
}
