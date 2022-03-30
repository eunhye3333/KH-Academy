package com.kh.example.chap01_String.controller;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringController {
	public void method1() {
		// String test
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java"); // �Ȱ��� ���ڿ��� �� ������ new�� ����� ���ο� ������ ����� ������ �ּҰ��� �޶���
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		boolean bool1 = str1 == str2; // ���ڿ������� == �񱳴� �ּҰ��� ����
									  // ������ ���Ϸ��� equals ���
		boolean bool2 = str1 == str3;
		System.out.println("str1�� str2�� �ּҴ� ������? : " + bool1);
		System.out.println("str1�� str3�� �ּҴ� ������? : " + bool2);
		
		System.out.println("str1�� hashCode : " + str1.hashCode());
		System.out.println("str2�� hashCode : " + str2.hashCode());
		System.out.println("str3�� hashCode : " + str3.hashCode()); // �ؽ��ڵ�� ��� ����
		// hashCode�޼ҵ� Ư¡ -> ���� ���ٸ� ���� �ؽ��ڵ带 ������
		
		// ���� �ּҰ�
		System.out.println("str1�� ���ּҰ� : " + System.identityHashCode(str1));
		System.out.println("str2�� ���ּҰ� : " + System.identityHashCode(str2));
		System.out.println("str3�� ���ּҰ� : " + System.identityHashCode(str3)); // �ּҰ��� �ٸ�
		
		str1 += "API";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		System.out.println("str1�� ���ּҰ� : " + System.identityHashCode(str1)); // �ּҰ��� �޶��� �ƿ� ��ü�� �� ��
		System.out.println("str2�� ���ּҰ� : " + System.identityHashCode(str2));
		System.out.println("str3�� ���ּҰ� : " + System.identityHashCode(str3)); 
	}
	
	public void method2() {
		// StringBuffer/StringBuilder
		// � ���ڿ��� �۾��� �� ����ؼ� ���ڿ��� �����ؾ� �� ��쿡�� String Ŭ������ '�Һ�'�̶�� Ư¡ ��
		// ���� ���� ����� ���� ��ġ�� �ٲ��ֱ� ������ �������÷��Ͱ� ��� ������ �ϴ� ������ ����
		// String Ŭ������ ���� ������ ���� �б⸸ ���� ��쿡 �� �����ϴ�
		// ������ ���� ��� StringBuffer/StringBuilder�� �̿��ϴ� ���� �� ������
		// ����/������ ���� �޸� ����(����)�� ���ο� ���ϴµ�, �ʱ⿡�� 16���� ������ ����� �ڵ����� ��������
		// �� Ŭ������ ���̴� ����ȭ�� �Ǵ��� �ȵǴ����� ����
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("�ʱ� buffer1�� ���뷮 : " + buffer1.capacity()); // 16
		System.out.println("buffer1�� �� �ִ� ���� ���� ���� : " + buffer1.length());
		
		System.out.println();
		
		StringBuffer buffer2 = new StringBuffer(100);
		System.out.println("�ʱ� buffer2�� ���뷮 : " + buffer2.capacity()); // 100���� �����߱� ������ 100�� ��
		System.out.println("buffer2�� �� �ִ� ���� ���� ���� : " + buffer2.length());
		
		System.out.println();
		
		StringBuffer buffer3 = new StringBuffer("abc");
		System.out.println("�ʱ� buffer3�� ���뷮 : " + buffer3.capacity()); // 19�� ����. �ʱ� ���뷮 + "abc" ����
		System.out.println("buffer3�� �� �ִ� ���� ���� ���� : " + buffer3.length());
		
		System.out.println();
		
		System.out.println("buffer3�� ���ּҰ� : " + System.identityHashCode(buffer3));
		// append(String str):StringBuffer -> ���� �߰��ϴ� �޼ҵ�
		// ������ �� �ڿ� ���� �߰���
		buffer3.append("abc");
		System.out.println("abc �߰� ���� buffer3 : " + buffer3);
		System.out.println("abc �߰� ���� buffer3 �뷮 : " + buffer3.capacity()); // �뷮�� ���� �����ϸ� �þ�� ����
		System.out.println("abc �߰� ���� buffer3 ���� : " + buffer3.length());
		
		System.out.println();
		
		buffer3.append("def");
		System.out.println("def �߰� ���� buffer3 : " + buffer3);
		System.out.println("def �߰� ���� buffer3 �뷮 : " + buffer3.capacity());
		System.out.println("def �߰� ���� buffer3 ���� : " + buffer3.length());
		
		buffer3.append("abc").append("def"); // �޼ҵ� ü�̴�
// StringBuffer ------------
//		StringBuffer.append(String str):StringBuffer
		System.out.println("abc, def �߰� ���� buffer3 : " + buffer3);
		System.out.println("abc, def �߰� ���� buffer3 �뷮 : " + buffer3.capacity());
		System.out.println("abc, def �߰� ���� buffer3 ���� : " + buffer3.length());
		System.out.println("buffer3�� ���ּҰ� : " + System.identityHashCode(buffer3)); // �ּҰ��� ���� ���� ������ �̷������ ��
		
		// insert(int offset, String str):StringBuffer
		// ���� ���� ���ϴ� �κп� str�� �߰��� �� �ִ� �޼ҵ�
		// offset -> ���ϴ� ��ġ
		buffer3.insert(2, "zzz");
		System.out.println("�ε��� 2�� zzz �߰� ���� buffer3 : " + buffer3);
		
		// delete(int start, int end):StringBuffer
		// start <= index < end
		// �����ϴ� �޼ҵ�
		buffer3.delete(2, 5);
		System.out.println("�ε��� 2���� �ε��� 5���� ���� ���� buffer3 : " + buffer3);
		// abzzzcabcdefabcdef -> 5������ zzzc�� �������� �ϴ� �� zzz�� ������
		// ������ �ε����� �������� �ʴ´�
		
		System.out.println();
		
		// reverse():StringBuffer
		// �Ųٷ� �������
		buffer3.reverse();
		System.out.println("reverse ���� buffer3 : " + buffer3);
		
		StringBuffer sb = new StringBuffer("abc");
		sb.append("zzz").insert(2, "yy").reverse().delete(1, 3);
		System.out.println(sb);
	}
	
	public void method3() {
		// String �ȿ� �ִ� �޼ҵ�
		String str = "Hello World";
		
		// charAt(int index):char
		// String�� index��°�� char ��ȯ
		char ch = str.charAt(4);
		System.out.println(ch);
		
		// concat(String str):String
		// ���� �� �ڿ� str�� �߰����ִ� �޼ҵ�
		String concatStr = str.concat("!!!");
		System.out.println(concatStr);
		// �̷��� �ص� �߰� ����
		str += "!!!";
		System.out.println(str);
		
		// equals():boolean
		System.out.println("concatStr.equals(str) : " + concatStr.equals(str));
		
		// subString(int beginIndex):String
		// subString(int beginIndex, int endIndex):String
		// �����ε��� �Ǿ� ����. end �ε����� ������ ���� ���� ���·� ��ȯ.
		// String�� �Ϻθ� ��ȯ�� ��
		// beginIndex�� �ִ� ��� �ش� �ε������� ������ ������
		// endIndex�� �ִ� ��쿡�� endIndex�� �������� �ʰ� ������
		System.out.println("str.substring(6) : " + str.substring(6));
		System.out.println("str.substring(0, 4) : " + str.substring(0, 4));
		
		// replace(char oldChar, char newChar):String
		// oldChar�� newChar�� ��ü�� ���ڿ� ��ȯ
		System.out.println("str.replace('l', 'e') : " + str.replace('l', 'e'));
		
		// toUpperCase()/toLowerCase():String
		// ��� �빮��/�ҹ��ڷ� �ٲ� ��ȯ
		System.out.println("str.toUpperCase() : " + str.toUpperCase());
		System.out.println("str.toLowerCase() : " + str.toLowerCase());
		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Ͻðڽ��ϱ�?(y/n) : ");
		String answerStr = sc.nextLine().toLowerCase();
		char answer = answerStr.charAt(0);
		if(answer == 'y') {
			System.out.println("��� �Ѵ�ϴ�.");
		} else if(answer == 'n') {
			System.out.println("�׸� �Ѵ�ϴ�.");
		}
		// ��� �Ͻðڽ��ϱ�? (y/n) -> ���� �빮�ڷ� �Էµ� ��� �ҹ��ڷ� �̷���� ���ǹ��� �б⸦ Ÿ�� ����
		// �ش� �޼ҵ带 �̿��� ��� ��/�ҹ��ڷ� �ٲ��ָ� �빮�ڿ� �ҹ��ڸ� �� ���� ���ǹ��� ���� �ʾƵ� ��
		
		// equalsIgnoreCase():boolean
		// ��ҹ��ڸ� ������ �ʰ� ���ڿ��� ���ϴ� �޼ҵ�
		String str2 = "WONDERFUL";
		String str3 = "wonderful";
		System.out.println(str2.equals(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
		
		// trim():String
		// ��/�ڿ� �ִ� �� ������ ������ ���ڿ� ��ȯ
		String str4 = "    java";
		String str5 = "java    ";
		String str6 = " java   ";
		String str7 = "ja    va";
		System.out.println(str4 + " : " + str4.trim());
		System.out.println(str5 + " : " + str5.trim());
		System.out.println(str6 + " : " + str6.trim());
		System.out.println(str7 + " : " + str7.trim()); // �߰��� �ִ� ��쿡�� ���ڿ��� �ν��ؼ� �� ������
		
		// split(String str):String[]
		// ���ڿ��� �и����ִ� �޼ҵ�
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		// ", "�� �����ڷ� ����Ͽ� �ڸ�
		String[] strArr = splitStr.split(", "); // ,�θ� �ص� �Ǵµ� �׷��� ���ڿ��� ���Ⱑ �� ����
		System.out.println(strArr);
		
		// �Ϲ� for��
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// ���� for�� = for-each
		// �ε����� �̿����� �ʰ� �ϳ��ϳ� ���⸸ �ϸ� �Ǵ� ��� ���
		for(String s : strArr) { // strArr�� �ִ� ������ �ϳ��� ������ s�� �ӽ÷� ����
			System.out.println(s); // �ӽ÷� ���� ���� ���
		}
	}
	
	public void method4() {
		String str = "Java, Oracle, JDBC, Front, Server, Framework";
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println("�и��� ���ڿ� ���� : " + st.countTokens());
		// �迭�� �ƴϹǷ� for������ ��� �����
		// while�� hasMoreTokens �޼ҵ� ���
		// hasMoreTokens():boolean
		// ���� ��ū(�и��� ���ڿ�) ���� �ִٸ� true ��ȯ
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
			// nextToken():String
			// �ش��ϴ� ���� �� ��ȯ
			// ��ū�� ���� ��� ���� ���� ��ȯ
		}
		
		String str2 = "Apple,Banana-Cream*Dessert#Egg Fruits";
		// �����ڰ� �ϳ��� �ƴ� ��� ������ ��
		String[] strArr = str2.split(",-*# ");
		// ����ǥ������ �̿��ϸ� split���ε� ����
//		String[] strArr = str2.split(",|-|*|#| "); -> ����ǥ����. �ƿ� �� �Ǵ� ���� �ƴ�
		for(String s :strArr) {
			System.out.println(s); // �ϳ��ϳ��� �ν��ϴ� �� �ƴ϶� �����̷� �ν��ؼ� �ƹ��͵� �߸��� ����
		}
		
		StringTokenizer st2 = new StringTokenizer(str2, ",-* #");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		// ������ �����ڸ� �ν��� ������
		
		
		
	}
}
