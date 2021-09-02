package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		ArrayList l = new ArrayList(); // 기본 생성자인 경우 크기 10인 ArrayList
		l.add("박신우");
		l.add(20);
		l.add(new Student());
		// ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		// 제네릭을 설정해 주지 않아서 모든 타입을 받을 수 있다고 경고 메시지가 뜸
//		System.out.println(l);
		
		ArrayList<Student> list = new ArrayList<Student>(3); // 크기가 3인 ArrayList
		// add(E e):boolean		리스트 끝에 데이터 추가
		list.add(new Student("테스트", 0)); // 제네릭으로 타입을 제한했기 때문에 매개변수가 Student 타입으로 바뀜
		list.add(new Student("도대담", 60));
		list.add(new Student("남나눔", 90));
		System.out.println(list); // 순서가 유지됨
		
		list.add(new Student("하현호", 85)); // 배열은 크기를 초과해 추가 안 됨
		System.out.println(list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		list.add(new Student("문미미", 66));
		System.out.println(list);
		// 컬렉션 장점 1. 크기에 제약이 없다 -> 크기를 초과해도 계속 추가가 됨
		
		// 컬렉션 장점 2. 추가/삭제/정렬 등의 기능 처리가 간단
		// add(int index, E e):void		index번째 인덱스에 E 추가
		list.add(0, new Student("류라라", 100)); // 제일 처음에 넣기
		System.out.println(list);
		list.add(3, new Student("강건강", 40));
		System.out.println(list);
		
		// remove(int index):E		해당 index번째 객체 삭제
		list.remove(1); // 삭제가 되면서 삭제되는 객체가 반환이 됨
		System.out.println(list);
		// remove(Object o):boolean		해당 Object 겍체를 찾아서 삭제
		list.remove(new Student("강건강", 40)); // new를 통해 새로운 객체를 만들어 줬기 때문에 주소값이 다름
		// 컴퓨터는 주소값으로 인식하기 때문에 주소값이 다르면 서로 다른 객체로 인식함
		System.out.println(list); // 따라서 삭제가 안 됨
		// 주소값으로 인지하는 것이 아니라 안에 있는 필드 내용으로 인지하게 만들어야 같은 객체인지 다른 객체인지 확인 가능
		// -> equals 메소드 이용
		// equals 메소드는 Object 클래스에 있는 메소드로 String이 오버라이딩해서 사용하는 것
		// 여기에서도 equals를 오버라이딩해서 사용해야 함 
		// -> 오버라이딩 하면 remove 내부에서 사용되는 equals가 Object의 equals가 아니라 오버라이딩된 equals(값을 비교하도록 구현)로 사용되기 때문에 주소값이 아니라 데이터로 비교하여 지워짐
		// 오버라이딩하지 않고 삭제하려면 아래처럼 for문으로 가능
//		for(int i = 0; i < list.size(); i++) {
//			Student std = list.get(i);
//			if(std.getName().equals("강건강") && std.getScore() == 40) {
//				list.remove(i);
//				break;
//			}
//		}
		
		// 정렬
//		Collections.sort(list);
		// The method sort(List<T>) in the type Collections is not applicable for the arguments (ArrayList<Student>)
		// 이 sort 메소드는 ArrayList<Student>를 인자로 하여 사용할 수 없다
		
//		ArrayList<String> test = new ArrayList<String>();
//		test.add("전은정");
//		test.add("곽우찬");
//		test.add("나은혜");
//		test.add("이현애");
//		System.out.println(test);
//		Collections.sort(test);
//		System.out.println(test); // String, int 등의 경우는 정렬 기준을 세우지 않아도 오름차순을 기준으로 정렬 가능
		// 객체의 경우 정렬을 하고자 하는 기준이 정해져 있지 않음 (이름, 점수 등 기준이 있어야 정렬 가능)
		
		Collections.sort(list); // 이름으로 정렬
		System.out.println(list); 
		Collections.sort(list, new StudentComparator());
		System.out.println(list);
		
		list.add(new Student("박보배", 85)); // 같은 점수면 이름으로 오름차순 하고 싶음 => 이름에 대한 정렬 함께 추가해야 함
		list.sort(new StudentComparator());
		System.out.println(list);
		
		// set(int index, E e):E		index번째 있는 요소를 E로 수정
		list.set(3, new Student("박보배", 85)); // 중복 가능
		System.out.println(list);
		
		// get(int index):E			index번째에 있는 요소를 반환
		Student s = list.get(2); // 반환값 : Student -> 제네릭으로 제한해줘서
		System.out.println(s);
		System.out.println(list); // 가지고 오는 거지 삭제는 아니라서 그대로 있음
		
		// contains(Object o):boolean 		o가 리스트에 존재하는지 확인, 있으면 true/없으면 false
		// indexOf(Object o):int			o가 리스트에 위치하는 인덱스 번호 반환
		System.out.println(list.contains(new Student("남나눔", 90))); // new를 했어도 equals를 오버라이딩 했기 때문에 true 반환
		System.out.println(list.indexOf(new Student("남나눔", 90))); 
		System.out.println(list.indexOf(new Student("강건강", 45))); // 존재하지 않으면 -1 반환
		
		// clear():void			안에 있는 요소를 전체 삭제
		// isEmpty():boolean	리스트가 비어 있는지 확인, 비어 있으면 true/비어있지 않으면 false 반환
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
		
	}
}
