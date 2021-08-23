package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("�������� �Է��ϼ���.");
		System.out.print("���� : ");
		String kind = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�� : ");
		String flavor = sc.nextLine();
		System.out.print("���� : ");
		int numOf = sc.nextInt();
		System.out.print("���� : ");
		int price = sc.nextInt();
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		System.out.print("������ ������ ����Ͻðڽ��ϱ�?(y/n) : ");
		char print = sc.next().charAt(0);
		
		if(print == 'y' || print == 'Y') {
			System.out.println(scr.confirmData());
		}
		
	}
	
}
