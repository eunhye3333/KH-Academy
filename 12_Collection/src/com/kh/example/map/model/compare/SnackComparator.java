package com.kh.example.map.model.compare;

import java.util.Comparator;

public class SnackComparator implements Comparator<String> { 
	// Map�� ������ key�θ� �� �� �ֱ� ������ Comparator�� ���׸��� String����(key Ÿ��) ���� ��

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2); // ��������
	} 


}
