package com.kh.example.person.controller;

import com.kh.example.person.model.vo.Person;

public class PersonController {
	public void method1() {
		// Person ��ü�� �� �� �ִ� 5���� ���� pArr ����
		Person[] pArr = new Person[5];
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]); // null 5�� -> Person ��ü�� ���� �⺻��. �ش� ��ü�� ��Ī���� �ʾƼ�.
		}
		
//		System.out.println(pArr[0].getName()); // java.lang.NullPointerException
		// pArr[0]�� ���� ��ü�� ���� ���̶� �ȿ� �ִ� �޼ҵ带 ������ �� �� ����
		// NullPointerException�� �߸� pArr[0]�� ����
		// pArr[0]���� null�� �� �ֱ� ������ getName()�� ������ �� �� ����
		// --> NullPointerException
		
		// ��ü �ֱ�
		pArr[0] = new Person("���ǰ�", 25, '��', 175.4, 74.2);
		pArr[1] = new Person();
		pArr[2] = new Person();
		pArr[3] = new Person();
		pArr[4] = new Person();
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]); // Person�� ���� �ּҰ��� ����. Person ��ü�� ����.
		}
		
		System.out.println(pArr[0].getName()); // null�� ��µ�. �⺻ �����ڷ� ���� �ʵ� �ʱ�ȭ�� ���� �ʾұ� ������.
		// pArr[0]���� Person�� ��ü�� �� �ֱ� ������ getName()�� ������ �� �� ����
		// null�� �ߴ� ������ Person �⺻ �����ڷ� ������� ������ �ʵ� �ʱ�ȭ x
		// ��, String name�� �⺻�� null�� �� �����Ƿ� null ��ȯ
	}
	
	public void method2() {
		// �Ҵ�� ���ÿ� �ʱ�ȭ
		Person[] pArr = {new Person("������", 14, '��', 167.7, 61.5),
						 new Person("�����", 31, '��', 182.4, 67.5),
						 new Person("�����", 18, '��', 172.4, 56.1)};
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i]);
		}
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].personInfo());
		}
	}
}
