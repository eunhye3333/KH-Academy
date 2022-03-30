package com.kh.example.list.model.vo;

public class Student implements Comparable<Student>{
	// Comparable is a raw type. References to generic type Comparable<T> should be parameterized
	// 제네릭으로 타입을 제한해주어야 한다
	private String name;
	private int score;
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + " (" + score + "점)";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		// equals 오버라이딩 방법은 다양함
		// 가장 편한 방법으로 진행
		// -> 이클립스에서 자동완성을 할 때 여기에 쓰는 방법대로 자동완성이 되기 때문에
		
		// 여기 있는 equals가 호출되었다는 것은 객체가 생성이 되었다는 뜻. obj는 나랑 비교할 객체
		// 객체 측면
		if(this == obj) { // 주소값이 같다면
			return true; // 주소값이 같으면 더이상 비교하지 않아도 됨
		}
		if(obj == null) { // equals가 호출되었다는 것은 내 객체는 생성이 되었다는 것인데 나랑 비교할 객체가 null이라면 서로 다를수밖에 없음
			return false;
		}
		if(getClass() != obj.getClass()) { // getClass() 내 클래스의 정보를 반환하는 메소드
			return false;
		}
		
		// 필드(데이터) 측면
		// 진짜 필드 안에 있는 값을 비교하겠다
		Student other = (Student)obj; // 비교를 위하여 형변환
		if(name == null) { // 내 name이 null
			if(other.name != null) {
				return false;
			}
		} else if(!name.equals(other.name)) { // name이 String이기 때문에 String의 equals 사용
			return false;
		}
		if(score != other.score) {
			return false;
		}
		
		return true; // 위에 아무것도 걸리지 않으면 같다고 봄
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31; // 31이 컴퓨터가 계산할 때 적당히 크고 가장 가까운 소수이기 때문에 자주 애용됨
		int result = 1;
		result = PRIME * result + (name == null ? 0 : name.hashCode());
		result = PRIME * result + score;
		// 해시코드를 만들 때 name과 score를 이용하여 만들기. 꼭 이렇게 안 만들어도 됨
		// 보편적인 방법이기 때문에 사용
		
		return result;
	}
	
//	@Override
//	public int compareTo(Object o) { // 제네릭으로 타입을 지정하지 않은 경우 Object가 매개변수가 됨
//		// 만약 Object로 가져왔으면 Student로 바꿔 줘야 함
//		Student other = (Student)o;
//		String otherName = other.name;
//		return name.compareTo(otherName);
//	}
	
	@Override
	public int compareTo(Student o) {
		// 이름(String)으로 오름차순
		// String은 기준이 이미 정해져 있음
		
		// 비교 주체(나)와 비교 대상(o)을 비교하는데
		// 비교 주체가 비교 대상과 같으면 0을 반환,
		// 비교 주체가 비교 대상보다 작으면 -1을 반환,
		// 비교 주체가 비교 대상보다 크면 1을 반환
		// 결과를 뒤집고 싶으면 앞에 - 붙임 -> 내림차순
//		return -name.compareTo(o.name); 
		return name.compareTo(o.name); // o.name -> 비교할 이름
	}
	
}
