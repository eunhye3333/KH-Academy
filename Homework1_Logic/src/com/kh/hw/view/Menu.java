package com.kh.hw.view;

import java.util.Scanner;

import com.kh.hw.controller.Function;

public class Menu {
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		Function fn = new Function();
		while(true) {
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ������ ū ������ �հ�");
			System.out.println("3. �Ż� ���� Ȯ��");
			System.out.println("4. �л� ���� Ȯ��");
			System.out.println("5. ���� ���� ���");
			System.out.println("6. ���������� �հ�");
			System.out.println("7. ������");
			System.out.println("8. �ֻ��� ���� �˾� ������ ����");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				fn.calculator();
				break;
			case 2:
				fn.totalCalculator();
				break;
			case 3:
				fn.printProfile();
				break;
			case 4:
				fn.printScore();
				break;
			case 5:
				fn.printStarNumber();
				break;
			case 6:
				fn.sumRandom();
				break;
			case 7:
				fn.exceptGugu();
				break;
			case 8:
				fn.diceGame();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				return;
			default :
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
}
