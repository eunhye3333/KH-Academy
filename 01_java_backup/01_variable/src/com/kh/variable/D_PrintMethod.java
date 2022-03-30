package com.kh.variable;

public class D_PrintMethod {
	public void printlnExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		System.out.println(str1); // 줄바꿈이 추가된 출력문. 안녕하세요+enter까지
		System.out.println(str2); // 줄바꿈이 안 되면 그 다음 애들은 바로 뒤에 찍힘. 커서를 줄바꿈으로 밑으로 내려놨기 때문에 아래에 출력됨
		System.out.println(); // 아무것도 출력하지 않는다고 해도 줄바꿈이 출력되기 때문에 이것 자체로 사용 가능 (줄바꿈을 하고 싶은 경우 사용)
	}
	
	public void printExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		System.out.print(str1);
		System.out.print(str2); // 줄바꿈이 되지 않아 방향키를 옮겨도 밑으로 내려가지 않음
//		System.out.print(); 아무것도 넣지 않으면 아무것도 출력되지 않기 때문에 이것만 사용하면 에러가 남. println과 다름
		// printf와 다르게 줄바꿈을 하고 싶을 때는 \n만 사용 가능. %n은 printf에서만 사용 가능.
	}
	
	public void printfExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		
		// System.out.printf(format, args)
		//                   format : 형식
		//                   args : 형식에 들어갈 데이터
		
		// 안녕하세요, 박신우입니다. 반갑습니다. -> 출력
		System.out.printf("%s, 박신우입니다. %s.\n", str1, str2);
		//                str1          str2
		
		// 반갑습니다, 친하게 지내요.
		System.out.printf("%s, 친하게 지내요.", str2); // 위에 찍은 거와 바로 붙여서 나옴. 줄바꿈이 되지 않기 떄문에.
		
		System.out.println();
		
		int age = 20; 
		String name = "박신우";
		String job = "강사";
		// 안녕하세요, 저는 20살 박신우 강사입니다. 만나서 반갑습니다.
		System.out.printf("%s, 저는 %d살 %s %s입니다. 만나서 %s.%n", str1, age, name, job, str2);
		
		System.out.printf("%s, 저는 %s살 %s %s입니다. 만나서 %s.", str1, age, name, job, str2);
		// age는 int를 받고 있기 때문에 %d로 사용해야 한다. 하지만 %s로 해도 출력은 됨. (숫자가 아닌 문자 20으로 인식)
		// 줄바꿈을 해주고 싶으면 println을 넣지 않고 %n or \n을 넣으면 줄바꿈이 됨
		// %n은 줄바꿈 포멧으로 printf에서만 사용 가능한 줄바꿈임
	}
}
