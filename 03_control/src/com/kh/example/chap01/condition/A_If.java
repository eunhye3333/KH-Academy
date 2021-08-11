package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	// �ܵ� if��
	//      if(���ǽ�){
	//          ������ ����;
	//      }
	//      ���ǽ��� ��� ���� ��(true)�̸� { } �ȿ� �ִ� �ڵ� ����
	//      ���ǽ��� ��� ���� ����(false)�̸� { } �ȿ� �ִ� �ڵ� �����ϰ� �Ѿ
	// if~else��
	//      if(���ǽ�){
	//          ������ ����1;
	//      } else {
	//          ������ ����2;
	//      }
	//      �� �� �� ���� �����ϴ� ���ǹ�
	//      ���ǽ��� ����� ��(true)�̸� if �ȿ� �ִ� ���๮��1 ����
	//      ���ǽ��� ����� ����(false)�̸� else �ȿ� �ִ� ���๮��2 ����
	// if~else if~else��
	//      if(���ǽ�){
	//          ������ ����1;
	//      } else if(���ǽ�) {
	//          ������ ����2;
	//      } else {
	//          ������ ����3;
	//      }
	//      ���� ������ �� �� �ִ� ���ǹ�
	//      if���� ���ǽ��� ��� ���� ��(true)�̸� if �ȿ� �ִ� ���๮��1 ����
	//      if���� ���ǽ��� ��� ���� ����(false)�̸鼭 else if���� ���ǽ� ��� ���� ��(true)�̸�  else if �ȿ� �ִ� ���๮��2 ����
	//      �� �� ����(false)�̶�� ���๮��3 ����
	//      ==> if������ true��� ����Ǿ����� �� �Ʒ� ������� ���ǽ��� true��� �ϴ���/�����ϴ��� ������� �ʴ´�
	//      ==> else if���� ���� ���� �� �ְ�, else���� ���� ���� �ִ�
	
	public void method1() {
		// Ű����� �Է��� ���ڰ� ������� �������� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �� �� �Է� : ");
		int num = sc.nextInt();
		
		// ���� if�� ����
//		// ������� ���� Ȯ��
//		if(num > 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
//		}
//		// 0���� Ȯ��
//		if(num == 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
//		}
//		// �������� Ȯ��
//		if(num < 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
//		}
		// if-else if-else�� �ٸ� ���� ���� if���̱� ������ ������ true�� ����Ǿ�� �Ʒ� if�� ���ǽ��� Ȯ���ϰ� ������
		// ���� 3��° if���� ���ǽ��� num <= 0���� ���� �� num�� 0�� �����ϸ� 2��, 3���� ���� ��µ�
		// else if�� ���� ���ǹ��� true�� �Ǹ� �Ʒ��� true���� ���� �� ��
		
		// if-else�� ����
//		if(num > 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
//		} else { // num <= 0
//			// ��ø if��
//			if(num == 0) {
//				System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
//			} else { 
//				System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
//			}
//		}
		
		// if-else if-else ����
		// ��ø���� �� �־ ��
		if(num > 0) {
			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
		} else if(num == 0) {
			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
		} else {
			System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
		}
	}
	
	public void method2() {
		// Ű����� �Է��� ���ڰ� ¦������ Ȧ������ ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �Է� : ");
		int num = sc.nextInt();
		
		// ���� if�� ����
//		if((num % 2) == 0) {
//			System.out.println("¦���Դϴ�");
//		}
//		
//		if((num % 2) == 1) { // != 0
//			System.out.println("Ȧ���Դϴ�");
//		}
//		
		// if-else��
//		if((num % 2) == 0) {
//			System.out.println("¦���Դϴ�");
//		} else {
//			System.out.println("Ȧ���Դϴ�");
//		}
		
		// if-else if-else��
		if((num % 2) == 0) {
			System.out.println("¦���Դϴ�");
		} else if((num % 2) != 0) {
			System.out.println("Ȧ���Դϴ�");
		}

	}
	
	public void method3() {
		// ����ڿ��� �ֹι�ȣ�� �޾Ƽ� �������� �������� �Ǻ�
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ �Է�(-����) : ");
		// �ֹι�ȣ: 000114-4000000 -> ������ ������ ������ �ε��� 7
//		String str = sc.nextLine();
//		char pId = str.charAt(7);
		char pId = sc.nextLine().charAt(7);
		
		if(pId == '2' || pId =='4') {
			System.out.println("�����Դϴ�");
		} else if(pId == '1' || pId == '3') {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	public void method4() {
		// �̸��� �Է��Ͽ� �������� Ȯ��
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
//		if(name == "�ڽſ�") { ���ڿ��� �񱳴� ==���δ� �Ұ���, equals()�� ����
		if(name.equals("�ڽſ�")) { // name�� �ڽſ�� ����?
			// �ݴ�ε� ���� -> "�ڽſ�".equals(name) // �ڽſ찡 name�̶� ����?
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("������ �ƴմϴ�");
		}
	}
	
	
	
}
