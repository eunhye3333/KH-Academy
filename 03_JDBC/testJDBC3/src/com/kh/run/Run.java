package com.kh.run;

import com.kh.model.service.MemberService;

public class Run {
	public static void main(String[] args) {
	//	int result = new MemberService().insertMember();
	//	if(result >= 380) {
	//		System.out.println("����");
	//	} else {
	//		System.out.println("����");
	//	}
		
		new MemberService().updateMember();
	}
}
