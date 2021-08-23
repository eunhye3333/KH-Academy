package com.kh.example.practice3.model.vo;

public class Circle {
	public static final double PI = 3.14;
	private static int radius = 1;
	
	public void incrementRadius() {
		radius++;
	}
	
	public void getAreaOfCircle() {
		System.out.println(radius * radius * PI);
	}
	
	public void getSizeOfCircle() {
		System.out.println(2 * PI * radius);
	}
}
