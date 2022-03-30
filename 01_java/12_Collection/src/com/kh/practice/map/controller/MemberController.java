package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map.Entry;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();

	public boolean joinMembership(String id, Member m) {
		if(map.containsKey(id)) {
			return false;
		} else {
			map.put(id, m);
			return true;
		}
	}

	public String login(String id, String password) {
//		Iterator<Entry<String, Member>> it = map.entrySet().iterator(); 
//		while(it.hasNext()) {
//			Entry<String, Member> entry = it.next();
//			if(id.equals(entry.getKey())) {
//				if(password.equals(entry.getValue().getPassword())) {
//					return entry.getValue().getName();
//				}
//			}
//		}
//		return null;
		
		if(map.containsKey(id)) {
			Member m = map.get(id);
			if(password.equals(m.getPassword())) {
				return m.getName();
			}
		}
		return null;
	}

	public boolean changePassword(String id, String oldPw, String newPw) {
//		Iterator<Entry<String, Member>> it = map.entrySet().iterator(); 
//		while(it.hasNext()) {
//			Entry<String, Member> entry = it.next();
//			if(id.equals(entry.getKey())) {
//				if(oldPw.equals(entry.getValue().getPassword())) {
//					entry.getValue().setPassword(newPw);
//					return true;
//				}
//			}
//		}
//		return false;
		
		if(map.containsKey(id)) {
			Member m = map.get(id);
			if(oldPw.equals(m.getPassword())) {
				m.setPassword(newPw);
				return true;
			}
		}
		
		return false;
	}

	public void changeName(String id, String newName) {
		if(map.containsKey(id)) {
			map.get(id).setName(newName);
		}
	}

	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> tm = new TreeMap<String, String>();
		Iterator<String> it = map.keySet().iterator(); 
		while(it.hasNext()) {
			String key = it.next();
			if(name.equals(map.get(key).getName())) {
				tm.put(key, name);
			}
		}
		return tm;
	}
}
