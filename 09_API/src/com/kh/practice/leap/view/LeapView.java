package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		LeapController lc = new LeapController(); 
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		System.out.print(year + "���� ");
		if(lc.isLeapYear(year)) {
			System.out.print("����");
		} else {
			System.out.print("���");
		}
		System.out.print("�Դϴ�\n");
		
		System.out.println("�� ��¥ �� : " + lc.leapDate(c));
	}
}
