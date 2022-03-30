package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		Member m = new Member(); // 멤버 타입의 객체 생성
		m.printName(); // name이 null로 나옴
		// memberName을 초기화하지 않아서 기본값이 들어가 있음 (Heap 영역의 메모리는 비어 있을 수 없다)
		m.changeName("박신우");
		m.printName();
	}
}
