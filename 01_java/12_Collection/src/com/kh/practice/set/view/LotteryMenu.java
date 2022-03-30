package com.kh.practice.set.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		System.out.println("========== KH ��÷ ���α׷� ==========");
		
		while(true) {
			System.out.println("****** ���� �޴� ******");
			System.out.println("1. ��÷ ��� �߰�");
			System.out.println("2. ��÷ ��� ����");
			System.out.println("3. ��÷ ��� Ȯ��");
			System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
			System.out.println("5. ��÷ ��� �˻�");
			System.out.println("9. ����");
			
			System.out.print("�޴� ��ȣ ���� : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1: 
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("���α׷� ����.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
			System.out.println();
		}
	}

	public void insertObject() {
		System.out.print("�߰��� ��÷ ��� �� : ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < num; ) {
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("�ڵ��� ��ȣ ('-' ����) : ");
			String phone = sc.nextLine();
			if(lc.insertObject(new Lottery(name, phone))) {
				i++;
			} else {
				System.out.println("�ߺ��� ����Դϴ�. �ٽ� �Է��ϼ���.");
			}
			System.out.println();
		}
		System.out.println("�߰� �Ϸ�Ǿ����ϴ�.");
	}

	public void deleteObject() {
		System.out.println("������ ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ��� ��ȣ ('-' ����) : ");
		String phone = sc.nextLine();
		if(lc.deleteObject(new Lottery(name, phone))) {
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
	}

	public void winObject() {
		HashSet<Lottery> win = lc.winObject();
		if(win != null) {
			System.out.println(win);
		} else {
			System.out.println("��÷�� ���� 4�� �̸��̹Ƿ� ������ �� �����ϴ�.");
		}
	}

	public void sortedWinObject() {
		TreeSet<Lottery> sort = lc.sortedWinObject();
		if(sort != null) {
			Iterator<Lottery> it = sort.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.out.println("��÷ ����� ���� Ȯ���� �ּ���.");
		}
	}

	public void searchWinner() {
		System.out.println("�˻��� ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ��� ��ȣ ('-' ����) : ");
		String phone = sc.nextLine();
		
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("�����մϴ�. ��÷ ��Ͽ� �����մϴ�.");
		} else {
			System.out.println("��Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.");
		}
	}

}
