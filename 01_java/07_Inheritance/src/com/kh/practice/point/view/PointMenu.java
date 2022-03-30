package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("==== �޴� ====");
			System.out.println("1. ��");
			System.out.println("2. �簢��");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				return;
			default:
				System.out.println("��ȿ���� ���� �޴��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void circleMenu() {
		while(true) {
			System.out.println("==== �� �޴� ====");
			System.out.println("1. �� �ѷ�");
			System.out.println("2. �� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			
			int num = sc.nextInt();
			switch(num) {
			case 1:
				calcCircum();
				return;
			case 2:
				calcCircleArea();
				return;
			case 9:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			default:
				System.out.println("��ȿ���� ���� �޴��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void rectangleMenu() {
		while(true) {
			System.out.println("==== �簢�� �޴� ====");
			System.out.println("1. �簢�� �ѷ�");
			System.out.println("2. �簢�� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			
			int num = sc.nextInt();
			switch(num) {
			case 1:
				calcPerimeter();
				return;
			case 2:
				calcRectArea();
				return;
			case 9:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			default:
				System.out.println("��ȿ���� ���� �޴��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void calcCircum() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		
		System.out.println(cc.calcCircum(x, y, radius));
	}
	
	public void calcCircleArea() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int height = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	
	public void calcRectArea() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int height = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcArea(x, y, height, width));
	}
}
