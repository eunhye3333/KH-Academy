package com.kh.run;

import com.kh.model.service.MemberService;

public class Run {
	public static void main(String[] args) {
	//	int result = new MemberService().insertMember();
	//	if(result >= 380) {
	//		System.out.println("성공");
	//	} else {
	//		System.out.println("실패");
	//	}
		
		new MemberService().updateMember();
	}
}
