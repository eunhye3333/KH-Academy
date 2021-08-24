package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		// �л� ������ ����, ��� ���
		System.out.println("============�л� ���� ���============");
		
		Student[] inform = ssm.printStudent();
		
		System.out.println();
		System.out.println("============�л� ���� ���============");
		double[] avg = ssm.avgScore();
		System.out.println("�л� ���� �հ� : " + (int)avg[0]);
		System.out.println("�л� ���� ��� : " + avg[1]);
		
		System.out.println();
		System.out.println("============���� ��� ���============");
		for(int i = 0; i < inform.length; i++) {
			if(inform[i].getScore() < StudentController.CUT_LINE) {
				System.out.println(inform[i].getName() + " �л��� ����� ����Դϴ�.");
			} else {
				System.out.println(inform[i].getName() + " �л��� ����Դϴ�.");
			}
		}
		
	}
}
