package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class InheritanceTest {
	public void method() {
		// Parent Ŭ������ num �ʵ忡 ����
		System.out.println("Parent Ŭ������ num �ʵ忡 ����");
		Parent p = new Parent();
		p.setNum(9);
		System.out.println("Parenr �ȿ� �ִ� num : " + p.getNum());
		
		System.out.println();
		
		System.out.println("Child1 Ŭ������ str �ʵ忡 ����");
		Child1 c1 = new Child1();
		c1.setStr("Hello");
		System.out.println("Child1 �ȿ� �ִ� str : " + c1.getStr());
		
		System.out.println();
		
		System.out.println("Child2 Ŭ������ str �ʵ忡 ����");
		Child2 c2 = new Child2();
		c2.setStr("World");
		System.out.println("Child2 �ȿ� �ִ� str : " + c2.getStr());
		
		System.out.println("Child2 Ŭ������ ��ӹ��� Parent Ŭ������ �ʵ忡 ����");
//		c2.num;
		// The field Parent.num is not visible
		// Parent Ŭ������ �ʵ�� num�� �����ؼ� Child2���� ����� �� ������ num�� ���������ڰ� private�̱� ������ �ܺ� ���� �Ұ�
		c2.setNum(999);
		System.out.println("Child2 �ȿ� �ִ� num : " + c2.getNum());
		System.out.println("Parent �ȿ� �ִ� num : " + p.getNum()); // c2�� p ��ü�� �ּҰ��� �ٸ��� ������ �ٲ��� ����. ���� ������ ��ġ�� �ʴ´�
		
		
		
	}
}