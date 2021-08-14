package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	// while(���ǽ�) {
	//	���� ����;
	//	[������ or �б⹮]; -> ���� ����
	// }
	// ���ǽ� Ȯ�� -> (���ǽ��� ����� true�� ��) ���� ���� ���� -> ���ǽ� Ȯ�� -> (�ݺ�)
	// ���ǽ��� ����� false�� �� ������ �ݺ�
	
	// do {
	//	���� ����
	//	[������ or �б⹮];
	// } while(���ǽ�); -> �����ݷ� �� �ٿ��� ��
	// ���� ���� -> ���ǽ� Ȯ�� -> (���ǽ��� true�� ��) do�� ���� ���� ���� -> ���ǽ� Ȯ�� -> (�ݺ�)
	// ���ǽ��� ����� false�� �� ������ �ݺ�
	
	// while�� do~while�� ������ : do~while�� ������ �� �� �̻� �����Ѵ�
	
	public void method1() {
		// 1���� 5���� ���
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			// �������� ������ 1�� ��� �ݺ�
			i++;
		}
	}
	
	public void method1_1() {
		// �ڱ�Ұ� �ټ� �� �ϱ� : �� �̸��� �ڽſ��
		int i = 0;
		while(i < 5) {
			System.out.println("�� �̸��� �ڽſ��");
			i++;
		}
	}
	
	public void method2() {
		// 5���� 1���� ���
		int i = 5;
		while(i > 0) {
			System.out.println(i);
			i--;
		}
	}
	
	public void method3() {
		// ���ڿ��� �Է� �޾� �ε������� ���� ���
		// java
		// 0 : j
		// 1 : a
		// 2 : v
		// 3 : a
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		
//		int i = 0;
//		while(i < 5) { // ����ڰ� �� ���ڸ� �Է��ϸ� �𸣱� ������ �̹� 5�� ���ع����� ������ ���ų� ����� ����� ������� ���� �� ����
		// ���ڿ��� ���̸� ��ȯ�ϴ� �޼ҵ� : String Ŭ������ length() -> int�� ��ȯ
//		int length = str.length(); // int java.lang.String.length()
//		while(i < length) {
//		while(i < str.length()) { // ������ ���� �������� �ʰ� �ٷ� ��뵵 ������
//			char ch = str.charAt(i); // ��� ������ �Ǵ� ���� �ƴϱ� ������ �����ص� ��� ������ �ݺ��Ǵ� ���� �ƴ�
//			System.out.println(i + " : " + ch);
//			i++;
//		}
		
		// for������ �ٲٱ�
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(i + " : " + ch);
		}

	}
	
	public void method4() {
		// ������
		int i = 2;
		while(i <= 9) {
			int j = 1; // �긦 �ۿ��ٰ� �θ� ���ο� �ܿ��� j�� �缳������ �ʱ� ������ �� �ȿ� �־� ��
			while(j < 10) {
				System.out.println(i + " X " + j + " = " + i*j );
				j++;
			}
			i++;
		}
	}
	
	public void method5() {
		// �޴� �ݺ� ���
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		// 9�� ������ ������ ��. -> 9�� �ƴϸ� true
		while(menuNum != 9) {
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1 ���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public void method5_1() {
		// �޴� �ݺ� ��� do~while
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		
		do {
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1 ���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
//			int menuNum = sc.nextInt(); // �� �κп� ����  while(menuNum != 9);���� ���� ��
			                            // ���� : menuNum�� do �������� ������ ��ħ. while���� ������ ��ġ�� ����.
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} while(menuNum != 9);
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);
	
		
		while(true) { // ������ ����ǰ� ����� ���� ��� -> ���� �ݺ���
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1 ���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");

			int menuNum = sc.nextInt();

			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
//				break; // break ��� return�� ������ �� �޼ҵ��� ������ �����ϰ� ���� ȣ���� ������ ���ư� -> �ƿ� ������
				return; // ���� ������ ���� �ʰ� ���� �ݺ��� ��쿡 ���� �������� return�� ������
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public void method6_1() {
		// method6�� do~while�� �ٲٱ�
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1 ���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");

			int menuNum = sc.nextInt();

			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				return; 
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			} 
		} while(true);
	}
}
