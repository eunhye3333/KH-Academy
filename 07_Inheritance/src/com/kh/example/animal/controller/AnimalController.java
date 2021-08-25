package com.kh.example.animal.controller;

import com.kh.example.animal.model.vo.Animal;
import com.kh.example.animal.model.vo.Dog;
import com.kh.example.animal.model.vo.Snake;

public class AnimalController {
	public void method() {
		Animal a = new Animal("������", 9, 6.3);
//		System.out.println(a.toString());
		System.out.println(a); // ������ ��ü�� �ּҰ��� ��µǾ�� ��
		// but �ּҰ��� ���� �ʰ� toString �޼ҵ带 �ҷ��� �� ����
		
		
		Dog d = new Dog();
		d.setName("����");
		d.setAge(1);
		d.setWeight(5.2);
		d.setHeight(50);
		d.setHair("���");
//		System.out.println(d.toString()); // 50.0 ��� ���� Dog�� inform()���� height, hair�� ����
		System.out.println(d);
		// name, age, weight �߰�����
		
		Dog d2 = new Dog("����", 2, 2.5, 30, "�ܸ�");
//		System.out.println(d2.toString()); // �Ű����� �����ڿ� name, age, weight�� �ʱ�ȭ�ϴ� �κ��� �������� �ʾƼ� �⺻������ ��µ�
		System.out.println(d2);
		
		Snake s = new Snake();
		s.setName("�����");
		s.setAge(1);
		s.setWeight(6.3);
		s.setPattern("����");
//		System.out.println(s.toString());
		System.out.println(s);
		
		Snake s2 = new Snake("�����", 2, 3.6, "����");
//		System.out.println(s2.toString());
		System.out.println(s2);
		
		
	}
}
