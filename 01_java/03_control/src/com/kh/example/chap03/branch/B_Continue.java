package com.kh.example.chap03.branch;

public class B_Continue {
	public void method() {
		// ������ ���
		// ¦�� ��, ¦�� ���� �� ������ ��� (2�� x, 3�� 3x1 3x3...)
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(i % 2 == 0 || j % 2 == 0) {
					continue;
				} 
				System.out.printf("%d * %d = %d%n", i, j, i*j);
			}
		}
	}
}
