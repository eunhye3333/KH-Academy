package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		LeapController lc = new LeapController(); 
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		System.out.print(year + "년은 ");
		if(lc.isLeapYear(year)) {
			System.out.print("윤년");
		} else {
			System.out.print("평년");
		}
		System.out.print("입니다\n");
		
		System.out.println("총 날짜 수 : " + lc.leapDate(c));
	}
}
