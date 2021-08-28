package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}

	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		str = "";
		while(st.hasMoreTokens()) {
			str += st.nextToken();
		}
		
		return str;
	}

	public String firstCap(String input) {
		// 단어 하나
//		String firstStr = input.substring(0, 1).toUpperCase();
//		String remainStr = input.substring(1);
//		input = firstStr + remainStr;
//		return input;
		
		// 단어 여러 개
		StringTokenizer st = new StringTokenizer(input, " ");
		String[] word = new String[st.countTokens()];
		int i = 0;
		while(st.hasMoreTokens()) {
			word[i] = st.nextToken();
			word[i] = word[i].substring(0, 1).toUpperCase() + word[i].substring(1).toLowerCase();
			i++;
		}
		input = "";
		for(int j = 0; j < word.length; j++) {
			if(j == word.length - 1) {
				input += word[j];
			} else {
				input += word[j] + " ";
			}
		}
		
		return input;
	}

	public int findChar(String input, char one) {
		int count = 0;
		
		one = Character.toLowerCase(one);
		input = input.toLowerCase();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		return count;
	}
	
}
