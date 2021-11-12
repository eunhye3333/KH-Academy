package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import board.model.service.BoardService;
import board.model.vo.Reply;

/**
 * Servlet implementation class InsertReplyServlet
 */
@WebServlet("/insertReply.bo")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		Reply r = new Reply();
		
		r.setRefBId(bId);
		r.setReplyWriter(writer);
		r.setReplyContent(content);
		
		ArrayList<Reply> list = new BoardService().insertReply(r); // DML을 해도 하고 나서 전체적인 정보를 가지고 와야 하기 때문에 반환값이 int가 아니라 list가 됨
		
		response.setContentType("application/json; charset=UTF-8");
//		Gson gson = new Gson();
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder gb2 = gb.setDateFormat("yyyy-MM-dd"); // 원하는 날짜 형식으로 변경하기
		Gson gson = gb2.create();
		gson.toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
