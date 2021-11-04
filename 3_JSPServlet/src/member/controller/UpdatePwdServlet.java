package member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Member m = (Member)session.getAttribute("loginUser");
//		
//		String userPwd = request.getParameter("userPwd");
//		String newPwd = request.getParameter("newPwd");
//		String newPwd2 = request.getParameter("newPwd2");
//		
//		if(newPwd.equals(newPwd2)) {
//			m.setUserPwd(newPwd);
//			int result = new MemberService().updatePwd(m.getUserId(), userPwd, newPwd);
//			if(result > 0) {
//				Member loginUser = new MemberService().selectMember(m.getUserId());
//				request.getSession().setAttribute("loginUser", loginUser);
//				response.sendRedirect("myPage.me"); 
//			} else {
//				request.setAttribute("msg", "비밀번호 변경에 실패했습니다.");
//				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
//			}
//		} else {
//			request.setAttribute("msg", "비밀번호 변경에 실패했습니다. (비밀번호가 서로 다름)");
//			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
//		}
		
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		map.put("newPwd", newPwd);
		
		int result = new MemberService().updatePwd(map);
		
		if(result > 0) {
			loginUser.setUserPwd(newPwd);
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect("myPage.me");
			
		} else {
			request.setAttribute("msg", "비밀번호 변경에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
