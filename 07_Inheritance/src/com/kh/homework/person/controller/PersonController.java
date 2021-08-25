package com.kh.homework.person.controller;

import com.kh.homework.person.model.vo.Employee;
import com.kh.homework.person.model.vo.Student;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] person = new int[2];
		// 학생 수 세기
		if(s != null) {
			for(int i = 0; i < s.length; i++) {
				if(s[i] != null) {
					person[0]++;
				}
			}
		}
		
		// 직장인 수 세기
		if(e != null) {
			for(int i = 0; i < e.length; i++) {
				if(e[i] != null) {
					person[1]++;
				}
			}
		}
		
		return person;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		if(s != null) {
			for(int i = 0; i < s.length; i++) {
				if(s[i] == null) {
					s[i] = new Student(name, age, height, weight, grade, major);
					break;
				}
			}
		}
	}
	
	public Student[] printStudent(){
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		if(e != null) {
			for(int i = 0; i < e.length; i++) {
				if(e[i] == null) {
					e[i] = new Employee(name, age, height, weight, salary, dept);
					break;
				}
			}
		}
	}
	
	public Employee[] printEmployee(){
		return e;
	}
}
