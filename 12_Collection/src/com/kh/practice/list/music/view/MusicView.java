package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("****** ���� �޴� ******");
			System.out.println("1. ������ ��ġ�� �� �߰�");
			System.out.println("2. ù ��ġ�� �� �߰�");
			System.out.println("3. ��ü �� ��� ���");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("6. Ư�� �� ���� ����");
			System.out.println("7. ��� �������� ����");
			System.out.println("8. ������ �������� ����");
			System.out.println("9. ����");
			
			System.out.print("�޴� ��ȣ ���� : ");
			
			int num = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(num) {
			case 1: 
				addList();
				break;
			case 2: 
				addAtZero();
				break;
			case 3: 
				printAll();
				break;
			case 4: 
				searchMusic();
				break;
			case 5: 
				removeMusic();
				break;
			case 6: 
				setMusic();
				break;
			case 7: 
				ascTitle();
				break;
			case 8: 
				descSinger();
				break;
			case 9: 
				System.out.println("����");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
			System.out.println();
		}
		
	}

	public void addList() {
		System.out.println("****** ������ ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		if(mc.addList(new Music(title, singer)) == 1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
		System.out.println();
	}

	public void addAtZero() {
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		if(mc.addAtZero(new Music(title, singer)) == 1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
		System.out.println();
	}

	public void printAll() {
		System.out.println("****** ��ü �� ��� ��� ******");
		System.out.println(mc.printAll());
		System.out.println();
	}

	public void searchMusic() {
		System.out.println("****** Ư�� �� �˻� ******");
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		Music search = mc.searchMusic(title);
		
		if(search == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println("�˻��� ���� " + search + "�Դϴ�.");
		}
		System.out.println();
	}

	public void removeMusic() {
		System.out.println("****** Ư�� �� ���� ******");
		System.out.print("������ �� �� : ");
		String title = sc.nextLine();
		Music remove = mc.removeMusic(title);
		
		if(remove == null) {
			System.out.println("������ ���� �����ϴ�.");
		} else {
			System.out.println(remove + "��(��) �����߽��ϴ�.");
		}
		System.out.println();
		
	}

	public void setMusic() {
		System.out.println("****** Ư�� �� ���� ���� ******");
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		System.out.print("������ �� �� : ");
		String editTitle = sc.nextLine();
		System.out.print("������ ���� �� : ");
		String editSinger = sc.nextLine();
		
		Music edit = mc.setMusic(title, new Music(editTitle, editSinger));
		
		if(edit == null) {
			System.out.println("������ ���� �����ϴ�.");
		} else {
			System.out.println(edit + "�� ���� ����Ǿ����ϴ�.");
		}
		System.out.println();
	}

	public void ascTitle() {
		System.out.println("****** �� �� �������� ���� ******");
		if(mc.ascTitle() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		System.out.println();
	}

	public void descSinger() {
		System.out.println("****** ���� �� �������� ���� ******");
		if(mc.descSinger() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		System.out.println();
	}
	
}
