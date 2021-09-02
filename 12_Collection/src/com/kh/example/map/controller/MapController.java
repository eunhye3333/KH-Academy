package com.kh.example.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap(){
		HashMap<String, Snack> map = new HashMap<String, Snack>();
		// HashMap is a raw type. References to generic type HashMap<K,V> should be parameterized
		//                                                          ----- �� �� �� �ʿ�
		
		// put(K key, V value):V 		Ű�� ���� �߰�
		map.put("�����", new Snack("§��", 1500));
		map.put("������", new Snack("�ܸ�", 2500));
		map.put("��������Ĩ", new Snack("§��", 1500));
		map.put("��ҹ�", new Snack("����Ѹ�", 1000));
		System.out.println(map);
		// {������=�ܸ�[2500��], �����=§��[1500��], ��������Ĩ=§��[1500��], ��ҹ�=����Ѹ�[1000��]}
		// Ű�� value�� =���� ����Ǿ� ����, ���� ������ �� ��, §�� 1500�� �ߺ��ؼ� ���� �� ����
		map.put("�����", new Snack("�ſ��", 1500));
		System.out.println(map); // Ű�� ���Ƽ� �ſ������ �������
		
		
		// containsKey(Object key):boolean		�ش� key�� �ִ��� Ȯ��
		// containsValue(Object value):boolean	�ش� value�� �ִ��� Ȯ��
		System.out.println(map.containsKey("�����")); // true
		System.out.println(map.containsValue(new Snack("§��", 1500))); // false
		// equals�� ���ϴµ�, �ּ� ���� �ٸ��� ������ �ν� �� �� -> equals�� �������̵��ϸ� �ν� ����
		
		// get(Object key):V		Ű�� �ش��ϴ� �� ��ȯ
		System.out.println(map.get("������"));
		System.out.println(map.get("Ȩ����")); // ���� ��� null ��ȯ
		
		// values():Collection<v>		��� value�� Collection�� ��� ��ȯ
		System.out.println(map.values());
		
		// keySet():Set<k>		map�� ���Ե� key���� ��Ƽ� Set�� ��ȯ
		Set<String> set1 = map.keySet(); // Ű�� �ڷ����� String�̱� ������ ���׸��� String���� ����� ��� ��
		System.out.println(set1); // Set���� ���������Ƿ� key�� iterator�� �̿��� �ϳ��� ������ �� ���� -> ���� Ű�� ������ value ���� ������ �� �ְ� ��
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			System.out.println(key + "=" + map.get(key));
		}
		
		// entrySet():Set<Map.Entry<K,V>>		map �ȿ� �ִ� ���ε� �͵�(key, value)�� ��ȯ, key�� value��(entry)�� ��� Set���� ��ȯ
		Set<Entry<String, Snack>> set2 = map.entrySet(); // entry -> Ű + ��
		System.out.println(set2);
		Iterator<Entry<String, Snack>> it2 = set2.iterator(); 
		while(it2.hasNext()) { // key�� value�� ���� �־ Ű ���� ������ ������ �������� �ʾƵ� ��
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry.getKey() + "=" + entry.getValue()); // entry���� �� �� �������� ����
		}
		
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map); // �� ���� �߰� ����
		System.out.println(map2); // ������ �Ϸᰡ �� �� (key�� String ���� �������� ������ -> String�� ���� ������ �����ؼ�) ��������
		
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);
		
		// remove(Object key):V							�ش� key�� entry ���� �� �ش� �� ��ȯ
		System.out.println(map3.remove("������"));
		System.out.println(map3);
		
		// remove(Object key, Object value):boolean		�ش� Ű�� ���� ��� ������ ���� �� true ��ȯ
		System.out.println(map3.remove("��ҹ�", new Snack("����Ѹ�", 1500))); // value�� �޶� false
		System.out.println(map3);
		System.out.println(map3.remove("��ҹ�", new Snack("����Ѹ�", 1000)));
		System.out.println(map3);
		
		// clear():void 		��� entry ����
		// isEmpty():boolean 	map�� ��� �ִ��� Ȯ��
		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}
	
	public void doProperties() {
		// Properties : key�� value�� Ÿ���� String���� ����
		Properties prop = new Properties(); // �̹� Ÿ���� String���� �����ϱ� ������ ���׸��� ���� �ʾƵ� ��� �� ��
//		prop.put(1, 10); // String���� �����Ѵٰ� �ߴµ� �Ű� ������ Object��
//		System.out.println(prop); // but int�� ��
		// �� put �޼ҵ�� Hashtable �ȿ� �ִ� �޼ҵ���. Properties���� put �޼ҵ尡 ����.
		// ���� �Ű� ������ String�� �ƴ� Object��. -> put���� Properties�� ���� �ִ� ���� �ٶ������� ����
		
		// Properties�� ���� �ִ� �޼ҵ�
		// setProperty(String key, String value):Object 		Properties�� ������ �߰�
		prop.setProperty("ä��", "����");  
		prop.setProperty("����", "���");
		prop.setProperty("����", "����");
		prop.setProperty("ä��", "�Ǹ�"); // ���� Ű�� ������ ������� 
		System.out.println(prop);
		
		// getProperty(String key):String							key�� ���� value ��ȯ
		// getProperty(String key, String defaultValue):String		key�� ���� value ��ȯ, �ش� key�� ������ defaultValue ��ȯ
		System.out.println(prop.getProperty("ä��"));
		System.out.println(prop.getProperty("�߰�"));
		System.out.println(prop.getProperty("ä��", "����"));
		System.out.println(prop.getProperty("�߰�", "����"));
		
		
	}
}
