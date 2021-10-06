package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	private MemberMenu menu = new MemberMenu();
//	private MemberDAO md = new MemberDAO();
	private MemberService mService = new MemberService();
	// ������ Controller -> Service -> DAO�� ����Ǿ��� ������ MemberDAO ��ü�� �ƴ϶� MemberService ��ü�� �������
	
	public void insertMember() {
		Member mem = menu.insertMember();
		
		int result = mService.insertMember(mem);
		
		if(result > 0) {
			menu.displaySuccess(result + "���� ���� �߰��Ǿ����ϴ�.");
		} else {
			menu.displayError("������ ���� ���� �� ���� �߻�");
		}
	}

	public void selectAll() {
		ArrayList<Member> list = mService.selectAll();
		
		if(!list.isEmpty()) {
			menu.displayMember(list);
		} else {
			menu.displayError("��ȸ ����� �����ϴ�.");
		}
	}

	public void selectMember() {
		int sel = menu.selectMember();
		
		ArrayList<Member> list = null;
		
		switch(sel) {
		case 1: 
			String id = menu.inputMemberId();
			list = mService.selectMemberId(id);
			
			break;
		case 2:
			char gender = menu.inputGender();
			list = mService.selectGender(gender);
			break;
		case 0: return;
		}
		
		if(!list.isEmpty()) {
			menu.displayMember(list);
		} else {
			menu.displayError("��ȸ ����� �����ϴ�.");
		}
	}
	
}
