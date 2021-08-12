package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	// switch(���ǽ�){
	// case 1 : ���๮1; break; // ���ǽ��� ��� ���� 1�� ��� ����
	// case 2 : ���๮2; break; // ���ǽ��� ��� ���� 2�� ��� ����
	// default : ���๮3;       // ���ǽ��� ��� ���� case�� �ش����� ���� �� ����
	// }
	// ���ǽ��� ��� ���� case���� ã�� ����� �����ϴ� ���ǹ�
	// �ش��ϴ� ���� case�� ���� ��� default�� ��ɹ� ����
	// case�� ���๮ ���̿��� �ݷ�(:)�� ���־�� ��
	// break�� ������ ������ �ʰ� ��� ����
	
	public void method1() {
		// ���� �� ���� ���� ��ȣ ���� 1���� �Է¹޾� ���� ��ȣ ���ڿ� �ش��ϴ� ����� ���� �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int first = sc.nextInt();
		
		System.out.print("�� ��° ���� : ");
		int second = sc.nextInt();
		
		System.out.print("������(+,-,*,/) : ");
//		char op = sc.nextLine().charAt(0); // ���۸� ������� �ʾ� ������ ��
		// 1. int�� �޾ƿ� �� String���� �޾� �Ľ��ϱ�
		// 2. nextLine()���� �ٹٲ� ���ֱ�
		// 3. nextLine() ��� next()�� ����
		char op = sc.next().charAt(0);
		
		int result = 0; // ���� ���� �� �ʱ�ȭ
		switch(op) { // op�� ���̽��� �����ڴ�
		case '+': 
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			if(second == 0) { // 0���� ������ ��� ������ �ߴµ� �ش� ���� �߻� ����
				System.out.println("0���δ� ���� �� �����ϴ�. ����� ��Ȯ���� �ʽ��ϴ�.");
			} else {				
				result = first / second;
			}
			break; 
			// op�� ���� ��Ģ������ �ƴ� ��ȣ�� �ִ� ��쿡�� switch���� ���� �ʱ� ������ result�� 0���� ����
			// �߸��� ���̱� ������ default �߰��� �ȳ� ���� ����
		default :
			System.out.println("���ÿ� ���� �������Դϴ�. ����� ��Ȯ���� �ʽ��ϴ�.");
			break; // ��� ��
		}

		System.out.printf("%d %c %d = %d", first, op, second, result );
	}
	
	public void method2() {
		System.out.println("***** �ſ�� ���� ���� *****");
		System.out.println("���, �ٳ���, ������, Ű�� �ֽ��ϴ�! ���� ���ϰ� �������!");
		System.out.print("� ������ ������ �ñ��ϼ���?");
		
		Scanner sc = new Scanner(System.in);
		String fruit = sc.nextLine();
		
		// ��� 1000 / �ٳ��� 3000 / ������ 2000 / Ű�� 5000
		// ���� ������ ���, "�� ������ �ſ�� ���� ���Կ� �����ϴ� �Ф� ���� �ſ� ��Ʈ�� �� ������!" ���� ���
		// ���� ��� : (ex. ����� ������ 1000���Դϴ�.)
		
		int price = 0; // �⺻���� 0�̶� 0���� �ʱ�ȭ�ϴµ� �ٷ� ����ؾ� �ϴ� ���� ������ �� ������ �ʱ�ȭ�ϸ� ��
		boolean flag = false; // ������ ���� �� ���� ������� �ʱ�
		// boolean flag;�� �θ� �� ��. �⺻���� false�� ���� ������ ���������� �ʱ�ȭ���� ������ ���� �Ұ���
		// �������� (�޼ҵ� �ȿ� �ִ� ����)�� ������ �ʱ�ȭ�� ����� ��� ������. �ȿ� ������ ���� �� �� �ֱ� ������.
		// ������ �޼ҵ� �ٱ� �κп� ����� ����(���� ����)�� �ʱ�ȭ���� �ʾƵ� ������ ��. ���������� �������� ������ �⺻���� ���� ��.
		switch(fruit) {
		case "���":
			price = 1000;
			// System.out.println(fruit + "�� ������ " + price + "���Դϴ�."); 
			// ���⿡ ���ٸ��� ����ϴ� �� ���� ������ �� ������ �� ������ �ϴ� ��쿡 ���� ������ ���
			break;
		case "�ٳ���":
			price = 3000;
			break;
		case "������":
			price = 2000;
			break;
		case "Ű��":
			price = 5000;
			break;
		default :
			System.out.println("�� ������ �ſ�� ���� ���Կ� �����ϴ� �Ф� ���� �ſ� ��Ʈ�� �� ������!");
			flag = true;
			break;
		}
		
//		if(flag == false) { 
		if(!flag) { // flag : false -> if�� ���� (���� ǥ�� o)
			        // flag : true  -> if�� ���� x (���� ǥ�� x)
			System.out.println(fruit + "�� ������ " + price + "���Դϴ�.");
		}
		// flag�� ó������ true�� ���� ������ if(flag)�� �ϸ� ��. ������ false�� �� ������ boolean�� �⺻���� false�̱� ����.
	}
	
	public void method3() {
		// 1���� 12���� �Է¹޾� �ش��ϴ� ���� ������ ��¥ ����ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ���(1~12) : ");

		int num = sc.nextInt();
		
		int day = 0;
		
		switch(num) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			day = 28;
			break;
		default :
			System.out.println("�ش��ϴ� ���� �����ϴ�.");
		}
		
		if(day != 0) {
			System.out.println(num + "���� ������ ��¥�� " + day + "���Դϴ�");
		}
	}
	
	public void method4() {
		// switch���� ���� ���Ǵ� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. ȸ�� ���");
		System.out.println("2. ȸ�� ����");
		System.out.println("3. ȸ�� ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("ȸ�� ��� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("ȸ�� ���� �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("ȸ�� ���� �޴��Դϴ�.");
			break;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. ����ϱ�");
		System.out.println("2. �ſ�� ���ϰ���");
		System.out.println("3. ������ ��¥");
		System.out.println("4. �޴� ���");

		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			method1(); // ȣ���ϰ� ���� �޼ҵ尡 ���� Ŭ������ ���� ����. ���� �˸��̸� ������� �ʿ䰡 ����
			// �޼ҵ尡 ������ ���� ȣ������ ������ ���ư�
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		case 4:
			method4();
			break;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

	}

	
}
