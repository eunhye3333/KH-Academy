package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {
	public void rps() {
		// ��ǻ�Ϳ� ���������� �ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �̸��� �Է����ּ��� : ");
		String name = sc.nextLine();
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		int total = 0;
		
//		
//		while(true) {
//			System.out.print("���������� : ");
//			String user = sc.nextLine();
//			int intCom = (int)(Math.random() * 3 + 1); 
//			String com = null;
//			
//			if(intCom == 1) {
//				com = "����";
//			} else if(intCom == 2) {
//				com = "����";
//			} else {
//				com = "��";
//			}
//			
//			System.out.println("��ǻ�� : " + com);
//			System.out.println(name + " : " + user);
//			
//			if(user.equals(com)) {
//				System.out.println("�����ϴ�.");
//				draw++;
//				total++;
//			} else if(user.equals("����")) {
//				if(com.equals("����")) {
//					System.out.println("�̰���ϴ�!");
//					win++;
//				} else {
//					System.out.println("�����ϴ� �Ф�");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("����")) {
//				if(com.equals("��")) {
//					System.out.println("�̰���ϴ�!");
//					win++;
//				} else {
//					System.out.println("�����ϴ� �Ф�");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("��")) {
//				if(com.equals("����")) {
//					System.out.println("�̰���ϴ�!");
//					win++;
//				} else {
//					System.out.println("�����ϴ� �Ф�");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("exit")) {
//				System.out.printf("%d�� %d�� %d�� %d��%n", total, win, draw, lose);
//				break;
//			} else {
//				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//			}
//			System.out.println();
//		}
	
		// �� ª�� �� ����
		while(true) {
			System.out.println();
			System.out.print("���������� : ");
			String user = sc.nextLine();
			int intCom = (int)(Math.random() * 3 + 1); 
			String com = null;
			
			if(intCom == 1) {
				com = "����";
			} else if(intCom == 2) {
				com = "����";
			} else {
				com = "��";
			}
			
			System.out.println("��ǻ�� : " + com);
			System.out.println(name + " : " + user);
			
			if(user.equals(com)) {
				System.out.println("�����ϴ�.");
				draw++;
			} else if(user.equals("����") && com.equals("��") || user.equals("����") && com.equals("����") || user.equals("��") && com.equals("����")) {
				System.out.println("�̰���ϴ�!");
				win++;
			} else if(user.equals("����") && com.equals("����") || user.equals("����") && com.equals("��") || user.equals("��") && com.equals("����")) {
				System.out.println("�����ϴ� �Ф�");
				lose++;
			} else if(user.equals("exit")) {
				System.out.printf("%d�� %d�� %d�� %d��%n", total, win, draw, lose);
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}
			total++;
		}
	}
}
