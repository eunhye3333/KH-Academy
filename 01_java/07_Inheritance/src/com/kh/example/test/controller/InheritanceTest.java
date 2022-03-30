package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class InheritanceTest {
	public void method() {
		// Parent 클래스의 num 필드에 접근
		System.out.println("Parent 클래스의 num 필드에 접근");
		Parent p = new Parent();
		p.setNum(9);
		System.out.println("Parenr 안에 있는 num : " + p.getNum());
		
		System.out.println();
		
		System.out.println("Child1 클래스의 str 필드에 접근");
		Child1 c1 = new Child1();
		c1.setStr("Hello");
		System.out.println("Child1 안에 있는 str : " + c1.getStr());
		
		System.out.println();
		
		System.out.println("Child2 클래스의 str 필드에 접근");
		Child2 c2 = new Child2();
		c2.setStr("World");
		System.out.println("Child2 안에 있는 str : " + c2.getStr());
		
		System.out.println("Child2 클래스가 상속받은 Parent 클래스의 필드에 접근");
//		c2.num;
		// The field Parent.num is not visible
		// Parent 클래스에 필드로 num이 존재해서 Child2한테 상속은 해 줬으나 num의 접근제한자가 private이기 때문에 외부 접근 불가
		c2.setNum(999);
		System.out.println("Child2 안에 있는 num : " + c2.getNum());
		System.out.println("Parent 안에 있는 num : " + p.getNum()); // c2와 p 객체의 주소값이 다르기 때문에 바뀌지 않음. 전혀 영향을 미치지 않는다
		
		
		
	}
}
