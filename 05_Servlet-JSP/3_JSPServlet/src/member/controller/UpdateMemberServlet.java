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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("myId");
		String userName = request.getParameter("myName");
		String nickName = request.getParameter("myNickName");
		String phone = request.getParameter("myPhone");
		String email = request.getParameter("myEmail");
		String address = request.getParameter("myAddress");
		String[] interest = request.getParameterValues("myInterest");
		
		String strInterest = "";
		
		for(int i = 0; i < interest.length; i++) {
			if(i == 0) {
				strInterest += interest[i];
			} else {
				strInterest += ", " + interest[i];
			}
		}
		
		Member m = new Member(userId, null, userName, nickName, phone, email, address, strInterest, null, null, null);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
//			request.setAttribute("member", m);
//			request.getRequestDispatcher("WEB-INF/views/member/myPage.jsp").forward(request, response);
//			response.sendRedirect("/myPage.me"); // 404 Error : 맨 앞에 /를 붙이면 root Context가 없어짐, 따라서 붙이면 안 됨
			Member loginUser = new MemberService().selectMember(userId);
			request.getSession().setAttribute("loginUser", loginUser); // session으로 값을 가지고 올 때 변경된 값으로 session을 같이 업데이트해줌
			response.sendRedirect("myPage.me"); 
		} else {
			request.setAttribute("msg", "회원 정보 수정에 실패했습니다.");
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
