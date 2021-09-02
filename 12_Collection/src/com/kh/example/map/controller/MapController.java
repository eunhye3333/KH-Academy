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
		//                                                          ----- 값 두 개 필요
		
		// put(K key, V value):V 		키와 값을 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));
		System.out.println(map);
		// {다이제=단맛[2500원], 새우깡=짠맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]}
		// 키와 value가 =으로 연결되어 있음, 순서 유지가 안 됨, 짠맛 1500이 중복해서 들어가는 것 가능
		map.put("새우깡", new Snack("매운맛", 1500));
		System.out.println(map); // 키가 같아서 매운맛으로 덮어씌워짐
		
		
		// containsKey(Object key):boolean		해당 key가 있는지 확인
		// containsValue(Object value):boolean	해당 value가 있는지 확인
		System.out.println(map.containsKey("새우깡")); // true
		System.out.println(map.containsValue(new Snack("짠맛", 1500))); // false
		// equals로 비교하는데, 주소 값이 다르기 때문에 인식 못 함 -> equals를 오버라이딩하면 인식 가능
		
		// get(Object key):V		키에 해당하는 값 반환
		System.out.println(map.get("다이제"));
		System.out.println(map.get("홈런볼")); // 없는 경우 null 반환
		
		// values():Collection<v>		모든 value를 Collection에 담아 반환
		System.out.println(map.values());
		
		// keySet():Set<k>		map에 포함된 key들을 담아서 Set에 반환
		Set<String> set1 = map.keySet(); // 키의 자료형이 String이기 때문에 제네릭을 String으로 만들어 줘야 함
		System.out.println(set1); // Set으로 저장했으므로 key를 iterator를 이용해 하나씩 돌려볼 수 있음 -> 따라서 키를 가지고 value 값도 가져올 수 있게 됨
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			System.out.println(key + "=" + map.get(key));
		}
		
		// entrySet():Set<Map.Entry<K,V>>		map 안에 있는 매핑된 것들(key, value)을 반환, key와 value들(entry)을 모아 Set으로 반환
		Set<Entry<String, Snack>> set2 = map.entrySet(); // entry -> 키 + 값
		System.out.println(set2);
		Iterator<Entry<String, Snack>> it2 = set2.iterator(); 
		while(it2.hasNext()) { // key와 value가 같이 있어서 키 값을 가지고 벨류를 가져오지 않아도 됨
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry.getKey() + "=" + entry.getValue()); // entry에서 둘 다 가져오기 가능
		}
		
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map); // 한 번에 추가 가능
		System.out.println(map2); // 정렬이 완료가 된 것 (key를 String 정렬 기준으로 정렬함 -> String은 정렬 기준이 존재해서) 오름차순
		
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);
		
		// remove(Object key):V							해당 key의 entry 삭제 후 해당 값 반환
		System.out.println(map3.remove("다이제"));
		System.out.println(map3);
		
		// remove(Object key, Object value):boolean		해당 키와 값이 모두 맞으면 삭제 후 true 반환
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1500))); // value가 달라서 false
		System.out.println(map3);
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1000)));
		System.out.println(map3);
		
		// clear():void 		모든 entry 삭제
		// isEmpty():boolean 	map이 비어 있는지 확인
		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}
	
	public void doProperties() {
		// Properties : key와 value의 타입을 String으로 제한
		Properties prop = new Properties(); // 이미 타입을 String으로 제한하기 때문에 제네릭을 쓰지 않아도 경고가 안 뜸
//		prop.put(1, 10); // String으로 제한한다고 했는데 매개 변수가 Object임
//		System.out.println(prop); // but int도 들어감
		// 이 put 메소드는 Hashtable 안에 있는 메소드임. Properties에는 put 메소드가 없음.
		// 따라서 매개 변수가 String이 아닌 Object임. -> put으로 Properties에 값을 넣는 것은 바람직하지 않음
		
		// Properties에 값을 넣는 메소드
		// setProperty(String key, String value):Object 		Properties에 데이터 추가
		prop.setProperty("채소", "오이");  
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망"); // 같은 키가 있으면 덮어씌워짐 
		System.out.println(prop);
		
		// getProperty(String key):String							key를 통해 value 반환
		// getProperty(String key, String defaultValue):String		key를 통해 value 반환, 해당 key가 없으면 defaultValue 반환
		System.out.println(prop.getProperty("채소"));
		System.out.println(prop.getProperty("견과"));
		System.out.println(prop.getProperty("채소", "땅콩"));
		System.out.println(prop.getProperty("견과", "땅콩"));
		
		
	}
}
