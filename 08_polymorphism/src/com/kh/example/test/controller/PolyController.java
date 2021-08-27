package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class PolyController {
	public void method() {
		System.out.println("1. 부모 타입 레퍼런스로 부모 객체 다루는 경우");
		Parent p1 = new Parent();
		// ㄴ 부모 타입 레퍼런스    ㄴ 부모 객체
		p1.printParent();
		
		System.out.println("2. 자식 타입 레퍼런스로 자식 객체 다루는 경우");
		Child1 c1 = new Child1();
		// ㄴ 자식 타입 레퍼런스      ㄴ 자식 객체
		c1.printChild1();
		c1.printParent();
		
		System.out.println("3. 부모 타입 레퍼런스로 자식 객체 다루는 경우");
		Parent p2 = new Child2(); // 다형성 적용
		// ㄴ 부모 타입 레퍼런스     ㄴ 자식 객체
		// 업 캐스팅 : 부모 타입의 참조형 변수가 모든 자식 객체를 받을 수 있는 것
		// p2.하면 printParent만 나옴
		p2.printParent();
//		p2.printChild2(); // 불가능
		((Child2)p2).printChild2(); // 가능. 가지고 있는 것은 많은데 볼 수 있는 영역이 좁은 상황에서 시야를 넓힌 것이기 때문
		
		System.out.println("4. 자식 타입 레퍼런스로 부모 객체 다루는 경우");
//		Child2 c2 = new Parent(); // 아예 에러가 뜸
		// ㄴ 자식 타입 레퍼런스    ㄴ 부모 객체
//		Child2 c2 = (Child2)(new Parent()); // 실행하면 에러 남
		// java.lang.ClassCastException 클래스끼리의 형변환은 안 됨
//		Child2 c2 = (Child2)p1; // 같은 에러
		
		System.out.println();
		System.out.println("=== 간단 예제 ===");
		System.out.println();
		
		Parent[] pArr = new Parent[4];
		// 업 캐스팅이 적용된 상태
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		pArr[2] = new Child2();
		pArr[3] = new Child1();
		
//		for(int i = 0; i < pArr.length; i++) {
//			pArr[i].printParent(); // 나 부모야 x 4
//		}

		((Child1) pArr[0]).printChild1();
		((Child2) pArr[1]).printChild2();
		((Child2) pArr[2]).printChild2();
		((Child1) pArr[3]).printChild1();
		// for문 이용 불가능
		// 인덱스를 알지 못하면 불가능한 방법
		
		// 인덱스를 모르는 경우 instanceof 연산자 이용
		for(int i = 0; i < pArr.length; i++) {
			// instanceof 연산자 : 현재의 참조형 변수가 어떤 클래스형의 객체를 참조하고 있는지 확인할 깨 사용
//			pArr[0] instanceof Child1 // pArr[0]에 들어간 객체가 Child1 타입이니? true
//			pArr[1] instanceof Child2 // pArr[1]에 들어간 객체가 Child2 타입이니? true
//			pArr[3] instanceof Child1 // pArr[2]에 들어간 객체가 Child1 타입이니? false
//			pArr[4] instanceof Child2 // pArr[3]에 들어간 객체가 Child2 타입이니? false
			// instanceof 연산자의 결과 값은 true/false -> 조건식에 많이 사용
			
			if(pArr[i] instanceof Child1) {
				((Child1)pArr[i]).printChild1(); // 다운캐스팅
			} else if(pArr[i] instanceof Child2) {
				((Child2)pArr[i]).printChild2();
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < pArr.length; i++) {
			pArr[i].print(); // pArr은 Parent 타입이기 때문에 Parent만 볼 수 있음. 따라서 print 메소드도 Parent에 있는 메소드를 불러와야 할 것 같음
			// 하지만 Child1, Child2의 print 메소드가 실행됨 
			// 이유? 동적 바인딩 적용
			// pArr은 Parent이기 때문에 Parent의 print로 정적 바인딩 되지만
			// 실행했을 경우 오버라이딩과 다형성이 모두 적용되어 있기 때문에 각각 Child1, Child2의 print로 동적 바인딩되어 출력된다.
		}
		

	}
}
