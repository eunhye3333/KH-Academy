package com.kh.homework.shape.view;

import java.util.Scanner;

import com.kh.homework.shape.controller.ShapeController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private ShapeController spr = new ShapeController();
	
	public void inputMenu() {
		while(true) {
			System.out.println("==== 도형 프로그램 ====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int figureSelect = sc.nextInt();
			
			while(true) {
				int menuSelect = 0;
				
				if(figureSelect == 3) {
					triangleMenu();
				} else if(figureSelect == 4) {
					squareMenu();
				} else if (figureSelect == 9) {
					System.out.println("프로그램을 종료합니다.");
					return;
				} else {
					System.out.println("잘못된 번호입니다. 다시 입력하세요.");
					break;
				}
				
				menuSelect = sc.nextInt();
				if(menuSelect == 9) {
					System.out.println("메인으로 돌아갑니다.");
					break;
				} else {
					inputData(figureSelect, menuSelect);
				}
			}
		}
	}
	
	public void triangleMenu() {
		System.out.println("==== 삼각형 ====");
		System.out.println("1. 삼각형 면적");
		System.out.println("2. 삼각형 색칠");
		System.out.println("3. 삼각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");

	}
	
	public void squareMenu() {
		System.out.println("==== 사각형 ====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 면적");
		System.out.println("3. 사각형 색칠");
		System.out.println("4. 사각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
	}
	
	public void inputData(int type, int menuNum) {
		int height = 0;
		int width = 0;
		
		if (type == 3) {
			switch(menuNum) {
			case 1: 
				System.out.print("높이 : ");
				height = sc.nextInt();
				System.out.print("너비 : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcArea(type, height, width));
				break;
			
			case 2:
				System.out.printf("색깔 : ");
				spr.paintColor(sc.next());
				System.out.println("색깔이 설정되었습니다.");
				break;
			
			case 3:
				if(spr.print(type) != null) {
					printInform(type);
				} else {
					System.out.println("삼각형의 높이 또는 너비가 설정되지 않았습니다.");
				}
				break;
		
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		} else if (type == 4) {
			switch(menuNum) {
			case 1: 
				System.out.print("높이 : ");
				height = sc.nextInt();
				System.out.print("너비 : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcPerimeter(type, height, width));
				break;

			case 2: 
				System.out.print("높이 : ");
				height = sc.nextInt();
				System.out.print("너비 : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcArea(type, height, width));
				break;
			
			case 3:
				System.out.printf("색깔 : ");
				spr.paintColor(sc.next());
				System.out.println("색깔이 설정되었습니다.");
				break;
			
			case 4:
				if(spr.print(type) != null) {
					printInform(type);
				} else {
					System.out.println("사각형의 높이 또는 너비가 설정되지 않았습니다.");
				}
				break;
				
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		} 
	}
	
	public void printInform(int type) {
		System.out.println(spr.print(type));
	}
}
