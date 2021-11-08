package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/update.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
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
		String date = request.getParameter("date");
		String nickName = request.getParameter("nickName");
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		
		String[] splitDate = date.split("-");
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]) - 1;
		int day = Integer.parseInt(splitDate[2]);
		
		Date noticeDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		
		Notice notice = new Notice(noticeNo, noticeTitle, noticeContent, null, nickName, 0, noticeDate, null);
		
		int result = new NoticeService().updateNotice(notice);
		
		if(result > 0) {
			// 다시 내 글이 있는 곳으로 갔으면 좋겠음 -> sendRedirect 사용
//			response.sendRedirect("detail.no?no=" + noticeNo); // 이 부분 때문에 수정을 하면 조회수가 +1이 되는 현상 발생
			// detail.no로 넘어가면서 detail.no를 처리하는 서블릿이 수행되는데, 해당 서블릿에는 조회수를 +1하는 로직이 구현되어 있기 때문
			// 따라서 upd=Y를 이용하여 count를 올리지 않는 장치를 함
			response.sendRedirect("detail.no?no=" + noticeNo + "&upd=Y"); 
			// &upd=Y는 업데이트 이후 진행된 것이라고 따로 알려주는 것 -> NoticeDetailServlet에서 처리
		} else {
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			request.setAttribute("msg", "공지사항 수정 실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
