package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {
	public void rps() {
		// 컴퓨터와 가위바위보 하기
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		int win = 0;
		int lose = 0;
		int draw = 0;
		int total = 0;
		
//		
//		while(true) {
//			System.out.print("가위바위보 : ");
//			String user = sc.nextLine();
//			int intCom = (int)(Math.random() * 3 + 1); 
//			String com = null;
//			
//			if(intCom == 1) {
//				com = "가위";
//			} else if(intCom == 2) {
//				com = "바위";
//			} else {
//				com = "보";
//			}
//			
//			System.out.println("컴퓨터 : " + com);
//			System.out.println(name + " : " + user);
//			
//			if(user.equals(com)) {
//				System.out.println("비겼습니다.");
//				draw++;
//				total++;
//			} else if(user.equals("바위")) {
//				if(com.equals("가위")) {
//					System.out.println("이겼습니다!");
//					win++;
//				} else {
//					System.out.println("졌습니다 ㅠㅠ");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("가위")) {
//				if(com.equals("보")) {
//					System.out.println("이겼습니다!");
//					win++;
//				} else {
//					System.out.println("졌습니다 ㅠㅠ");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("보")) {
//				if(com.equals("바위")) {
//					System.out.println("이겼습니다!");
//					win++;
//				} else {
//					System.out.println("졌습니다 ㅠㅠ");
//					lose++;
//				}
//				total++;
//			} else if(user.equals("exit")) {
//				System.out.printf("%d전 %d승 %d무 %d패%n", total, win, draw, lose);
//				break;
//			} else {
//				System.out.println("잘못 입력하셨습니다.");
//			}
//			System.out.println();
//		}
	
		// 더 짧게 해 보기
		while(true) {
			System.out.println();
			System.out.print("가위바위보 : ");
			String user = sc.nextLine();
			int intCom = (int)(Math.random() * 3 + 1); 
			String com = null;
			
			if(intCom == 1) {
				com = "가위";
			} else if(intCom == 2) {
				com = "바위";
			} else {
				com = "보";
			}
			
			System.out.println("컴퓨터 : " + com);
			System.out.println(name + " : " + user);
			
			if(user.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else if(user.equals("가위") && com.equals("보") || user.equals("바위") && com.equals("가위") || user.equals("보") && com.equals("바위")) {
				System.out.println("이겼습니다!");
				win++;
			} else if(user.equals("가위") && com.equals("바위") || user.equals("바위") && com.equals("보") || user.equals("보") && com.equals("가위")) {
				System.out.println("졌습니다 ㅠㅠ");
				lose++;
			} else if(user.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패%n", total, win, draw, lose);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			total++;
		}
	}
}
