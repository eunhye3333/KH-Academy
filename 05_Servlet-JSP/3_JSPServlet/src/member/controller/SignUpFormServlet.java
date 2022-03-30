package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUpFormServlet
 */
@WebServlet("/signUpForm.me") // 여기에서 url 수정 가능
public class SignUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 단순 페이지 이동이기 때문에 가져가야 하는 데이터가 존재하지 않음
//		response.sendRedirect("WEB-INF/views/member/signUpForm.jsp");
		// 404 에러, sendRedirect를 사용하면 url도 같이 바뀌기 때문에
		// forward 사용
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/signUpForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
