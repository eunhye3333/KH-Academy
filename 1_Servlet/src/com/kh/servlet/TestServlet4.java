package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] food = request.getParameterValues("food");
		
		String recommendation = null;
		switch(age) {
		case "10대 미만": recommendation = "비눗방울 건"; break;
		case "10대": recommendation = "슬라임"; break;
		case "20대": recommendation = "애플워치"; break;
		case "30대": recommendation = "돈"; break;
		case "40대": recommendation = "지갑"; break;
		case "50대": recommendation = "바디 프랜드"; break;
		}
		
		// jsp에 전달할 데이터 담기 : request
		// -> HTTPServletRequest.setAttribute(String name, Object obj):void
		// --> 첫 번째 매개변수 String name : 데이터를 담는 변수
		// --> 두 번째 매개변수 Object obj : 내가 넘길 데이터
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		String foodStr = "";
		for(int i = 0; i < food.length; i++) {
			if(i == 0) {
				foodStr += food[i];
			} else {
				foodStr += ", " + food[i];
			}
		}
		request.setAttribute("food", foodStr);
		request.setAttribute("recommendation", recommendation);
		
		// Servlet에서 결과 화면을 생성하는 것이 아니라 결과 화면을 출력해주는 곳으로 이동(jsp 파일)
		// 페이지 이동 1. RequestDispatcher.forward() 이용
		//				-> 이동할 페이지에 데이터를 전달 가능 (request, response 유지)
		//				-> url 변경 x
		// 페이지 이동 2. HttpServletResponse.sendRedirect() 이용
		// 				-> 이동할 페이지에 데이터 전달 불가능 (request, response를 새로 생성해서 넘김)
		//				-> 페이지를 이동하면서 url이 같이 변경됨
		
		// String path : 내가 이동하고 싶은 페이지의 위치(경로)
		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet4End.jsp");
		view.forward(request, response); 
		// 위에서 변수에 데이터를 저장한 코드는 view에서 Servlet으로 넘긴 데이터를 받아주기만 한 것임
		// 이 받은 데이터를 넘겨주는 코드가 존재하지 않음 -> testServlet4End에서 받은 데이터가 없기 때문에 출력할 수 있는 데이터가 존재하지 않음
		// 데이터를 어디에 담아서 보낼 것이냐 : request (넘겨줄 데이터를 저장할 공간)
		// -> 나 다시 결과 페이지로 보내 줘라고 요청하는 것이기 때문에 response가 아니라 request를 사용해야 함
	}
}
