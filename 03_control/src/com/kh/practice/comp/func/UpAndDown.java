package com.kh.practice.comp.func;

import java.util.Scanner;

public class UpAndDown {
	public void upDown() {
		// 1부터 100까지의 정수 중 임의의 난수가 정해지고 난수 맞히기
		Scanner sc = new Scanner(System.in);	
		
		int random = (int)(Math.random() * 100 + 1);
		int count = 0;
		
		while(true) {
			System.out.print("1~100 사이의 임의의 난수를 맞혀 보세요 : ");
			int answer = sc.nextInt();

			if (answer >= 1 && answer <= 100) {
				count++;
				if (answer > random) {
					System.out.println("DOWN!");
				} else if (answer < random) {
					System.out.println("UP!");
				} else {
					System.out.println("정답입니다!");
					System.out.println(count + "회만에 맞히셨습니다.");
					break;
				}
			} else {
				System.out.println("1~100 사이의 숫자를 입력해 주세요.");
			}
		}
	}
}
