package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징 처리에 필요한 변수 세팅
		int listCount;		// 총 게시글 개수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 한 페이지에서 보일 페이지 수
		int boardLimit;		// 한 페이지에서 보일 게시글 수
		int maxPage;		// 가장 마지막 페이지
		int startPage;		// 페이징이 된 페이지 중 시작 페이지
		int endPage;		// 페이징이 된 페이지 중 마지막 페이지
		
		BoardService bService = new BoardService(); // 여러 번 가지고 와야 하기 때문에 객체를 따로 만들어둠
		// 페이징 처리 1단계 : 몇 페이지가 나오는지 계산하기 위한 전체 게시글 개수 조회 
		listCount = bService.getListCount();
		
		// 페이징 처리 2단계 : 현재 페이지 설정
		currentPage = 1; // 처음 들어가면 무조건 1페이지기 때문에 기본적으로 1로 둠
		if(request.getParameter("currentPage") != null) { 
			// currentPage가 null이 아니다 -> 파라미터로 currentPage가 들어왔다 -> 페이징 처리가 된 버튼을 눌렀다
			// currentPage가 null이다 -> 처음 페이지에 들어왔다 -> currentPage = 1
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징 처리 3단계 : boardLimit와 pageLimit 설정
		pageLimit = 10;
		boardLimit = 10;
		
		// 페이징 처리 4단계 : 각 변수에 알맞은 계산식 작성
//		maxPage = listCount / boardLimit;
//		if(listCount % boardLimit != 0) {
//			maxPage++;
//		}
		
		// 나머지가 있으면 1을 더해 줘야 함
		maxPage = (int)Math.ceil((double)listCount / boardLimit); // 자동 형변환으로 double을 만들어 줌 -> 결과 값이 double이 됨 -> 나머지가 0만 아니면 올림해줘야 함
		// 올림이 됐기 때문에 int로 변환해줘도 됨
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = bService.selectList(pi); // 게시글 가져오기
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 조회 실패");
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

