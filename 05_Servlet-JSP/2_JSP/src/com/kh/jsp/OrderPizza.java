package com.kh.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPizza extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String pizza = req.getParameter("pizza");
		String[] topping = req.getParameterValues("topping");
		String[] side = req.getParameterValues("side");
		String totalPrice = req.getParameter("totalPrice");
		
		String toppingStr = "";
		String sideStr = "";
		
		if(topping != null) {
			for(int i = 0; i < topping.length; i++) {
				if(i == 0) {
					toppingStr += topping[i];
				} else {
					toppingStr += ", " + topping[i];
				}
			}
			
		} else {
			toppingStr = "없음";
		}
		
		if(side != null) {
			for(int i = 0; i < side.length; i++) {
				if(i == 0) {
					sideStr += side[i];
				} else {
					sideStr += ", " + side[i];
				}
			}
		} else {
			sideStr = "없음";
		}
		
		req.setAttribute("pizza", pizza);
		req.setAttribute("topping", toppingStr);
		req.setAttribute("side", sideStr);
		req.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/pizzaEnd.jsp");
		view.forward(req, resp);
	}
}
