package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		Member m = new Member(); // ��� Ÿ���� ��ü ����
		m.printName(); // name�� null�� ����
		// memberName�� �ʱ�ȭ���� �ʾƼ� �⺻���� �� ���� (Heap ������ �޸𸮴� ��� ���� �� ����)
		m.changeName("�ڽſ�");
		m.printName();
	}
}
