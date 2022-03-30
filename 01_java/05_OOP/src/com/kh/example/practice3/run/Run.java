package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {
	public static void main(String[] args) {
		Circle c = new Circle();
		
		System.out.println("== 초기 원 둘레 및 넓이 ==");
		System.out.print("둘레 : ");
		c.getSizeOfCircle();
		System.out.print("넓이 : ");
		c.getAreaOfCircle();
		
		System.out.println();
		System.out.println("== 반지름 1 증가 ==");
		c.incrementRadius();
		System.out.println();
		
		System.out.println("== 반지름 1 증가 후 원 둘레 및 넓이 ==");
		System.out.print("둘레 : ");
		c.getSizeOfCircle();
		System.out.print("넓이 : ");
		c.getAreaOfCircle();
	}
}
