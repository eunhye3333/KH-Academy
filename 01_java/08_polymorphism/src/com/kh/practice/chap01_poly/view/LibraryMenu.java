package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();
		char gender = ' ';
		while(true) {
			System.out.print("����(F/M) : ");
			gender = sc.next().toUpperCase().charAt(0);
			if(gender == 'M' || gender == 'F') {
				break;
			} else {
				System.out.println("�ùٸ� ������ �ƴմϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
			System.out.println();
			System.out.println("==== �޴� ====");
			System.out.println("1. ����������");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻�");
			System.out.println("4. ���� �뿩�ϱ�");
			System.out.println("9. ���α׷� �����ϱ�");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("�����մϴ�.");
				return;
			default:
				System.out.println("�߸��� �޴� �����Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}

	public void selectAll() {
		Book[] bList = lc.selectAll();
		for(int i = 0; i < bList.length; i++) {
			System.out.println(i + "�� ���� : " + bList[i]);
		}
	}
	
	public void searchBook() {
		System.out.print("�˻��� ���� Ű���� : ");
		String keyword = sc.next();
		Book[] searchList = lc.searchBook(keyword);
		for(int i = 0; i < searchList.length; i++) {
			if(searchList[i] != null) {
				System.out.println(searchList[i]);
			}
		}
	}

	public void rentBook() {
		selectAll();
		System.out.print("�뿩�� ���� ��ȣ ���� : ");
		int index = sc.nextInt();
		int result = lc.rentBook(index);
		
		switch(result) {
		case 0:
			System.out.println("���������� �뿩�Ǿ����ϴ�.");
			break;
		case 1:
			System.out.println("���� �������� �뿩�� �Ұ����մϴ�.");
			break;
		case 2:
			System.out.println("���������� �뿩�Ǿ����ϴ�. �丮�п� ������ �߱޵Ǿ����� ���� ���������� Ȯ���ϼ���.");
			break;
		}
		
	}
}
