package com.kh.practice.comp.func;

import java.util.Scanner;

public class CompExample {
	public void practice1() {
		// Ȧ������ ��, ¦������ �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			for(int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
			}
		} else {
			System.out.println("����� �ƴմϴ�.");
		}
	}

	public void practice2() {
		// Ȧ������ ��, ¦������ �� ���
		// Ʋ�� ��� �ٽ� �Է�
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.print("���� : ");
			num = sc.nextInt();
			
			if(num <= 0) {
				System.out.println("����� �ƴմϴ�.");
			} else {
				break;
			}
			
		} while (true);

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 1) {
				System.out.print("��");
			} else {
				System.out.print("��");
			}
		}
	}
	
	public void practice3() {
		// ���ڿ��� �Է¹ް� �˻��� ���ڸ� �Է¹޾� �ش� ���ڿ��� �� ���ڰ� �� �� �ִ��� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		
		System.out.println(str + " �ȿ� ���Ե� " + ch + " ���� : " + count);
	}

	public void practice4() {
		// ���ڿ��� �Է¹ް� �˻��� ���ڸ� �Է¹޾� �ش� ���ڿ��� �� ���ڰ� �� �� �ִ��� ���ϱ�
		// �ݺ�
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���ڿ� : ");
			String str = sc.nextLine();
			System.out.print("���� : ");
			char ch = sc.nextLine().charAt(0);
			
			int count = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ch) {
					count++;
				}
			}
			
			System.out.println(str + " �ȿ� ���Ե� " + ch + " ���� : " + count);
			
			boolean flag = true; 
			while(flag) {
				System.out.print("�� �Ͻðڽ��ϱ�? (y/n) : ");
				char re = sc.nextLine().charAt(0);
				switch(re) {
				case 'y':
				case 'Y':
					flag = false;
					break;
				case 'n':
				case 'N':
					System.out.println("�����մϴ�.");
					return;
				default :
					System.out.println("�߸��� ����Դϴ�. �ٽ� �Է����ּ���.");
				}
				
			}
		}
	}
}
