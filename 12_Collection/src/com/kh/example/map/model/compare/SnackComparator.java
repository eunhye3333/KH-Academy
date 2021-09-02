package com.kh.example.map.model.compare;

import java.util.Comparator;

public class SnackComparator implements Comparator<String> { 
	// Map은 정렬을 key로만 할 수 있기 때문에 Comparator에 제네릭은 String으로(key 타입) 들어가야 함

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2); // 내림차순
	} 


}
