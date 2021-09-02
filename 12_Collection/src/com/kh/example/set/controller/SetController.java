package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.kh.example.set.model.compare.DogComparator;
import com.kh.example.set.model.vo.Dog;

public class SetController {
	public void doSet() {
		HashSet<Dog> set = new HashSet<Dog>();
		// add(E e):boolean			set �ȿ� e �߰�
		set.add(new Dog("�ڵ�", 6.4));
		set.add(new Dog("����", 4));
		set.add(new Dog("ȣ��", 3.4));
		System.out.println(set); // ���� ���� �� ��
		
		set.add(new Dog("�ڵ�", 6.4)); // new��� �ؼ� �ּ� ���� �޶� �ٸ� ��ü�� �Ǵ�
		System.out.println(set); // �ڵΰ� �� �� �� -> ���� �ߺ� ������ �Ǹ� �� ��
		// �ּҰ� �ƴ϶� �ȿ� �ִ� ������ �����ϰ� ������ �� -> equals �޼ҵ� �������̵�
		
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("����", 2.1));
		set2.add(new Dog("����", 8.3));
		set2.add(new Dog("�κ�", 5.0));
		set2.add(new Dog("����", 2.1));
		System.out.println(set2); // ������ �����ǰ� �ߺ� ���� �� ��
		set2.add(new Dog("����", 6.1));
		set2.add(new Dog("����", 5.2));
		set2.add(new Dog("����", 9.5));
		set2.add(new Dog("����", 12.5));
		System.out.println(set2);
		
		// get �޼ҵ尡 ���� -> Set���� �ε����� ���� ������

		// ��� �������� 1. Set�� List�� �ٲٱ�
		ArrayList<Dog> list = new ArrayList<Dog>(set2);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// ��� �������� 2. iterator �̿�
		Iterator<Dog> it = set2.iterator();
		while(it.hasNext()) { // ���� Iterator �ȿ� ���� ���� �����Ѵٸ�
			Dog d = it.next(); // ���� ���� ������ �Ͷ�
			System.out.println(d);
		}
		
		TreeSet<String> test = new TreeSet<String>();
		test.add("������");
		test.add("���ؿ�");
		test.add("������");
		test.add("�۹ΰ�");
		test.add("������"); // ������ �ڵ����� ��
		test.add("������"); // �ߺ� ������ �� ��
		System.out.println(test);
		// String�� ���� ������ �־ �˾Ƽ� ������ ��
		
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		System.out.println(set3); // ���� �߻� java.lang.ClassCastException
		// Dog�� ���� ������ ��� Comparable�� �ٲ� �� ����
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogComparator()); // �̸��� ���ڴٰ� ��
		set4.addAll(set3);
		set4.add(new Dog("����", 2.1)); // �����԰� �޶� �߰� �� ��. �̸��� ���� �߰��ϱ� ������
		System.out.println(set4);
		
	}
}
