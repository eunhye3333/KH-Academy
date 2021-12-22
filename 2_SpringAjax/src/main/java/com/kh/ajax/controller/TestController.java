package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Sample;
import com.kh.ajax.model.vo.User;

@Controller
public class TestController {
	
	@Autowired
	private Sample sam;
	
	@RequestMapping("test.do")
	public void test() {
		// 확인용 메소드
		System.out.println(sam); 
		// <beans:bean class="com.kh.ajax.model.vo.Sample"></beans:bean>만 한 경우 : Sample이 만들어졌고 값이 안 들어감 
		// -> 기본 생성자를 이용해 객체 생성
	}
	// 뷰로 값 보내기
	// 1. ServletOutputStream을 이용하여 전송 : PrintWriter 사용
	@RequestMapping("test1.do")
	public void test1(@RequestParam("name") String name, @RequestParam("age") int age, HttpServletResponse response) {
		System.out.println(name);
		System.out.println(age);
		
		try {
			PrintWriter out = response.getWriter();
			
			if(name.equals("강건강") && age == 20) {
				out.println("ok");
			} else {
				out.println("fail");
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Ajax는 다른 페이지로 이동하는 것이 아니라 해당 페이지에서 작동하는 것이기 때문에 반환값으로 주소를 넘겨주지 않아도 됨
//		return null;
	}
	
//	@RequestMapping("test2.do")
	// 뷰로 값 보내기
	// 2. annotation 사용
//	@ResponseBody // 해당 어노테이션을 추가해야 리턴하는 것이 화면의 이름이 아니라 데이터라고 인식할 수 있음
//	public String test2() {
//		JSONObject job = new JSONObject();
//		// JSON : map과 동일한 방식
//		job.put("no", 123);
//		job.put("title", "return json object test");
////		job.put("writer", "남나눔");
////		job.put("content", "JSON 객체를 뷰로 리턴합니다.");
//		
//		// 한글 인코딩
//		// 1. URLEncoder 사용 : 이 자체로 사용하는 것이 아니라 인코딩을 해놨기 때문에 뷰에서 디코딩을 해야 함
//		try {
//			job.put("writer", URLEncoder.encode("남나눔", "UTF-8"));
//			job.put("content", URLEncoder.encode("JSON 객체를 뷰로 리턴합니다.", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
////		return job; // JSON 객체 리턴 -> 오류 발생
//		return job.toJSONString(); // 화면의 이름으로 생각해서 넘겨짐
//	}
	
	// 한글 인코딩
	// 2. 반환값을 void로 두기 : PrintWriter 사용
//	@RequestMapping("test2.do")
//	public void test2(HttpServletResponse response) {
//		JSONObject job = new JSONObject();
//		// JSON : map과 동일한 방식
//		job.put("no", 123);
//		job.put("title", "return json object test");
//		job.put("writer", "남나눔");
//		job.put("content", "JSON 객체를 뷰로 리턴합니다.");
//		
//		try {
//			response.setContentType("application/json; charset=UTF-8"); // 인코딩
//			PrintWriter out = response.getWriter();
//			out.println(job);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	// 한글 인코딩
	// 3. @RequestMapping의 produces 속성을 이용해 보내는 방식 지정
	@RequestMapping(value="test2.do", produces="application/json; charset=UTF-8")
	@ResponseBody 
	public String test2() {
		JSONObject job = new JSONObject();
		// JSON : map과 동일한 방식
		job.put("no", 123);
		job.put("title", "return json object test");
		job.put("writer", "남나눔");
		job.put("content", "JSON 객체를 뷰로 리턴합니다.");
		
		return job.toJSONString(); 
	}
	
//	@RequestMapping("test3.do")
//	public void test3(HttpServletResponse response) {
//		ArrayList<User> list = new ArrayList<User>();
//		list.add(new User("u111", "p111", "강건강", 20, "k111@kh.or.kr", "01011112222"));
//		list.add(new User("u222", "p222", "남나눔", 33, "n222@kh.or.kr", "01022223333"));
//		list.add(new User("u333", "p333", "도대담", 17, "d333@kh.or.kr", "01033334444"));
//		list.add(new User("u444", "p444", "류라라", 23, "r444@kh.or.kr", "01044445555"));
//		list.add(new User("u555", "p555", "문미미", 29, "m555@kh.or.kr", "01055556666"));
//		
//		JSONArray jArr = new JSONArray();
//		
//		
//		for(User user : list) {
//			JSONObject job = new JSONObject();
//			
//			job.put("userId", user.getUserId());
//			job.put("userPwd", user.getUserPwd());
//			job.put("userName", user.getUserName());
//			job.put("age", user.getAge());
//			job.put("email", user.getEmail());
//			job.put("phone", user.getPhone());
//			
//			jArr.add(job);
//		}
//		
//		try {
//			response.setContentType("application/json; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println(jArr); // JSONObject에 한 번 더 담아서 보내도 됨 -> 한 번 더 담아서 보낼 경우 jArr에 이름이 생기는 것
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@RequestMapping(value="test3.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String test3() {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("u111", "p111", "강건강", 20, "k111@kh.or.kr", "01011112222"));
		list.add(new User("u222", "p222", "남나눔", 33, "n222@kh.or.kr", "01022223333"));
		list.add(new User("u333", "p333", "도대담", 17, "d333@kh.or.kr", "01033334444"));
		list.add(new User("u444", "p444", "류라라", 23, "r444@kh.or.kr", "01044445555"));
		list.add(new User("u555", "p555", "문미미", 29, "m555@kh.or.kr", "01055556666"));
		
		JSONArray jArr = new JSONArray();
		
		
		for(User user : list) {
			JSONObject job = new JSONObject();
			
			job.put("userId", user.getUserId());
			job.put("userPwd", user.getUserPwd());
			job.put("userName", user.getUserName());
			job.put("age", user.getAge());
			job.put("email", user.getEmail());
			job.put("phone", user.getPhone());
			
			jArr.add(job);
		}
		
		return jArr.toJSONString();
	}
}
