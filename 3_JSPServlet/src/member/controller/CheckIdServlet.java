package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/checkId.me")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId = request.getParameter("inputId");
		
		int result = new MemberService().checkId(inputId); // 있냐 없냐만 중요하기 때문에 쿼리에 COUNT 사용
		
		request.setAttribute("result", result);
		request.setAttribute("checkedId", inputId);
		// 멈춰 있는 상태가 아니라 중복 확인 후 새 창을 불러오기 때문에 입력한 값이 날아가버림 -> 입력한 값이 날아가지 않게 미리 저장해둠
		
		request.getRequestDispatcher("WEB-INF/views/member/checkIdForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
