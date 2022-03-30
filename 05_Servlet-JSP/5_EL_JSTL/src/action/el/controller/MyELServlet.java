package action.el.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.model.vo.Person;

/**
 * Servlet implementation class MyELServlet
 */
@WebServlet("/myEL.do")
public class MyELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// name, gender, age, beverage, products, book, movie
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		String beverage = request.getParameter("beverage");
		String[] products = request.getParameterValues("product");
		String book = request.getParameter("book");
		String movie = request.getParameter("movie");
		
		Person p = new Person(name, gender, age);
		
		request.setAttribute("person", p);
		request.setAttribute("beverage", beverage);
		request.setAttribute("products", products);
		
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", movie);
		
		request.setAttribute("year", 2021);
		
		session.setAttribute("beverage", "아메리카노");
		application.setAttribute("beverage", "물");
		// beverage라는 이름의 값이 page를 제외한 모든 스코프에 들어가 있게 됨
		
		request.getRequestDispatcher("/02_el/01_2_elEnd.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
