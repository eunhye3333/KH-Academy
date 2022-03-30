package com.kh.hw.controller;

import java.util.Scanner;

public class Function {
	public void calculator() {
		// ����
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		System.out.print("������(+, -, x, /) : ");
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
				System.out.println("0���� ���� �� �����ϴ�.");
				System.out.printf("%d %c %d = 0%n", num1, op, num2);
			} else {
				System.out.printf("%d %c %d = %d%n", num1, op, num2, num1/num2);
			}
			break;
		default :
			System.out.println("�߸��� �����ڸ� �Է��Ͽ����ϴ�.");
		}
	}
	
	public void totalCalculator() {
		// ���� ������ ū ������ �հ�
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
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
		System.out.println(min + "���� " + max + "���� �������� �� : " + sum);
	}
	
	public void printProfile() {
		// �Ż� ���� Ȯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();
		System.out.print("���� : ");
		String gender = sc.next();
		System.out.print("���� : ");
		String character = sc.next();
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("���� : " + gender);
		System.out.println("���� : " + character);
	}
	
	public void printScore() {
		// �л� ���� Ȯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�г� : ");
		int grade = sc.nextInt();
		System.out.print("�� : ");
		int iClass = sc.nextInt();
		System.out.print("�� : ");
		int num = sc.nextInt();
		System.out.print("����(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("���� : ");
		double score = sc.nextDouble();
		
		gender = gender == 'F' ? '��' : '��';
		
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
		
		System.out.printf("%d�г� %d�� %d�� %c�л� %s�� ������ %.2f�̰� %c�����Դϴ�.%n", grade, iClass, num, gender, name, score, cScore);
	}
	
	public void printStarNumber() {
		// ���� ���� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
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
			System.out.println("����� �ƴմϴ�.");
		}
	}
	
	public void sumRandom() {
		// ���������� �հ�
		int num = (int)(Math.random() * 100 + 1);
		
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1���� " + num + "������ �� : " + sum);
	}
	
	public void exceptGugu() {
		// ������
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int dan = sc.nextInt();
		
		if(dan >= 1) {
			for(int i = 1; i < 10; i++) {
				if(i % dan != 0) {
					System.out.printf("%d * %d = %d%n", dan, i, dan*i);
				}
			}
		} else {
			System.out.println("����� �ƴմϴ�.");
		}
	}
	
	public void diceGame() {
		// �ֻ��� ���� �˾Ƹ����� ����
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("�ֻ��� �� ���� ���� ���� ������(1~12 �Է�) : ");
			int answer = sc.nextInt();
			
			int dice1 = (int)(Math.random() * 6 + 1);
			int dice2 = (int)(Math.random() * 6 + 1);
			
			if(dice1 + dice2 == answer) {
				System.out.println("�����Դϴ�.");
				System.out.printf("�ֻ����� �� : %d + %d = %d%n", dice1, dice2, dice1+dice2);
				boolean flag = false;
				while(!flag) {
					System.out.print("��� �Ͻðڽ��ϱ�?(y/n) : ");
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
						System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
					}
				}
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}
		}
	}
}
