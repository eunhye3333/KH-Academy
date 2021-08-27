package com.kh.example.family.controller;

import com.kh.example.family.model.vo.Baby;
import com.kh.example.family.model.vo.Basic;
import com.kh.example.family.model.vo.Family;
import com.kh.example.family.model.vo.Mother;

public class FamilyController {
	public void method() {
//		Family f = new Family(); // Cannot instantiate the type Family
		// Family는 추상 클래스이기 때문에 객체 생성이 불가능함, 참조형 변수로만 사용 가능
		
		Family f1 = new Mother("엄마", 50, 70, "출산");
		Family f2 = new Baby("아기", 3.5, 70);
		
//		f1.eat(); // 다형성 적용, 오버라이딩 -> 동적 바인딩 적용 -> Mother의 eat을 불러옴
//		f2.eat();
		
//		Basic b = new Basic();
		// 인터페이스는 객체 생성 불가, 참조형 변수 가능
		Basic b1  = new Mother("엄마", 50, 70, "출산");
		Basic b2 = new Baby("아기", 3.5, 70);
		
		b1.sleep();
		b2.sleep();
	}
}
