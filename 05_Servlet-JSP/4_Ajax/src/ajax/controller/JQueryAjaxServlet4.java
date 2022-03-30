package ajax.controller;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjaxServlet4
 */
@WebServlet("/jQueryAjax4.do")
public class JQueryAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String student1 = request.getParameter("student1");
		String student2 = request.getParameter("student2");
		String student3 = request.getParameter("student3");
		
		System.out.println(student1 + ", " + student2 + ", " + student3);
		
//		ArrayList<String> student = new ArrayList<String>();
//		
//		student.add(request.getParameter("student1"));
//		student.add(request.getParameter("student2"));
//		student.add(request.getParameter("student3"));
//		
//		response.getWriter().println(student);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
