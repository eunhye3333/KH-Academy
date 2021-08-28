package com.kh.example.chap03_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public void method1() {
		Date today = new Date();
		System.out.println(today);
		System.out.println(today.getTime()); // 현재 내 시간을 밀리세컨즈로 바꿔 놓은 것
//		Fri Aug 27 12:34:00 KST 2021
//		1630035240562
		
		Date time = new Date(1630035240562L); // long 값
		// 아까 복사해 놓은 시간을 가져옴
		// 해당 시간의 ms 값만 가지고 있다면 지나간 시간도 활용 가능
		System.out.println(time);
		
		Date date = new Date(2022, 1, 25); // 날자를 집어넣는 순간 Date에 취소줄이 생김
		// 이 취소줄은 deprecated되었다는 뜻
	}
	
	public void method2() {
//		Calendar c = new Calendar(); // 불가능
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		
		int year = c.get(Calendar.YEAR);
		System.out.print(year);
		
		int month = c.get(Calendar.MONTH) + 1; // 날짜 관련 클래스에서 달(월)은 0부터 시작 : 1월 = 0, 2월 = 1, ... 12월 = 11
		// 달만 + 1 해 줘야 함
		System.out.println(month);
		
		int date = c.get(Calendar.DATE);
		System.out.println(date);
		
		int amPm = c.get(Calendar.AM_PM);
		int amPm2 = c.get(Calendar.AM); // AM만 있는 것도 있고 PM만 있는 것도 있는데 그렇다고 결과가 무조건 AM, PM으로 나오지는 않음
		// 현재 시간에 맞춰서 나옴
		System.out.println(amPm2);
		System.out.println(amPm);
		System.out.println(amPm == 1 ? "오후" : "오전"); // PM은 1
		
		int hour = c.get(Calendar.HOUR);
		System.out.println(hour);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour24);
		
		int min = c.get(Calendar.MINUTE);
		System.out.println(min);
		
		int sec = c.get(Calendar.SECOND);
		System.out.println(sec);
		
		int day = c.get(Calendar.DAY_OF_WEEK); // 요일 : 일요일 - 1, 월요일 - 2, ... 토요일 - 7
		System.out.println(day);
	}
	
	public void method3() {
		int year = 2022;
		int month = 0; // 달은 0부터 시작하기 때문에 1을 넣으면 2월로 인지함
		int date = 25;
		int hour = 17;
		int min = 50;
		int sec = 0;
		// 우리 반 종강일
		
		GregorianCalendar gc = new GregorianCalendar(year, month, date, hour, min, sec); // 그대로 출력하면 보기 어렵게 나옴
		long time = gc.getTimeInMillis(); // 반환값 : long
		Date endDay = new Date(time); // 밀리세컨즈를 Date 객체에 넣어 보기 좋게 반환
		System.out.println(endDay);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초"); // 기본 생성자가 아니라 어떤 형식으로 만들지 적어 줘야 됨
		String end = sdf.format(endDay);
		System.out.println(end);
	
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a HH시 mm분 ss초"); // hh를 대문자로 하면 24시간 기준이 됨 
		String end2 = sdf2.format(endDay);
		System.out.println(end2);
	}
}
