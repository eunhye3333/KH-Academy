package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	public void method() {
		// ���ڿ��� �Է� �޾� ���� ������ ����ϴ� �ݺ� ���α׷�
		// ��, end�� �ԷµǸ� �ݺ� ����
		Scanner sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.print("���ڿ� �Է� : ");
//			String str = sc.nextLine();
//			System.out.println(str.length());
//			
//			if(str.equals("end")) {
//				break;
//			}
//		}
		
//		String str = "";
//		while(!str.equals("end")) {
//			System.out.print("���ڿ� �Է� : ");
//			str = sc.nextLine();
//			System.out.println("���� ���� : " + str.length());
//		}
		
		// break ���
		while(true) {
			System.out.print("���ڿ� �Է� : ");
			String str = sc.nextLine();
			
			if(str.equals("end")) {
				break;
			}
			
			System.out.println("���� ���� : " + str.length());
		}
	}
}
