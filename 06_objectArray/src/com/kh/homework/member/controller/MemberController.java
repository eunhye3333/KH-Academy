package com.kh.homework.member.controller;

import com.kh.homework.member.model.vo.Member;

public class MemberController {
	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public int existMemberNum() {
		int count = 0;
		
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean checkId(String input) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getId().equals(input)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] == null) {
					m[i] = new Member(id, name, password, email, gender, age);
					break;
				}
			}
		}
	}
	
	public String searchId(String id) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getId().equals(id)) {
						return "찾으신 회원 조회 결과입니다.\n" + m[i].inform();
					}
				}
			}
		}
		return "검색 결과가 없습니다.";
	}
	
	public Member[] searchName(String name) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getName().equals(name)) {
						Member[] nameRe = {m[i]};
						return nameRe;
					}
				}
			}
		}
		return null;
	}
	
	public Member[] searchEmail(String email) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getEmail().equals(email)) {
						Member[] emailRe = {m[i]};
						return emailRe;
					}
				}
			}
		}
		return null;
	}
	
	public boolean updatePassword(String id, String password) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getId().equals(id)) {
						m[i].setPassword(password);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean updateName(String id, String name) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {	
					if(m[i].getId().equals(id)) {
						m[i].setName(name);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean updateEmail(String id, String email) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getId().equals(id)) {
						m[i].setEmail(email);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean delete(String id) {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					if(m[i].getId().equals(id)) {
						m[i] = null;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void delete() {
		m = null;
	}
	
	public Member[] printAll() {
		if(m != null) {
			for(int i = 0; i < m.length; i++) {
				if(m[i] != null) {
					System.out.println(m[i].inform());
				}
			}
		}
		return m;
	}
}
