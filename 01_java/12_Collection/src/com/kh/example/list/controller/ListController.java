package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		ArrayList l = new ArrayList(); // �⺻ �������� ��� ũ�� 10�� ArrayList
		l.add("�ڽſ�");
		l.add(20);
		l.add(new Student());
		// ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		// ���׸��� ������ ���� �ʾƼ� ��� Ÿ���� ���� �� �ִٰ� ��� �޽����� ��
//		System.out.println(l);
		
		ArrayList<Student> list = new ArrayList<Student>(3); // ũ�Ⱑ 3�� ArrayList
		// add(E e):boolean		����Ʈ ���� ������ �߰�
		list.add(new Student("�׽�Ʈ", 0)); // ���׸����� Ÿ���� �����߱� ������ �Ű������� Student Ÿ������ �ٲ�
		list.add(new Student("�����", 60));
		list.add(new Student("������", 90));
		System.out.println(list); // ������ ������
		
		list.add(new Student("����ȣ", 85)); // �迭�� ũ�⸦ �ʰ��� �߰� �� ��
		System.out.println(list);
		System.out.println("���� list�� ��� element ���� : " + list.size());
		list.add(new Student("���̹�", 66));
		System.out.println(list);
		// �÷��� ���� 1. ũ�⿡ ������ ���� -> ũ�⸦ �ʰ��ص� ��� �߰��� ��
		
		// �÷��� ���� 2. �߰�/����/���� ���� ��� ó���� ����
		// add(int index, E e):void		index��° �ε����� E �߰�
		list.add(0, new Student("�����", 100)); // ���� ó���� �ֱ�
		System.out.println(list);
		list.add(3, new Student("���ǰ�", 40));
		System.out.println(list);
		
		// remove(int index):E		�ش� index��° ��ü ����
		list.remove(1); // ������ �Ǹ鼭 �����Ǵ� ��ü�� ��ȯ�� ��
		System.out.println(list);
		// remove(Object o):boolean		�ش� Object ��ü�� ã�Ƽ� ����
		list.remove(new Student("���ǰ�", 40)); // new�� ���� ���ο� ��ü�� ����� ��� ������ �ּҰ��� �ٸ�
		// ��ǻ�ʹ� �ּҰ����� �ν��ϱ� ������ �ּҰ��� �ٸ��� ���� �ٸ� ��ü�� �ν���
		System.out.println(list); // ���� ������ �� ��
		// �ּҰ����� �����ϴ� ���� �ƴ϶� �ȿ� �ִ� �ʵ� �������� �����ϰ� ������ ���� ��ü���� �ٸ� ��ü���� Ȯ�� ����
		// -> equals �޼ҵ� �̿�
		// equals �޼ҵ�� Object Ŭ������ �ִ� �޼ҵ�� String�� �������̵��ؼ� ����ϴ� ��
		// ���⿡���� equals�� �������̵��ؼ� ����ؾ� �� 
		// -> �������̵� �ϸ� remove ���ο��� ���Ǵ� equals�� Object�� equals�� �ƴ϶� �������̵��� equals(���� ���ϵ��� ����)�� ���Ǳ� ������ �ּҰ��� �ƴ϶� �����ͷ� ���Ͽ� ������
		// �������̵����� �ʰ� �����Ϸ��� �Ʒ�ó�� for������ ����
//		for(int i = 0; i < list.size(); i++) {
//			Student std = list.get(i);
//			if(std.getName().equals("���ǰ�") && std.getScore() == 40) {
//				list.remove(i);
//				break;
//			}
//		}
		
		// ����
//		Collections.sort(list);
		// The method sort(List<T>) in the type Collections is not applicable for the arguments (ArrayList<Student>)
		// �� sort �޼ҵ�� ArrayList<Student>�� ���ڷ� �Ͽ� ����� �� ����
		
//		ArrayList<String> test = new ArrayList<String>();
//		test.add("������");
//		test.add("������");
//		test.add("������");
//		test.add("������");
//		System.out.println(test);
//		Collections.sort(test);
//		System.out.println(test); // String, int ���� ���� ���� ������ ������ �ʾƵ� ���������� �������� ���� ����
		// ��ü�� ��� ������ �ϰ��� �ϴ� ������ ������ ���� ���� (�̸�, ���� �� ������ �־�� ���� ����)
		
		Collections.sort(list); // �̸����� ����
		System.out.println(list); 
		Collections.sort(list, new StudentComparator());
		System.out.println(list);
		
		list.add(new Student("�ں���", 85)); // ���� ������ �̸����� �������� �ϰ� ���� => �̸��� ���� ���� �Բ� �߰��ؾ� ��
		list.sort(new StudentComparator());
		System.out.println(list);
		
		// set(int index, E e):E		index��° �ִ� ��Ҹ� E�� ����
		list.set(3, new Student("�ں���", 85)); // �ߺ� ����
		System.out.println(list);
		
		// get(int index):E			index��°�� �ִ� ��Ҹ� ��ȯ
		Student s = list.get(2); // ��ȯ�� : Student -> ���׸����� �������༭
		System.out.println(s);
		System.out.println(list); // ������ ���� ���� ������ �ƴ϶� �״�� ����
		
		// contains(Object o):boolean 		o�� ����Ʈ�� �����ϴ��� Ȯ��, ������ true/������ false
		// indexOf(Object o):int			o�� ����Ʈ�� ��ġ�ϴ� �ε��� ��ȣ ��ȯ
		System.out.println(list.contains(new Student("������", 90))); // new�� �߾ equals�� �������̵� �߱� ������ true ��ȯ
		System.out.println(list.indexOf(new Student("������", 90))); 
		System.out.println(list.indexOf(new Student("���ǰ�", 45))); // �������� ������ -1 ��ȯ
		
		// clear():void			�ȿ� �ִ� ��Ҹ� ��ü ����
		// isEmpty():boolean	����Ʈ�� ��� �ִ��� Ȯ��, ��� ������ true/������� ������ false ��ȯ
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
		
	}
}
