package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	public void method() {
		// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력받아 촘점과 평균을 출력하세요
		// 이때 총점과 평균은 정수형으로 처리하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		double korean = sc.nextDouble();
		
		System.out.print("영어 : ");
		double english = sc.nextDouble();
		
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		int sum = (int)(korean + english + math);
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (sum / 3));		
	}
}
