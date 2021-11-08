package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet("/noticeUpdateForm.no")
public class NoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("number"));
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		String nickName = request.getParameter("nickName");
		String date = request.getParameter("date");
		
		String[] splitDate = date.split("-");
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]) - 1;
		int day = Integer.parseInt(splitDate[2]);
		
		Date noticeDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		
		Notice notice = new Notice(noticeNo, noticeTitle, noticeContent, null, nickName, 0, noticeDate, null);
		
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("WEB-INF/views/notice/noticeUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
