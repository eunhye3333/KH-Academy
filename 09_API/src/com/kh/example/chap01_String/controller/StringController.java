package com.kh.example.chap01_String.controller;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringController {
	public void method1() {
		// String test
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java"); // 똑같은 문자열이 들어가 있지만 new를 사용해 새로운 공간을 만들기 때문에 주소값이 달라짐
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		boolean bool1 = str1 == str2; // 문자열에서의 == 비교는 주소값을 비교함
									  // 내용을 비교하려면 equals 사용
		boolean bool2 = str1 == str3;
		System.out.println("str1과 str2의 주소는 같은가? : " + bool1);
		System.out.println("str1과 str3의 주소는 같은가? : " + bool2);
		
		System.out.println("str1의 hashCode : " + str1.hashCode());
		System.out.println("str2의 hashCode : " + str2.hashCode());
		System.out.println("str3의 hashCode : " + str3.hashCode()); // 해시코드는 모두 같음
		// hashCode메소드 특징 -> 값이 같다면 같은 해시코드를 만들어라
		
		// 실제 주소값
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3)); // 주소값이 다름
		
		str1 += "API";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1)); // 주소값이 달라짐 아예 교체가 된 것
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3)); 
	}
	
	public void method2() {
		// StringBuffer/StringBuilder
		// 어떤 문자열을 작업할 때 계속해서 문자열을 변경해야 할 경우에는 String 클래스의 '불변'이라는 특징 상
		// 값이 새로 생기고 참조 위치만 바꿔주기 때문에 가비지컬렉터가 계속 지워야 하는 단점이 있음
		// String 클래스의 경우는 변경이 적고 읽기만 많은 경우에 더 적합하다
		// 변경이 많은 경우 StringBuffer/StringBuilder를 이용하는 것이 더 적합함
		// 변경/저장을 위한 메모리 공간(버퍼)을 내부에 지니는데, 초기에는 16개의 공간이 생기고 자동으로 증가도함
		// 두 클래스의 차이는 동기화가 되느냐 안되느냐의 차이
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("초기 buffer1의 수용량 : " + buffer1.capacity()); // 16
		System.out.println("buffer1에 들어가 있는 실제 값의 길이 : " + buffer1.length());
		
		System.out.println();
		
		StringBuffer buffer2 = new StringBuffer(100);
		System.out.println("초기 buffer2의 수용량 : " + buffer2.capacity()); // 100으로 지정했기 때문에 100이 됨
		System.out.println("buffer2에 들어가 있는 실제 값의 길이 : " + buffer2.length());
		
		System.out.println();
		
		StringBuffer buffer3 = new StringBuffer("abc");
		System.out.println("초기 buffer3의 수용량 : " + buffer3.capacity()); // 19가 나옴. 초기 수용량 + "abc" 길이
		System.out.println("buffer3에 들어가 있는 실제 값의 길이 : " + buffer3.length());
		
		System.out.println();
		
		System.out.println("buffer3의 실주소값 : " + System.identityHashCode(buffer3));
		// append(String str):StringBuffer -> 값을 추가하는 메소드
		// 무조건 맨 뒤에 값을 추가함
		buffer3.append("abc");
		System.out.println("abc 추가 후의 buffer3 : " + buffer3);
		System.out.println("abc 추가 후의 buffer3 용량 : " + buffer3.capacity()); // 용량이 감당 가능하면 늘어나지 않음
		System.out.println("abc 추가 후의 buffer3 길이 : " + buffer3.length());
		
		System.out.println();
		
		buffer3.append("def");
		System.out.println("def 추가 후의 buffer3 : " + buffer3);
		System.out.println("def 추가 후의 buffer3 용량 : " + buffer3.capacity());
		System.out.println("def 추가 후의 buffer3 길이 : " + buffer3.length());
		
		buffer3.append("abc").append("def"); // 메소드 체이닝
// StringBuffer ------------
//		StringBuffer.append(String str):StringBuffer
		System.out.println("abc, def 추가 후의 buffer3 : " + buffer3);
		System.out.println("abc, def 추가 후의 buffer3 용량 : " + buffer3.capacity());
		System.out.println("abc, def 추가 후의 buffer3 길이 : " + buffer3.length());
		System.out.println("buffer3의 실주소값 : " + System.identityHashCode(buffer3)); // 주소값이 같음 값의 수정이 이루어지는 것
		
		// insert(int offset, String str):StringBuffer
		// 값을 내가 원하는 부분에 str을 추가할 수 있는 메소드
		// offset -> 원하는 위치
		buffer3.insert(2, "zzz");
		System.out.println("인덱스 2에 zzz 추가 후의 buffer3 : " + buffer3);
		
		// delete(int start, int end):StringBuffer
		// start <= index < end
		// 삭제하는 메소드
		buffer3.delete(2, 5);
		System.out.println("인덱스 2부터 인덱스 5까지 삭제 후의 buffer3 : " + buffer3);
		// abzzzcabcdefabcdef -> 5까지면 zzzc가 지워져야 하는 데 zzz만 지워짐
		// 마지막 인덱스는 포함하지 않는다
		
		System.out.println();
		
		// reverse():StringBuffer
		// 거꾸로 만들어줌
		buffer3.reverse();
		System.out.println("reverse 후의 buffer3 : " + buffer3);
		
		StringBuffer sb = new StringBuffer("abc");
		sb.append("zzz").insert(2, "yy").reverse().delete(1, 3);
		System.out.println(sb);
	}
	
	public void method3() {
		// String 안에 있는 메소드
		String str = "Hello World";
		
		// charAt(int index):char
		// String의 index번째의 char 반환
		char ch = str.charAt(4);
		System.out.println(ch);
		
		// concat(String str):String
		// 본래 값 뒤에 str을 추가해주는 메소드
		String concatStr = str.concat("!!!");
		System.out.println(concatStr);
		// 이렇게 해도 추가 가능
		str += "!!!";
		System.out.println(str);
		
		// equals():boolean
		System.out.println("concatStr.equals(str) : " + concatStr.equals(str));
		
		// subString(int beginIndex):String
		// subString(int beginIndex, int endIndex):String
		// 오버로딩이 되어 있음. end 인덱스는 포함이 되지 않은 형태로 반환.
		// String의 일부를 반환해 줌
		// beginIndex만 있는 경우 해당 인덱스부터 끝까지 가져옴
		// endIndex가 있는 경우에는 endIndex를 포함하지 않고 가져옴
		System.out.println("str.substring(6) : " + str.substring(6));
		System.out.println("str.substring(0, 4) : " + str.substring(0, 4));
		
		// replace(char oldChar, char newChar):String
		// oldChar를 newChar로 대체한 문자열 반환
		System.out.println("str.replace('l', 'e') : " + str.replace('l', 'e'));
		
		// toUpperCase()/toLowerCase():String
		// 모두 대문자/소문자로 바꿔 반환
		System.out.println("str.toUpperCase() : " + str.toUpperCase());
		System.out.println("str.toLowerCase() : " + str.toLowerCase());
		Scanner sc = new Scanner(System.in);
		System.out.println("더 하시겠습니까?(y/n) : ");
		String answerStr = sc.nextLine().toLowerCase();
		char answer = answerStr.charAt(0);
		if(answer == 'y') {
			System.out.println("계속 한답니다.");
		} else if(answer == 'n') {
			System.out.println("그만 한답니다.");
		}
		// 계속 하시겠습니까? (y/n) -> 만약 대문자로 입력될 경우 소문자로 이루어진 조건문은 분기를 타지 않음
		// 해당 메소드를 이용해 모두 대/소문자로 바꿔주면 대문자와 소문자를 다 따로 조건문에 적지 않아도 됨
		
		// equalsIgnoreCase():boolean
		// 대소문자를 가지리 않고 문자열을 비교하는 메소드
		String str2 = "WONDERFUL";
		String str3 = "wonderful";
		System.out.println(str2.equals(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
		
		// trim():String
		// 앞/뒤에 있는 빈 공간을 제거한 문자열 반환
		String str4 = "    java";
		String str5 = "java    ";
		String str6 = " java   ";
		String str7 = "ja    va";
		System.out.println(str4 + " : " + str4.trim());
		System.out.println(str5 + " : " + str5.trim());
		System.out.println(str6 + " : " + str6.trim());
		System.out.println(str7 + " : " + str7.trim()); // 중간에 있는 경우에는 문자열로 인식해서 안 없어짐
		
		// split(String str):String[]
		// 문자열을 분리해주는 메소드
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		// ", "를 구분자로 사용하여 자름
		String[] strArr = splitStr.split(", "); // ,로만 해도 되는데 그러면 문자열에 띄어쓰기가 다 붙음
		System.out.println(strArr);
		
		// 일반 for문
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// 향상된 for문 = for-each
		// 인덱스를 이용하지 않고 하나하나 돌기만 하면 되는 경우 사용
		for(String s : strArr) { // strArr에 있는 변수를 하나씩 꺼내서 s에 임시로 담음
			System.out.println(s); // 임시로 담은 것을 출력
		}
	}
	
	public void method4() {
		String str = "Java, Oracle, JDBC, Front, Server, Framework";
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println("분리된 문자열 개수 : " + st.countTokens());
		// 배열이 아니므로 for문으로 출력 어려움
		// while과 hasMoreTokens 메소드 사용
		// hasMoreTokens():boolean
		// 다음 토큰(분리된 문자열) 값이 있다면 true 반환
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
			// nextToken():String
			// 해당하는 다음 값 반환
			// 토큰이 있을 경우 다음 값을 반환
		}
		
		String str2 = "Apple,Banana-Cream*Dessert#Egg Fruits";
		// 구분자가 하나가 아닌 경우 나누는 법
		String[] strArr = str2.split(",-*# ");
		// 정규표현식을 이용하면 split으로도 가능
//		String[] strArr = str2.split(",|-|*|#| "); -> 정규표현식. 아예 안 되는 것은 아님
		for(String s :strArr) {
			System.out.println(s); // 하나하나로 인식하는 게 아니라 뭉텅이로 인식해서 아무것도 잘리지 않음
		}
		
		StringTokenizer st2 = new StringTokenizer(str2, ",-* #");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		// 각각의 구분자를 인식해 나눠짐
		
		
		
	}
}
