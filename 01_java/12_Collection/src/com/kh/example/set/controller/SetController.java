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
		// add(E e):boolean			set 안에 e 추가
		set.add(new Dog("자두", 6.4));
		set.add(new Dog("두이", 4));
		set.add(new Dog("호두", 3.4));
		System.out.println(set); // 순서 유지 안 됨
		
		set.add(new Dog("자두", 6.4)); // new라고 해서 주소 값이 달라서 다른 객체로 판단
		System.out.println(set); // 자두가 두 번 들어감 -> 원래 중복 저장이 되면 안 됨
		// 주소가 아니라 안에 있는 값으로 인지하게 만들어야 함 -> equals 메소드 오버라이딩
		
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2); // 순서는 유지되고 중복 저장 안 됨
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		System.out.println(set2);
		
		// get 메소드가 없음 -> Set에는 인덱스가 없기 때문에

		// 요소 가져오기 1. Set을 List로 바꾸기
		ArrayList<Dog> list = new ArrayList<Dog>(set2);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 요소 가져오기 2. iterator 이용
		Iterator<Dog> it = set2.iterator();
		while(it.hasNext()) { // 만약 Iterator 안에 다음 값이 존재한다면
			Dog d = it.next(); // 다음 값을 가지고 와라
			System.out.println(d);
		}
		
		TreeSet<String> test = new TreeSet<String>();
		test.add("박윤수");
		test.add("나준영");
		test.add("조원빈");
		test.add("송민경");
		test.add("조현수"); // 정렬이 자동으로 됨
		test.add("박윤수"); // 중복 저장은 안 됨
		System.out.println(test);
		// String은 정렬 기준이 있어서 알아서 정렬이 됨
		
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		System.out.println(set3); // 에러 발생 java.lang.ClassCastException
		// Dog에 정렬 기준이 없어서 Comparable로 바꿀 수 없다
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogComparator()); // 이름만 보겠다고 함
		set4.addAll(set3);
		set4.add(new Dog("로이", 2.1)); // 몸무게가 달라도 추가 안 됨. 이름만 보고 추가하기 때문에
		System.out.println(set4);
		
	}
}
