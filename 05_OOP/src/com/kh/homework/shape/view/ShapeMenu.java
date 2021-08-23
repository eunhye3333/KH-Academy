package com.kh.homework.shape.view;

import java.util.Scanner;

import com.kh.homework.shape.controller.ShapeController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private ShapeController spr = new ShapeController();
	
	public void inputMenu() {
		while(true) {
			System.out.println("==== ���� ���α׷� ====");
			System.out.println("3. �ﰢ��");
			System.out.println("4. �簢��");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
			int figureSelect = sc.nextInt();
			
			while(true) {
				int menuSelect = 0;
				
				if(figureSelect == 3) {
					triangleMenu();
				} else if(figureSelect == 4) {
					squareMenu();
				} else if (figureSelect == 9) {
					System.out.println("���α׷��� �����մϴ�.");
					return;
				} else {
					System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
					break;
				}
				
				menuSelect = sc.nextInt();
				if(menuSelect == 9) {
					System.out.println("�������� ���ư��ϴ�.");
					break;
				} else {
					inputData(figureSelect, menuSelect);
				}
			}
		}
	}
	
	public void triangleMenu() {
		System.out.println("==== �ﰢ�� ====");
		System.out.println("1. �ﰢ�� ����");
		System.out.println("2. �ﰢ�� ��ĥ");
		System.out.println("3. �ﰢ�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");

	}
	
	public void squareMenu() {
		System.out.println("==== �簢�� ====");
		System.out.println("1. �簢�� �ѷ�");
		System.out.println("2. �簢�� ����");
		System.out.println("3. �簢�� ��ĥ");
		System.out.println("4. �簢�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
	}
	
	public void inputData(int type, int menuNum) {
		int height = 0;
		int width = 0;
		
		if (type == 3) {
			switch(menuNum) {
			case 1: 
				System.out.print("���� : ");
				height = sc.nextInt();
				System.out.print("�ʺ� : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcArea(type, height, width));
				break;
			
			case 2:
				System.out.printf("���� : ");
				spr.paintColor(sc.next());
				System.out.println("������ �����Ǿ����ϴ�.");
				break;
			
			case 3:
				if(spr.print(type) != null) {
					printInform(type);
				} else {
					System.out.println("�ﰢ���� ���� �Ǵ� �ʺ� �������� �ʾҽ��ϴ�.");
				}
				break;
		
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
			}
		} else if (type == 4) {
			switch(menuNum) {
			case 1: 
				System.out.print("���� : ");
				height = sc.nextInt();
				System.out.print("�ʺ� : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcPerimeter(type, height, width));
				break;

			case 2: 
				System.out.print("���� : ");
				height = sc.nextInt();
				System.out.print("�ʺ� : ");
				width = sc.nextInt();
				
				System.out.println(spr.calcArea(type, height, width));
				break;
			
			case 3:
				System.out.printf("���� : ");
				spr.paintColor(sc.next());
				System.out.println("������ �����Ǿ����ϴ�.");
				break;
			
			case 4:
				if(spr.print(type) != null) {
					printInform(type);
				} else {
					System.out.println("�簢���� ���� �Ǵ� �ʺ� �������� �ʾҽ��ϴ�.");
				}
				break;
				
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
			}
		} 
	}
	
	public void printInform(int type) {
		System.out.println(spr.print(type));
	}
}
