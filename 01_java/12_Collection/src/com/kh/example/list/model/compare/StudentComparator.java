package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {
	// 제네릭을 해 주어야 compare 메소드의 매개변수가 Student로 나옴
	
	@Override
	public int compare(Student o1, Student o2) {
		// 비교 주체 : o1
//		int standard = o1.getScore();
		// 비교 대상 : o2
//		int object = o2.getScore();
		
		// 오름차순
		// 비교 주체가 비교 대상과 같으면 0을 반환,
		// 비교 주체가 비교 대상보다 작으면 -1을 반환,
		// 비교 주체가 비교 대상보다 크면 1을 반환
		
//		if(standard > object) {
//			return 1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return -1;
//		}
		
		// 내림차순
//		if(standard > object) {
//			return -1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		// Integer 안에 있는 compareTo 메소드 사용하여 간단하게도 가능
		// 하지만 이때는 int가 아닌 Wrapper 클래스 사용하여야 함
		Integer standard = o1.getScore();
		Integer object = o2.getScore();
		// -> 메소드를 사용하기 위해 클래스로 바꿔 줌
		
		// 점수가 같을 때 이름으로 오름차순
		int result = -standard.compareTo(object);
		String standardName = o1.getName(); // 비교 주체 이름
		String objectName = o2.getName(); // 비교 대상 이름
		
		if(result == 0) {
			return standardName.compareTo(objectName);
		} else {
			return result;
		}
		
//		return standard.compareTo(object);
		
	}

}
