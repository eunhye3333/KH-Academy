package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class PolyController {
	public void method() {
		System.out.println("1. �θ� Ÿ�� ���۷����� �θ� ��ü �ٷ�� ���");
		Parent p1 = new Parent();
		// �� �θ� Ÿ�� ���۷���    �� �θ� ��ü
		p1.printParent();
		
		System.out.println("2. �ڽ� Ÿ�� ���۷����� �ڽ� ��ü �ٷ�� ���");
		Child1 c1 = new Child1();
		// �� �ڽ� Ÿ�� ���۷���      �� �ڽ� ��ü
		c1.printChild1();
		c1.printParent();
		
		System.out.println("3. �θ� Ÿ�� ���۷����� �ڽ� ��ü �ٷ�� ���");
		Parent p2 = new Child2(); // ������ ����
		// �� �θ� Ÿ�� ���۷���     �� �ڽ� ��ü
		// �� ĳ���� : �θ� Ÿ���� ������ ������ ��� �ڽ� ��ü�� ���� �� �ִ� ��
		// p2.�ϸ� printParent�� ����
		p2.printParent();
//		p2.printChild2(); // �Ұ���
		((Child2)p2).printChild2(); // ����. ������ �ִ� ���� ������ �� �� �ִ� ������ ���� ��Ȳ���� �þ߸� ���� ���̱� ����
		
		System.out.println("4. �ڽ� Ÿ�� ���۷����� �θ� ��ü �ٷ�� ���");
//		Child2 c2 = new Parent(); // �ƿ� ������ ��
		// �� �ڽ� Ÿ�� ���۷���    �� �θ� ��ü
//		Child2 c2 = (Child2)(new Parent()); // �����ϸ� ���� ��
		// java.lang.ClassCastException Ŭ���������� ����ȯ�� �� ��
//		Child2 c2 = (Child2)p1; // ���� ����
		
		System.out.println();
		System.out.println("=== ���� ���� ===");
		System.out.println();
		
		Parent[] pArr = new Parent[4];
		// �� ĳ������ ����� ����
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		pArr[2] = new Child2();
		pArr[3] = new Child1();
		
//		for(int i = 0; i < pArr.length; i++) {
//			pArr[i].printParent(); // �� �θ�� x 4
//		}

		((Child1) pArr[0]).printChild1();
		((Child2) pArr[1]).printChild2();
		((Child2) pArr[2]).printChild2();
		((Child1) pArr[3]).printChild1();
		// for�� �̿� �Ұ���
		// �ε����� ���� ���ϸ� �Ұ����� ���
		
		// �ε����� �𸣴� ��� instanceof ������ �̿�
		for(int i = 0; i < pArr.length; i++) {
			// instanceof ������ : ������ ������ ������ � Ŭ�������� ��ü�� �����ϰ� �ִ��� Ȯ���� �� ���
//			pArr[0] instanceof Child1 // pArr[0]�� �� ��ü�� Child1 Ÿ���̴�? true
//			pArr[1] instanceof Child2 // pArr[1]�� �� ��ü�� Child2 Ÿ���̴�? true
//			pArr[3] instanceof Child1 // pArr[2]�� �� ��ü�� Child1 Ÿ���̴�? false
//			pArr[4] instanceof Child2 // pArr[3]�� �� ��ü�� Child2 Ÿ���̴�? false
			// instanceof �������� ��� ���� true/false -> ���ǽĿ� ���� ���
			
			if(pArr[i] instanceof Child1) {
				((Child1)pArr[i]).printChild1(); // �ٿ�ĳ����
			} else if(pArr[i] instanceof Child2) {
				((Child2)pArr[i]).printChild2();
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < pArr.length; i++) {
			pArr[i].print(); // pArr�� Parent Ÿ���̱� ������ Parent�� �� �� ����. ���� print �޼ҵ嵵 Parent�� �ִ� �޼ҵ带 �ҷ��;� �� �� ����
			// ������ Child1, Child2�� print �޼ҵ尡 ����� 
			// ����? ���� ���ε� ����
			// pArr�� Parent�̱� ������ Parent�� print�� ���� ���ε� ������
			// �������� ��� �������̵��� �������� ��� ����Ǿ� �ֱ� ������ ���� Child1, Child2�� print�� ���� ���ε��Ǿ� ��µȴ�.
		}
		

	}
}
