package com.kh.example.chap01_throws.run;

import com.kh.example.chap01_throws.controller.ThrowsController;

public class Run {
//	public static void main(String[] args) throws Exception {
	// throws Exception을 main에 추가하면 비정상 종료 됨
	public static void main(String[] args) {
		ThrowsController tc = new ThrowsController();
		try {
			tc.method1();
		} catch(Exception e) { // e : Exception을 부르고자 하는 변수
//			e.printStackTrace();
			// 예외 내용 및 발생 위치를 콘솔에 출력해주는 메소드
			System.out.println("예외 상황이 발생하였습니다");
		}
		
		
		System.out.println("정상적으로 종료됨...");
		// 실행하면 에러는 났는데 정상적으로 종료됨이 출력됨
		// -> 하지만 Exception in thread "main"이 없음
		// -> 예외를 잡은 것에 대한 정보를 출력해준 것
	}
}
