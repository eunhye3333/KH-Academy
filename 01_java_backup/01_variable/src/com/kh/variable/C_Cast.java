package com.kh.variable;

public class C_Cast {
	/* 
	 * ��ȯ: ���� �ڷ����� �ٸ� �ڷ������� ��ȯ�ϴ� �� (�ٲٴ� ��)
	 * 
	 * ���� ����ȯ�� �� ���� �տ� �ٲ� �ڷ����� ������ ������ֿ��� ��
	 *     (�ٲ� �ڷ���)�� or (�ٲ� �ڷ���)����
	 * but �ڵ� ����ȯ������ �ڷ��� ��ø� ������ �� �ִ�
	 * ������ ���� ����ȯ������ �ʼ������� ������־�� �Ѵ�
	 */
	public void rule1() {
		boolean flag = true;
//		falg = 100; boolean �ڷ����� ������ true/false�� �� �� �ֱ� ������ ����ȯ ���� 
		
		// �ڵ� ����ȯ : ũ�Ⱑ ���� �ڷ����� ū �ڷ������� �ٲ�� ��
		// ex. byte -> int, int -> long, int -> double, long -> float, char -> int
		int num = 'A'; // "A"�� �Ұ���. String�� ���� �ڷ����̱� ������ ȣȯ �� ��. char�� ���ڿ� ���ڰ� ��ġ�Ǿ� �ֱ� ������ int�� ���� ����
		System.out.println("num : " + num); // A�� �´� int ���� ��µ�
		
		char ch = 97; 
		System.out.println("ch : " + ch);
		
//		char ch2 = -97; char �������� ������ ���� ������ ������ ������ ������ �� (char�� ���� : 0 ~ 65535) ����� ���� ����
		
		char ch2 = (char)num; // ���� ����ȯ(����� ����ȯ) int�� char���� ũ�� ������ �ڵ� ����ȯ�� ���� ����. ���� ������־�� ��
		System.out.println("ch2 : " + ch2);
		
		int num2 = -97;
		char ch3 = (char)num2;
		System.out.println("ch3 : " + ch3); // ? ��µ�. ?�� 63
		// ?�� ���� ������ ��ü�� ����ǥ�� �ƴ϶�, -97�� char������ ���� ���̱� ������ -97�� ���� ���ڸ� ã�� ���߱� ������ ������ ��ȣ��
		// 63���� ����ǥ�� �ƴ�. -90���� �ص� �Ȱ��� ����� ��µ�
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100L;
		
//		int iSum = iNum + lNum;
		//          int   long
		// ���� �ڷ����� ū �ڷ����� ���󰡱� ������ int�� long�� �Ǹ鼭 long + long�� ��. ����� long
		// ���� �� long ������� int�� �����Ѵٰ� �ϸ� ������ ��
		// �ذ� ��� 1 : ���� ����� long �ڷ������� �ޱ�
		long lSum = iNum + lNum;
		System.out.println("lSum : " + lSum);
		
		// �ذ� ��� 2 : long���� int������ ���� ����ȯ
		int iNum1 = iNum + (int)lNum;
		System.out.println("iNum1 : " + iNum1);
		
		// �ذ� ��� 3 : ���� ����� int�� ���� ����ȯ
		int iNum2 = (int)(iNum + lNum);
		System.out.println("iNum2 : " + iNum2);
	}

}
