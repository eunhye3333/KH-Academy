package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		// 아이디로 연결하고 있기 때문에 작성자를 닉네임이 아닌 아이디로 가져와야 함
		String noticeWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String date = request.getParameter("date"); // 오늘 날짜로 들어간다면 2021-11-05 형태로 들어감, 아무것도 입력되지 않으면 ""로 비어 있는 값이 들어감
		Date noticeDate = null;
		
		if(date.equals("")) {
			// date가 비어 있으면 오늘 날짜를 넣음
			noticeDate = new Date(new GregorianCalendar().getTimeInMillis()); // 밀리 시간을 이용해 Date에 현재 시간을 넣는 방법
		} else {
			// 뭔가 값이 입력됐다면
			String[] splitDate = date.split("-");
			int year = Integer.parseInt(splitDate[0]);
			int month = Integer.parseInt(splitDate[1]) - 1; // 하나 빼야 현재 달로 인지, 컴퓨터는 현재 달 - 1로 인식하기 때문
			int day = Integer.parseInt(splitDate[2]);
			
			noticeDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis()); 
		}
		
		Notice n = new Notice(0, noticeTitle, noticeContent, noticeWriter, null, 0, noticeDate, null);
		// 필요한 게 적은 경우에는 매개변수 생성자를 이용하지 않고 setter를 이용해도 됨
		
		int result = new NoticeService().insertNotice(n);
		
		if(result > 0) {
			response.sendRedirect("list.no"); // 공지사항 목록에서 작성된 게시글을 가지고 오는 것은 list.no가 하는 일이고 여기에서는 데이터를 보내지 않아도 됨
		} else { 
			request.setAttribute("msg", "공지사항 등록 실패");
			request.getRequestDispatcher("WEB-INF/views/common/erroePage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
