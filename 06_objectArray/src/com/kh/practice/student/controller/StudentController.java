package com.kh.practice.student.controller;

import com.kh.practice.student.model.vo.Student;

public class StudentController {
	private Student[] sArr = new Student[5];
	public static final int CUT_LINE = 60;
	
	public StudentController() {
		sArr[0] = new Student("김길동", "자바", 100);
		sArr[1] = new Student("박길동", "디비", 50);
		sArr[2] = new Student("이길동", "화면", 85);
		sArr[3] = new Student("정길동", "서버", 60);
		sArr[4] = new Student("홍길동", "자바", 20);
	}
	
	public Student[] printStudent() {
		// 객체 배열에 있는 데이터 반환
		for(int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i].inform());
		}
		return sArr;
	}
	
	public int sumScore() {
		// 객체 배열의 점수를 합한 값 리턴
		int sum = 0;
		for(int i = 0; i < sArr.length; i++) {
			sum += sArr[i].getScore();
		}
		
		return sum;
	}
	
	public double[] avgScore() {
		// double 배열을 만들어 sumScore의 리턴 값을 0번째 인덱스에 저장하고 합의 평균을 1번째 인덱스에 저장 후 리턴
		double[] avg = new double[2];
		avg[0] = sumScore();
		avg[1] = avg[0] / sArr.length;
		
		return avg;
	}
}
