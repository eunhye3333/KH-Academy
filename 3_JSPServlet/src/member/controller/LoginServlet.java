package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.me") // web.xml에서 servlet 태그와 servlet-mapping 태그의 역할을 함
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내용 기술
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userPwd);
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		// 1. SELECT COUNT(*)를 사용하지 않은 이유 : 계정이 있다/없다만 판별하는게 아니라 계정 정보를 이용하기 위해서
		// 2. 계정 정보 이용에 첫 번째는 가지고 온 데이터를 메인 화면에 뿌리기 : forward() -> X
		// 3. 로그인 후 다른 서비스를 이용할 때 계속해서 추가적인 로그인을 하지 않음 : session 영역 활용
		
		if(loginUser != null) {
			// 로그인 성공
			// session은 request를 이용해서 만듦
			HttpSession session = request.getSession(); // HttpSession : 세션 영역을 말함
			session.setMaxInactiveInterval(600); // 10분 뒤 세션을 종료하겠다
			session.setAttribute("loginUser", loginUser); // session에도 setAttribute() 존재, session에 값을 넣음
//			response.sendRedirect("index.jsp");
			response.sendRedirect(request.getContextPath()); // 파일명이 나오지 않게 함
		} else {
			// 로그인 실패
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // 메소드를 골라서 오버라이딩 하기 힘드니까 아예 처음부터 두 개를 다 쓰고 내용을 doGet에만 기술
		// post 방식이어도 doGet을 호출하고 있음
		// post 방식인지 get 방식인지 신경쓰지 않아도 됨
	}

}
