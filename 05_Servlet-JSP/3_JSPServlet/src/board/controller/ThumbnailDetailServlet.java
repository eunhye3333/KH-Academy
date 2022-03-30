package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;

/**
 * Servlet implementation class ThumbDetailServlet
 */
@WebServlet("/detail.th")
public class ThumbnailDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		// 사진과 게시글 내용을 가지고 와야 하기 때문에 Service를 두 번 왔다갔다 해야 함
		BoardService service = new BoardService();
		Board board = service.selectBoard(bId, null);
		ArrayList<Attachment> fileList = service.selectThumbnail(bId);
		
		String page = null;
		if(fileList != null) {
			request.setAttribute("board", board);
			request.setAttribute("fileList", fileList);
			page = "WEB-INF/views/thumbnail/thumbnailDetail.jsp";
		} else {
			request.setAttribute("msg", "사진 게시판 상세보기 실패");
			page = "WEB-INF/views/common/errorPage";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
