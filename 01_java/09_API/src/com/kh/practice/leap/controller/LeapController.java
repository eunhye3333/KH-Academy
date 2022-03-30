package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && year % 100 != 0) {
			return true;
		} else if (year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public long leapDate(Calendar c) {
		long days = 0;
		int year = c.get(Calendar.YEAR);
		for(int i = 1; i <= year; i++) {
			if(isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		return days;
	}
}
