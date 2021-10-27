package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Servlet에 도착!");
		
		// HttpServletRequest.getParameter(String name):String
		// 		매개변수 name? 내가 보낸 input의 name속성값 = url(쿼리스트링)에 들어가 있는 변수 역할
		// HttpServletRequest request를 매개변수로 받아왔기 때문에 객체를 만들어 주지 않아도 됨 
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
//		String food = request.getParameter("food"); 
		// 값이 여러개인 경우, 여러 개의 값을 가지고 오고 싶은 경우
		// HttpServletRequest.getParameterValues(String name):String[]
		String[] food = request.getParameterValues("food");
		
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		for(String f : food) {
			System.out.println(f);
		}
		
		response.setContentType("text/html; charset=UTF-8"); // 자바를 이용해 html을 만드는 것이기 때문에 필요함
		PrintWriter out = response.getWriter(); // 화면단에 보내주는 IO(스트림) 역할
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보 출력화면</title>");
		out.println("<style>");
		out.println("h2{color : red;}");
		out.println("span{font-weight: bold;}");
		out.println("#name{color: orange;}");
		out.println("#gender{color: yellow; background: black;}");
		out.println("#age{color: green;}");
		out.println("#city{color: blue;}");
		out.println("#hight{color: navy;}");
		out.println("#food{color: purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(GET)</h2>");
		out.println("<span id='name'>" + name + "</span>님은 ");
		out.println("<span id='age'>" + age + "</span>이시며, ");
		out.printf("<span id='city'>%s</span>에 사는 ", city);
		out.printf("키 <span id='height'>%s</span>cm인 ", height);
		out.printf("<span id='gender'>%s</span>입니다. ", gender);
		out.print("좋아하는 음식은 <span id='food'>");
		
		for(int i = 0; i < food.length; i++) {
			if(i==0) {
				out.printf("%s", food[i]);
			} else {
				out.printf(", %s", food[i]);
			}
		}
		
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");
		// 가시성이 안 좋음
	}
}
