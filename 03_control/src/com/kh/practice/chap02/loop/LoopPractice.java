package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	public void practice1() {
		// �� ���� ���� �Է¹޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		} else {
			for(int i = 1; i <= num; i++) {
				System.out.println(i);
			}
		}

	}
	
	public void practice2() {
		// 1 �̸��� ���ڰ� �Էµƴٸ� �ٽ� ���� �Է��ϵ���
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
//		while(num < 1) {
//			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
//			num = sc.nextInt();
//			if(num < 1) {
//				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
//			}
//		}
		
		// flag ���
		boolean flag = false;
		while(!flag) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			if(num < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			} else {
				flag = true;
			}
		}
		
		for(int i = 1; i <= num; i++) {
			System.out.println(i);
		}
	}
	
	public void practice3() {
		// �� ���� ���� �Է¹޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		} else {
//			for(int i = num; i >= 1; i--) {
//				System.out.println(i);
//			}
			
//			for(int i = 0; i < num; i++) { // i++ ���
//				System.out.println(num - i);
//			}
			
			for(; num >= 1; num--) { // ���ο� ���� �������� �ʱ�
				System.out.println(num);
			} 
		}
	}
	
	public void practice4() {
		// 1 �̸��� ���� �Է� �� �����
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(num < 1) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			if(num < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
		}
		
		for(; num >= 1; num--) {
			System.out.println(num);
		}
	}
	
	public void practice5() {
		// 1���� �Է¹��� �������� ���� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ���(2 �̻�) : ");
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
//			System.out.println("�߸� �Է��Ͽ����ϴ�");
//		}
		
		// ���ڸ� ����
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
			System.out.println("�߸� �Է��Ͽ����ϴ�");
		}
	}
	
	public void practice6() {
		// �� ���� ���� �Է¹޾� �� ������ ���� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();
		
		int start = 0;
		int end = 0;
		
		if (num1 == 0 || num2 == 0) {
			System.out.println("1 �̻��� ���ڸ� �Է��ϼ���");
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
		// �� ���� ���� �Է¹޾� �� ������ ���� ���
		// 1 �̸��� ���ڰ� �ԷµǸ� �ٽ� �Է��ϵ���
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		
		while(num1 < 1 || num2 < 1) {
			System.out.print("ù ��° ���� : ");
			num1 = sc.nextInt();
			System.out.print("�� ��° ���� : ");
			num2 = sc.nextInt();
			
			if(num1 < 1 || num2 < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
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
		// �Է¹��� ������ �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int dan = sc.nextInt();
		
		System.out.println("============ " + dan + "�� ============");
//		for(int i = 1; i < 10; i++) {
//			System.out.printf("%d * %d = %d%n", dan, i, dan*i);
//		}
		
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %2d%n", dan, i, dan*i);
			// ������ ����
			//
		}
		
	}
}
