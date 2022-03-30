package com.kh.variable;

public class C_Cast {
	/* 
	 * 혛변환: 현재 자료형을 다른 자료형으로 변환하는 것 (바꾸는 것)
	 * 
	 * 원래 형변환을 할 때는 앞에 바꿀 자료형을 무조건 명시해주여야 함
	 *     (바꿀 자료형)값 or (바꿀 자료형)변수
	 * but 자동 형변환에서는 자료형 명시를 생략할 수 있다
	 * 하지만 강제 형변환에서는 필수적으로 명시해주어야 한다
	 */
	public void rule1() {
		boolean flag = true;
//		falg = 100; boolean 자료형은 무조건 true/false만 들어갈 수 있기 때문에 형변환 예외 
		
		// 자동 형변환 : 크기가 작은 자료형이 큰 자료형으로 바뀌는 것
		// ex. byte -> int, int -> long, int -> double, long -> float, char -> int
		int num = 'A'; // "A"는 불가능. String은 참조 자료형이기 떄문에 호환 안 됨. char는 문자와 숫자가 매치되어 있기 때문에 int에 저장 가능
		System.out.println("num : " + num); // A에 맞는 int 값이 출력됨
		
		char ch = 97; 
		System.out.println("ch : " + ch);
		
//		char ch2 = -97; char 범위에는 음수가 없기 때문에 음수를 넣으면 에러가 남 (char의 범위 : 0 ~ 65535) 양수만 저장 가능
		
		char ch2 = (char)num; // 강제 형변환(명시적 형변환) int가 char보가 크기 때문에 자동 형변환이 되지 않음. 따라서 명시해주어야 함
		System.out.println("ch2 : " + ch2);
		
		int num2 = -97;
		char ch3 = (char)num2;
		System.out.println("ch3 : " + ch3); // ? 출력됨. ?는 63
		// ?는 실제 데이터 자체의 물음표가 아니라, -97은 char에서는 없는 값이기 때문에 -97에 대한 문자를 찾지 못했기 때문에 나오는 기호임
		// 63번의 물음표가 아님. -90으로 해도 똑같은 결과가 출력됨
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100L;
		
//		int iSum = iNum + lNum;
		//          int   long
		// 작은 자료형이 큰 자료형을 따라가기 때문에 int가 long이 되면서 long + long가 됨. 결과도 long
		// 따라서 이 long 결과값을 int에 저장한다고 하면 에러가 남
		// 해결 방법 1 : 수행 결과를 long 자료형으로 받기
		long lSum = iNum + lNum;
		System.out.println("lSum : " + lSum);
		
		// 해결 방법 2 : long형을 int형으로 강제 형변환
		int iNum1 = iNum + (int)lNum;
		System.out.println("iNum1 : " + iNum1);
		
		// 해결 방법 3 : 수행 결과를 int로 강제 형변환
		int iNum2 = (int)(iNum + lNum);
		System.out.println("iNum2 : " + iNum2);
	}

}
