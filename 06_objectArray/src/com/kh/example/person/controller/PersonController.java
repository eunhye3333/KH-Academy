package com.kh.example.person.controller;

import com.kh.example.person.model.vo.Person;

public class PersonController {
	public void method1() {
		// Person 객체가 들어갈 수 있는 5개의 공간 pArr 생성
		Person[] pArr = new Person[5];
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]); // null 5개 -> Person 객체에 대한 기본값. 해당 객체에 매칭되지 않아서.
		}
		
//		System.out.println(pArr[0].getName()); // java.lang.NullPointerException
		// pArr[0]에 아직 객체가 들어가기 전이라서 안에 있는 메소드를 가지고 올 수 없음
		// NullPointerException이 뜨면 pArr[0]에 집중
		// pArr[0]에는 null이 들어가 있기 때문에 getName()을 가지고 올 수 없음
		// --> NullPointerException
		
		// 객체 넣기
		pArr[0] = new Person("강건강", 25, '남', 175.4, 74.2);
		pArr[1] = new Person();
		pArr[2] = new Person();
		pArr[3] = new Person();
		pArr[4] = new Person();
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]); // Person에 대한 주소값이 나옴. Person 객체가 들어갔다.
		}
		
		System.out.println(pArr[0].getName()); // null이 출력됨. 기본 생성자로 만들어서 필드 초기화가 되지 않았기 때문에.
		// pArr[0]에는 Person의 객체가 들어가 있기 때문에 getName()을 가지고 올 수 있음
		// null이 뜨는 이유는 Person 기본 생성자로 만들었기 때문에 필드 초기화 x
		// 즉, String name의 기본값 null이 들어가 있으므로 null 반환
	}
	
	public void method2() {
		// 할당과 동시에 초기화
		Person[] pArr = {new Person("남나눔", 14, '남', 167.7, 61.5),
						 new Person("도대담", 31, '남', 182.4, 67.5),
						 new Person("류라라", 18, '여', 172.4, 56.1)};
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]);
		}
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}
}
