package com.kh.example.chap03.branch;

public class B_Continue {
	public void method() {
		// 구구단 출력
		// 짝수 단, 짝수 수는 뺀 구구단 출력 (2단 x, 3단 3x1 3x3...)
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
