package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {
	// ���׸��� �� �־�� compare �޼ҵ��� �Ű������� Student�� ����
	
	@Override
	public int compare(Student o1, Student o2) {
		// �� ��ü : o1
//		int standard = o1.getScore();
		// �� ��� : o2
//		int object = o2.getScore();
		
		// ��������
		// �� ��ü�� �� ���� ������ 0�� ��ȯ,
		// �� ��ü�� �� ��󺸴� ������ -1�� ��ȯ,
		// �� ��ü�� �� ��󺸴� ũ�� 1�� ��ȯ
		
//		if(standard > object) {
//			return 1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return -1;
//		}
		
		// ��������
//		if(standard > object) {
//			return -1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return 1;
//		}
		
		// Integer �ȿ� �ִ� compareTo �޼ҵ� ����Ͽ� �����ϰԵ� ����
		// ������ �̶��� int�� �ƴ� Wrapper Ŭ���� ����Ͽ��� ��
		Integer standard = o1.getScore();
		Integer object = o2.getScore();
		// -> �޼ҵ带 ����ϱ� ���� Ŭ������ �ٲ� ��
		
		// ������ ���� �� �̸����� ��������
		int result = -standard.compareTo(object);
		String standardName = o1.getName(); // �� ��ü �̸�
		String objectName = o2.getName(); // �� ��� �̸�
		
		if(result == 0) {
			return standardName.compareTo(objectName);
		} else {
			return result;
		}
		
//		return standard.compareTo(object);
		
	}

}
