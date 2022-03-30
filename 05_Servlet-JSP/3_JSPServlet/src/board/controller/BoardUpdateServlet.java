package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/update.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		String category	= request.getParameter("category");
		
		Board b = new Board();
		
		b.setBoardId(bId);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setCategory(category);
		
		int result = new BoardService().updateBoard(b);
		
		if(result > 0) {
			response.sendRedirect("detail.bo?bId=" + bId + "&upd=Y"); // 수정을 하기 위해서 만든 애라고 알려줌
		} else {
			request.setAttribute("msg", "게시글 수정 실패");
			request.getRequestDispatcher("WEB-INF/views/common/erropPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
