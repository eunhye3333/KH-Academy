package action.summary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.model.vo.Person;

/**
 * Servlet implementation class HandlerServlet
 */
@WebServlet("/handler.do")
public class HandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view에서 보낸 값들 받아오기
		// 값 중 일부는 Person객체에 담아 view로 전송
		// view단 위임
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		
		String view = request.getParameter("view");
		
		Person p = new Person(name, gender, age);
		
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/03_summary/" + view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
