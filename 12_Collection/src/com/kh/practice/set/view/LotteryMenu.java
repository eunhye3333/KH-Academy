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
		System.out.println("========== KH 추첨 프로그램 ==========");
		
		while(true) {
			System.out.println("****** 메인 메뉴 ******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			
			System.out.print("메뉴 번호 선택 : ");
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
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
			System.out.println();
		}
	}

	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < num; ) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호 ('-' 빼고) : ");
			String phone = sc.nextLine();
			if(lc.insertObject(new Lottery(name, phone))) {
				i++;
			} else {
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
			}
			System.out.println();
		}
		System.out.println("추가 완료되었습니다.");
	}

	public void deleteObject() {
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호 ('-' 빼고) : ");
		String phone = sc.nextLine();
		if(lc.deleteObject(new Lottery(name, phone))) {
			System.out.println("삭제 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}

	public void winObject() {
		HashSet<Lottery> win = lc.winObject();
		if(win != null) {
			System.out.println(win);
		} else {
			System.out.println("추첨자 수가 4명 미만이므로 진행할 수 없습니다.");
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
			System.out.println("당첨 대상을 먼저 확인해 주세요.");
		}
	}

	public void searchWinner() {
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호 ('-' 빼고) : ");
		String phone = sc.nextLine();
		
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		} else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
	}

}
