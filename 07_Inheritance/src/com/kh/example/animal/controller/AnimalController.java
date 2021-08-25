package com.kh.example.animal.controller;

import com.kh.example.animal.model.vo.Animal;
import com.kh.example.animal.model.vo.Dog;
import com.kh.example.animal.model.vo.Snake;

public class AnimalController {
	public void method() {
		Animal a = new Animal("강아지", 9, 6.3);
//		System.out.println(a.toString());
		System.out.println(a); // 원래는 객체의 주소값이 출력되어야 함
		// but 주소값이 뜨지 않고 toString 메소드를 불러온 것 같음
		
		
		Dog d = new Dog();
		d.setName("초코");
		d.setAge(1);
		d.setWeight(5.2);
		d.setHeight(50);
		d.setHair("장모");
//		System.out.println(d.toString()); // 50.0 장모만 나옴 Dog의 inform()에는 height, hair만 있음
		System.out.println(d);
		// name, age, weight 추가해줌
		
		Dog d2 = new Dog("딸기", 2, 2.5, 30, "단모");
//		System.out.println(d2.toString()); // 매개변수 생성자에 name, age, weight를 초기화하는 부분이 존재하지 않아서 기본값으로 출력됨
		System.out.println(d2);
		
		Snake s = new Snake();
		s.setName("방울이");
		s.setAge(1);
		s.setWeight(6.3);
		s.setPattern("육각");
//		System.out.println(s.toString());
		System.out.println(s);
		
		Snake s2 = new Snake("비단이", 2, 3.6, "빗살");
//		System.out.println(s2.toString());
		System.out.println(s2);
		
		
	}
}
