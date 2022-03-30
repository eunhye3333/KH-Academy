package com.kh.example.chap06_method.run;

import com.kh.example.chap06_method.controller.MethodPractice;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {
	public static void main(String[] args) {
		MethodPractice mp = new MethodPractice();
		
//		String str = mp.method1(); // 오류, 반환값이 없어서 Type mismatch: cannot convert from void to String
		// 어떤 자료형에도 담을 수 없음 
		// 아무것도 출력 안 되는 건 출력문이 없어서이고 출력문을 넣어 주면 출력됨
		mp.method1();
//		int result1 = mp.method2(); // 반환값이 있고 없고가 콘솔에 값이 찍히는 것을 관여하는 것은 아님 print문을 사용해주어야 함
//		// int를 반환하기 때문에 변수에 값을 넣어 줄 수 있음
//		System.out.println(result1);
//		mp.method2();라고만 하면 값을 반환받기는 하나 저장을 따로 하지 않기 때문에 데이너가 날아간다
		System.out.println(mp.method2()); // 출력만 하는 것이 목적이면 변수를 따로 저장하지 않고 바로 찍어줘도 됨
		
		mp.method3(10, 20);
		
		String result2 = mp.method4("박신우", 20);
		System.out.println(result2);
		
		char[] result3 = mp.method5(); // 얕은 복사, chArr의 주소값과 같은 주소값
		System.out.println("Run result3 : " + result3);
		for(int i = 0; i < result3.length; i++) {
			System.out.print(result3[i]);
		}
		
		Trainee result4 = mp.method6(); // 얕은 복사
		System.out.println("Run result4 : " + result4);
		System.out.println(result4.inform());
		
		Trainee t1 = new Trainee("강건강", 'H', "오전", 98.5);
		System.out.println(t1.inform());
		Trainee t2 = new Trainee('G'); // 필드를 하나씩만 가지고 있는 객체를 만들면 되지 않을까?
		System.out.println(t2.inform()); // 안 됨. 이전 객체가 아니라 새로운 객체기 때문에 수정되지 않음
		// KH null 훈련생은 Gnull반이고, 점수는 98.5점입니다. -> 다른 객체라서 classRoom만 할당된 것으로 출력됨
		
		result4.setName("송민경");
		result4.setClassRoom('G');
		System.out.println(result4.inform());
		
		System.out.println(result4.getACADEMY());
		System.out.println(result4.getClassRoom());
		System.out.println(result4.getName());
		System.out.println(result4.getTime());
		System.out.println(Trainee.getScore());
	}
}
