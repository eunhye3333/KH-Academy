package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
	// 배열은 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	// 배열의 선언
	//     자료형[] 배열명;
	//     자료형 배열명[];
	// 배열의 할당
	//     자료형[] 배열명 = new 자료형[배열크기];
	//     자료형 배열명[] = new 자료형[배열크기];
	//     new 연산자를 통해 Heap 메모리 영역에 공간을 배열 크기만큼 생성
	//     생성이 되는 순간 그 공간에 대한 주소값 발생
	//     발생한 주소값은 대입 연산자에 의해 배열명 공간에 대입이 됨(참조하고 있음)
	// 배열의 초기화
	//     1) 인덱스 이용 : Zero-based
	//     2) for문 이용: 규칙이 있을 때만 사용 가능
	//     3) 선언과 동시에 초기화
	//         자료형[] 배열명 = {값};
	//         자료형[] 배열명 = new 자료형[]{값};
	
	public void method1() {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		int num6 = 60;
		int num7 = 70;
		int num8 = 80;
		int num9 = 90;
		// 같은 자료형이니까 배열로 만들면 되겠다
		
//		int[] arr; // Stack에 arr이라는 공간이 생김. 그 공간에는 실제로 데이터를 집어넣을 수는 없음.
		int[] arr = new int[9]; // Heap 영역에 9개의 공간이 생기고, 주소값이 생성됨. 이것을 대입 연산자를 이용해 Stack에 있는 arr에 집어넣음
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		System.out.println(arr[5]);
//		System.out.println(arr[6]);
//		System.out.println(arr[7]);
//		System.out.println(arr[8]);
		// 아무것도 대입하지 않았는데 다 0이 출력됨
		//  -> int의 기본값이 0이라서
		// 초기화를 하지 않으면 쓰레기값이 들어가는 경우는 지역변수이면서 Stack에 선언된 변수에만 해당됨
		// Heap 영역에 공간이 만들어지면 데이터를 집어넣지 않아도 해당 자료형의 기본값으로 초기화됨
		// Heap 영역에서는 값이 없으면 안 되기 때문
		
		// for문으로 출력하는 것이 더 간편함
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		// 인덱스를 이용한 초기화
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		arr[5] = 60;
//		arr[6] = 70;
//		arr[7] = 80;
//		arr[8] = 90;
		
		// 하지만 규칙이 있기 때문에 for문을 이용한 초기화
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (i+1) * 10;
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		// 다 값을 넣은 상태로 출력
		
		// 따로 쓰지 않고 바로 합쳐도 됨
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1) * 10;
			System.out.print(arr[i] + " ");
		}
		// 값 하나 넣고 출력하고, 하나 넣고 출력하고 (하나씩)
		
		System.out.println();
		
		System.out.println(arr); // Heap 영역에 만들어진 공간에 대한 주소값이 찍힘 -> [I@6d06d69c
		// 정확한 주소는 아님 정확한 주소겂은 자바가 제공하지 않기 때문에 알 수 없음
	}

	public void method2() {
		// 선언과 동시에 초기화
		int[] iArr1 = {1, 2, 3, 4, 5};
		int[] iArr2 = new int[] {11, 22, 33, 44, 55};
		String[] strArr = {"red", "orange", "yellow"};
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < iArr2.length; i++) {
			System.out.print(iArr2[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
	}
	
	public void method3() {
		// 배열의 단점
		
		// 5개의 공간을 가진 int형 배열 iArr
		int[] iArr = new int[5];
		// 10개의 공간을 가진 char형 배열 cArr
		char[] cArr = new char[10];
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < cArr.length; i++) {
			System.out.print(cArr[i] + "|");
			// char에 대한 기본값은 빈 공간임 따라서 구분을 위해 | 출력
		}
		
		System.out.println();
		
		// 주소값 출력
		System.out.println("iArr : " + iArr);
		System.out.println("cArr : " + cArr);
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("새로 할당할 배열의 크기 입력 : ");
		int size = sc.nextInt();
		
		iArr = new int[size];
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		
		System.out.println();
		System.out.println("iArr : " + iArr); // 주소가 바뀌었는지 확인
		// 주소가 바뀜 -> 이전에 있던 애가 아니라 새로운 애가 할당되었다는 말
		
		iArr = null; // 배열의 연결을 끊고 싶은 경우
		
	}
}
