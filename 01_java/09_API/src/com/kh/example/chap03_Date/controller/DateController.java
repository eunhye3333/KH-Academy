package com.kh.example.chap03_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public void method1() {
		Date today = new Date();
		System.out.println(today);
		System.out.println(today.getTime()); // ���� �� �ð��� �и�������� �ٲ� ���� ��
//		Fri Aug 27 12:34:00 KST 2021
//		1630035240562
		
		Date time = new Date(1630035240562L); // long ��
		// �Ʊ� ������ ���� �ð��� ������
		// �ش� �ð��� ms ���� ������ �ִٸ� ������ �ð��� Ȱ�� ����
		System.out.println(time);
		
		Date date = new Date(2022, 1, 25); // ���ڸ� ����ִ� ���� Date�� ������� ����
		// �� ������� deprecated�Ǿ��ٴ� ��
	}
	
	public void method2() {
//		Calendar c = new Calendar(); // �Ұ���
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		
		int year = c.get(Calendar.YEAR);
		System.out.print(year);
		
		int month = c.get(Calendar.MONTH) + 1; // ��¥ ���� Ŭ�������� ��(��)�� 0���� ���� : 1�� = 0, 2�� = 1, ... 12�� = 11
		// �޸� + 1 �� ��� ��
		System.out.println(month);
		
		int date = c.get(Calendar.DATE);
		System.out.println(date);
		
		int amPm = c.get(Calendar.AM_PM);
		int amPm2 = c.get(Calendar.AM); // AM�� �ִ� �͵� �ְ� PM�� �ִ� �͵� �ִµ� �׷��ٰ� ����� ������ AM, PM���� �������� ����
		// ���� �ð��� ���缭 ����
		System.out.println(amPm2);
		System.out.println(amPm);
		System.out.println(amPm == 1 ? "����" : "����"); // PM�� 1
		
		int hour = c.get(Calendar.HOUR);
		System.out.println(hour);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour24);
		
		int min = c.get(Calendar.MINUTE);
		System.out.println(min);
		
		int sec = c.get(Calendar.SECOND);
		System.out.println(sec);
		
		int day = c.get(Calendar.DAY_OF_WEEK); // ���� : �Ͽ��� - 1, ������ - 2, ... ����� - 7
		System.out.println(day);
	}
	
	public void method3() {
		int year = 2022;
		int month = 0; // ���� 0���� �����ϱ� ������ 1�� ������ 2���� ������
		int date = 25;
		int hour = 17;
		int min = 50;
		int sec = 0;
		// �츮 �� ������
		
		GregorianCalendar gc = new GregorianCalendar(year, month, date, hour, min, sec); // �״�� ����ϸ� ���� ��ư� ����
		long time = gc.getTimeInMillis(); // ��ȯ�� : long
		Date endDay = new Date(time); // �и������ Date ��ü�� �־� ���� ���� ��ȯ
		System.out.println(endDay);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��"); // �⺻ �����ڰ� �ƴ϶� � �������� ������ ���� ��� ��
		String end = sdf.format(endDay);
		System.out.println(end);
	
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a HH�� mm�� ss��"); // hh�� �빮�ڷ� �ϸ� 24�ð� ������ �� 
		String end2 = sdf2.format(endDay);
		System.out.println(end2);
	}
}
