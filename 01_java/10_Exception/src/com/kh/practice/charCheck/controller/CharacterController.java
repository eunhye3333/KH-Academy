package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	public CharacterController() {}

	public int countAlpha(String s) throws CharCheckException {
		if(s.contains(" ")) {
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
		} else {
			int count = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
					if(!(s.charAt(i) > 90 && s.charAt(i) < 97)) {
						count++;
					}
				}
			}
			return count;
		}
	}
	
	
}
