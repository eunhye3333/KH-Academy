package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class insertMemberServlet
 */
@WebServlet(name="InsertMemberServlet", urlPatterns="/insert.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("joinUserId");
		String userPwd = request.getParameter("joinUserPwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interest = request.getParameterValues("interest");
		
		// Member에는 interest가 String이라서 변환해주어야 함
		String strInterest = "";
		if(interest != null) { // interest를 입력하지 않아도 실행 가능하게 
			for(int i = 0; i < interest.length; i++) {
				if(i == 0) {
					strInterest += interest[i];
				} else {
					strInterest += ", " + interest[i];
				}
			}
		}
		
		Member member = new Member(userId, userPwd, userName, nickName, phone, email, address, strInterest, null, null, null);
		int result = new MemberService().insertMember(member);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "회원가입에 실패했습니다.");
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
