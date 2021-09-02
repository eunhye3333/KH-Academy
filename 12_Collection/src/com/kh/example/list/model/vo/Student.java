package com.kh.example.list.model.vo;

public class Student implements Comparable<Student>{
	// Comparable is a raw type. References to generic type Comparable<T> should be parameterized
	// ���׸����� Ÿ���� �������־�� �Ѵ�
	private String name;
	private int score;
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + " (" + score + "��)";
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
		// equals �������̵� ����� �پ���
		// ���� ���� ������� ����
		// -> ��Ŭ�������� �ڵ��ϼ��� �� �� ���⿡ ���� ������ �ڵ��ϼ��� �Ǳ� ������
		
		// ���� �ִ� equals�� ȣ��Ǿ��ٴ� ���� ��ü�� ������ �Ǿ��ٴ� ��. obj�� ���� ���� ��ü
		// ��ü ����
		if(this == obj) { // �ּҰ��� ���ٸ�
			return true; // �ּҰ��� ������ ���̻� ������ �ʾƵ� ��
		}
		if(obj == null) { // equals�� ȣ��Ǿ��ٴ� ���� �� ��ü�� ������ �Ǿ��ٴ� ���ε� ���� ���� ��ü�� null�̶�� ���� �ٸ����ۿ� ����
			return false;
		}
		if(getClass() != obj.getClass()) { // getClass() �� Ŭ������ ������ ��ȯ�ϴ� �޼ҵ�
			return false;
		}
		
		// �ʵ�(������) ����
		// ��¥ �ʵ� �ȿ� �ִ� ���� ���ϰڴ�
		Student other = (Student)obj; // �񱳸� ���Ͽ� ����ȯ
		if(name == null) { // �� name�� null
			if(other.name != null) {
				return false;
			}
		} else if(!name.equals(other.name)) { // name�� String�̱� ������ String�� equals ���
			return false;
		}
		if(score != other.score) {
			return false;
		}
		
		return true; // ���� �ƹ��͵� �ɸ��� ������ ���ٰ� ��
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31; // 31�� ��ǻ�Ͱ� ����� �� ������ ũ�� ���� ����� �Ҽ��̱� ������ ���� �ֿ��
		int result = 1;
		result = PRIME * result + (name == null ? 0 : name.hashCode());
		result = PRIME * result + score;
		// �ؽ��ڵ带 ���� �� name�� score�� �̿��Ͽ� �����. �� �̷��� �� ���� ��
		// �������� ����̱� ������ ���
		
		return result;
	}
	
//	@Override
//	public int compareTo(Object o) { // ���׸����� Ÿ���� �������� ���� ��� Object�� �Ű������� ��
//		// ���� Object�� ���������� Student�� �ٲ� ��� ��
//		Student other = (Student)o;
//		String otherName = other.name;
//		return name.compareTo(otherName);
//	}
	
	@Override
	public int compareTo(Student o) {
		// �̸�(String)���� ��������
		// String�� ������ �̹� ������ ����
		
		// �� ��ü(��)�� �� ���(o)�� ���ϴµ�
		// �� ��ü�� �� ���� ������ 0�� ��ȯ,
		// �� ��ü�� �� ��󺸴� ������ -1�� ��ȯ,
		// �� ��ü�� �� ��󺸴� ũ�� 1�� ��ȯ
		// ����� ������ ������ �տ� - ���� -> ��������
//		return -name.compareTo(o.name); 
		return name.compareTo(o.name); // o.name -> ���� �̸�
	}
	
}
