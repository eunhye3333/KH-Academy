package com.kh.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		
		int total = 0;
		switch(pizza) {
		case "치즈피자": total += 5000; break;
		case "콤비네이션피자": total += 6000; break;
		case "포테이토피자": total += 7000; break;
		case "고구마피자": total += 7000; break;
		case "불고기피자": total += 8000; break;
		}
		
		for(String t : topping) {
			switch(t) {
			case "고구마무스": total += 1000; break;
			case "콘크림무스": total += 1500; break;
			case "파인애플토핑": total += 2000; break;
			case "치즈토핑": total += 2000; break;
			case "치즈크러스트": total += 2000; break;
			case "치즈바이트": total += 3000; break;
			}
		}
		
		for(String s : side) {
			switch(s) {
			case "오븐구이통닭": total += 9000; break;
			case "치킨스틱&윙": total += 4900; break;
			case "치즈오븐스파게티": total += 4000; break;
			case "새우링&웨지감자": total += 3500; break;
			case "갈릭포테이토": total += 3000; break;
			case "콜라": total += 1500; break;
			case "사이다": total += 1500; break;
			case "갈릭소스": total += 500; break;
			case "피클": total += 300; break;
			case "핫소스": total += 100; break;
			case "파마산치즈가루": total += 100; break;
			}
		}
		
		
		request.setAttribute("orderPizza", pizza);
		request.setAttribute("orderTopping", topping); // 배열로 보내기
		request.setAttribute("orderSide", side);
		request.setAttribute("total", total);
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/04_pizzaEnd.jsp");
		view.forward(request, response);
	}
}
