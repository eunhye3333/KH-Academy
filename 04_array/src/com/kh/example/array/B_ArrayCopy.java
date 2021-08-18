package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	// ���� ���� : �迭�� �ּҸ� ����
	// ���� ���� : ������ ���ο� �迭�� �ϳ� �����Ͽ� ���� ���� �� ����
	//       1) for��     2) System.arraycopy    3) Arrays.copyOf     4) clone (��� x)
	public void method1() {
		int[] originArr= {1, 2, 3, 4, 5}; // ����� ���ÿ� �ʱ�ȭ
		int[] copyArr = originArr; // ���� ����. �ּҰ��� copyArr�� �������
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();
			
		// �纻 �迭�� 0��°�� �ٲ������� �ұ��ϰ� ���� �迭�� �ٲ� (���� �ּҰ��� ������ �־)
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// �����迭�� �纻 �迭�� ���� �����ϰ� �ִ� �迭�� ���� (�ּҰ��� ����)
	}
	
	public void method2() {
		// for���� �̿��� ���� ����
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[originArr.length]; // originArr�� ���̸�ŭ�� ���ο� �迭�� ������� (�ٸ� �ּ�)
		
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];
			// copy�� ���� �����ؼ� �������. ���� copyArr�� ���� ���� ������� ����, originArr�� �����ʿ� ������ ��
			// copyArr = originArr�̶�� �ϸ� �ּҰ��� ���� �������̱� ������ ���ȣ�� ����Ͽ� ���� ���� �����;� ��
		}
		
		System.out.println("originArr : " + originArr); // [I@6d06d69c
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr); // [I@7852e922
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		// �ּҰ� �ٸ� : ������ ����
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();

		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// ���� �迭�� �纻 �迭�� ���� �����ϰ� �ִ� �迭�� �ٸ� (�ּҰ��� �ٸ�)
	}
	
	public void method3() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// System.arraycopy() �̿��� ����
		// System.arraycopy(src, srcPos, dest, destPos, length);
		//    src : ���� �迭
		//    srcPos : src�� ���� ������ -> ���� �迭���� ���縦 ������ ��ġ
		//    dest : ���� �迭 (�纻 �迭)
		//    destPos : ���� �迭���� �ٿ��ֱ⸦ ������ ��ġ
		//    length  : ���� ���� (�󸶳� ��������)
		
		// ���� �迭�� 0��°�������� ���� �迭�� ���̸��� ���� ��, ���� �迭 3��°������ �ٿ��ֱ�
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		originArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
	}
	
	public void method4() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		// Arrays.copyOf �̿��� ���� ����
		// Arrays.copyOf(original, newLength) -> ��ȯ�� int[]
		//     original : ���� �迭
		//     newLength : ������ ����
		// copy�� ���� ������� -> ���� �� ����� �迭�� ����� �شٴ� ��
		// ��� �ٿ������� ������� �ʰ� ������ �͸� ����� ���� -> ������ ���� ��ȯ�ϴ� ��
		
		copyArr = Arrays.copyOf(originArr, originArr.length);
		
		// copyOf + ctrl + Ŭ���ϸ� ������ ���� �޼ҵ��� ������ Ȯ�� ����
//		public static int[] copyOf(int[] original, int newLength) {
//	        int[] copy = new int[newLength]; // newLenght��¥�� ���ο� �迭�� ����� ����
//	        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength)); // ���ο� �迭�� ���� �迭�� ����
//	        return copy; // ����� ���ο� �迭�� �ּҰ��� copyArr�� ���� 
//	    }
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
		
		System.out.println();
		originArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i]+ " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]+ " ");
		}
	}
}
