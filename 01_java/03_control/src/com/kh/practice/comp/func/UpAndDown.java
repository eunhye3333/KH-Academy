package com.kh.practice.comp.func;

import java.util.Scanner;

public class UpAndDown {
	public void upDown() {
		// 1���� 100������ ���� �� ������ ������ �������� ���� ������
		Scanner sc = new Scanner(System.in);	
		
		int random = (int)(Math.random() * 100 + 1);
		int count = 0;
		
		while(true) {
			System.out.print("1~100 ������ ������ ������ ���� ������ : ");
			int answer = sc.nextInt();

			if (answer >= 1 && answer <= 100) {
				count++;
				if (answer > random) {
					System.out.println("DOWN!");
				} else if (answer < random) {
					System.out.println("UP!");
				} else {
					System.out.println("�����Դϴ�!");
					System.out.println(count + "ȸ���� �����̽��ϴ�.");
					break;
				}
			} else {
				System.out.println("1~100 ������ ���ڸ� �Է��� �ּ���.");
			}
		}
	}
}
