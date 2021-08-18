package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 순서대로 넣은 후 값 출력
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice2() {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 역순으로 넣은 후 값 출력
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = array.length - i;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice3() {
		// 입력받은 수만큼 배열 크기를 할당하고 1부터 입력받은 값까지 초기화
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int[] array = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice4() {
		// String 배열 초기화
		String[] array = {"사과", "귤", "포도", "복숭아", "참외"};
		
		System.out.println(array[1]);
	}
	
	public void practice5() {
		// 문자열을 입력받아 문자 하나하나를 배열에 넣고 문자 검색
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		
		char[] chArr = new char[str.length()];
		System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
			if(chArr[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(ch + " 개수 : " + count);
	}
	
	public void practice6() {
		// "월" ~ "일"까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력받아 출력
		Scanner sc = new Scanner(System.in);
		String[] day = {"월", "화", "수", "목", "금 ", "토", "일"};
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num >= 0 && num <= 6) {
			System.out.println(day[num] + "요일");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void practice7() {
		// 배열의 길이를 직접 입력하여 배열 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int size = sc.nextInt();
		
		int[] array = new int[size];
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			System.out.print("배열 " + i +"번째 인덱스에 넣을 값 : ");
			array[i] = sc.nextInt();
			sum += array[i];
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("총합 : " + sum);
	}
	
	public void practice8() {
		// 3 이상인 홀수 자연수를 입력받아 출력
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if(num < 3 || num % 2 == 0) {
				System.out.println("다시 입력하세요.");
			} else {
				break;
			}
		}
		
		int[] array = new int[num];
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(i <= num / 2) {
				array[i] = i+1;
				count++;
				System.out.print(array[i] + " ");
			} else {
				count--;
				array[i] = count; 
				System.out.print(array[i] + " ");
			}
		}
	}
	
	public void practice9() {
		// 사용자가 입력한 값이 배열에 있는지 확인
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		String[] chicken = {"양념", "후라이드", "간장", "파닭", "로제"};
		
		boolean flag = false;
		for(int i = 0; i < chicken.length; i++) {
			if(name.equals(chicken[i])) {
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println(name + "치킨 배달 가능");
		} else {
			System.out.println(name + "치킨은 없는 메뉴입니다.");
		}
	}
	
	public void practice10() {
		// 주민등록번호 성별 자리 이후부터 *로 가리고 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pId = sc.nextLine();
		char[] arrPId = new char[pId.length()];
		
		for(int i = 0; i < arrPId.length; i++) {
			arrPId[i] = pId.charAt(i);
		}
		
		char[] copyArr = new char[arrPId.length];
		System.arraycopy(arrPId, 0, copyArr, 0, arrPId.length);
		
		for(int i = 0; i < copyArr.length; i++) {
			if(i > 7) {
				copyArr[i] = '*';
			}
			System.out.print(copyArr[i]);
		}
	}
	
	public void practice11() {
		// 난수 저장
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		// 난수 저장 후 최대값, 최소값 출력
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice13() {
		// 난수 저장 중복 제거
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}

			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		
	}
	
	public void practice14() {
		// 로또 번호 오름차순 정렬
		int[] arr = new int[6];
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		
		int s = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				s = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = s;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice15() {
		// 문자열 입력받아 저장 후 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char[] ch = new char[str.length()];
		int[] index = new int[ch.length];
		
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
			index[i] = 1;
			
		}
		
		for(int i = 0; i < ch.length; i++) {
			for(int j = 0; j < i; j++) {
				if(ch[i] == ch[j]) {
					index[i] = 0;
				}
			}
		}
		int count = 0;
		System.out.print("문자열에 있는 문자 : ");
		for(int i = 0; i < ch.length; i++) {
			if(index[i] == 1) {
				System.out.print(ch[i] + ", "); // 마지막에 쉼표 없애는 법
				count++;
			}
		}
		System.out.println();
		System.out.println("문자 개수 : " + count);
	}
	
	public void practice16() {
		// 입력한 배열의 길이만큼 문자열 할당 및 문자열 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		
		String[] strArr = new String[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print(i+1 + "번째 문자열 : ");
			strArr[i] = sc.next();
		}

		int msize = 0;
		String[] arr =  new String[strArr.length];
		
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char re = sc.next().charAt(0);
			switch(re) {
			case 'y':
			case 'Y':
				System.out.print("더 입력하고 싶은 개수 : ");
				msize = sc.nextInt();
				arr = Arrays.copyOf(strArr, size);
				
				for(int i = size; i < msize; i++) {
					System.out.print(i + "번째 문자열 : ");
					arr[i] = sc.next();
				}
				break;
			case 'n':
			case 'N':
				System.out.print("[");
				for(int i = 0; i < msize; i++) {
					System.out.print(arr[i]);
					if (i == msize -1) {
						System.out.print("]");
					} else {
						System.out.print(", ");
					}
				}
				return;
				
			default:
				System.out.print("다시 입력하세요 : ");
			}
		}
	}
}
