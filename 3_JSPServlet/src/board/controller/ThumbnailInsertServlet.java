package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		System.out.println(title); // null 출력됨 -> encType를 설정했기 때문에 일반적으로 가져오는 방법으로는 가져올 수 없음
//		System.out.println(content);
		
		// enctype이 multipart/form-data로 전송되었는지 확인하고 해당 경우에만 실행함
		if(ServletFileUpload.isMultipartContent(request)) {
			// request 자체를 파일과 다른 것들도 같이 가지고 올 수 있게 바꿔서 만들어줌 : MultipartRequest
			int maxSize = 1024*1024*10; // 10Mbyte
			String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출 : WebContent
			String savePath = root + "thumbnail_uploadFiles/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs(); // 존재하지 않는다면 디렉토리 만들기
			}
			
			
			// import가 안 되는 이유 : 외부 jar에서만 가지고 올 수 있는 클래스이기 때문에, cos.jar 라이브러리가 필요함
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy()); // import가 안됨 -> 라이브러리 필요
			// 기본 생성자가 없음 매개변수 생성자 사용해야 함
			// new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy)
			// 		request : 근간이 되어주는 애, request를 이용해 해석해서 가져다 씀
			//		saveDirectory : 어디다 저장을 할 것이냐
			// 		maxPostSize : 저장할 수 있는 최대 크기
			// 		encoding : 인코딩 방식
			// 		policy : 파일 이름을 바꿀 규약을 뭘 사용할 것인지 -> 원래는 안 만들어줘도 됨, 기본으로 제공하는게 있음
			
			// DefaultFileRenamePolicy (cos.jar 안에 존재)
			// 기본 제공 클래스이기 때문에 사용해도 무방
			// : 같은 파일명이 있는지 검사하고, 있을 경우 파일명 뒤에 숫자를 붙임
			// ex. aaa.jpg, aaa1.jpg, aaa2.jpg
			// -> 파일명을 바꾸는 규약을 넣지 않는 경우 찾기 어려움, 인지할 수 없는 글자가 잇는 파일의 경우 가지고 오기 힘듦, 덮어씌워질 수 있음
			
//			System.out.println(savePath); // E:\5_Servlet_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\3_JSPServlet\thumbnail_uploadFiles/
			// 위 경로에 파일이 이름이 변경돼서 들어가있음 -> 경로가 이상함 -> 서버 옵션에서 server modules without publishing을 체크
			// -> 자기들이 경로를 퍼블리싱해서 만들어 준것이기 때문에 이것을 안 하겠다고 하면 원하는 경로(WebContent 아래)에 폴더가 생성됨
			
			ArrayList<String> saveFiles = new ArrayList<String>(); // 파일의 바뀐 이름을 저장한 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); // 파일의 원래 이름을 저장할 ArrayList
			
			Enumeration<String> files = multiRequest.getFileNames(); // Enumeration : Iterator의 구버전
			while(files.hasMoreElements()) { // 요소들이 있다면
//				System.out.println(files.nextElement()); // thumbnailImg1~4가 찍힘 -> 4, 3, 2, 1 역순으로 가지고 옴
				// getFileNames는 전송 순서의 역순으로 파일을 가지고 옴
				// System.out.println(files.nextElement()); -> 주석 처리 안 하는 경우 찍고, 다음 부분을 name에 넣게 됨 => 중간이 빠짐
				String name = files.nextElement();
				
				if(multiRequest.getFilesystemName(name) != null) {
					// getFilesystemName : rename된 파일명을 가지고 오는 것, null인 경우 사진이 들어가 있지 않다
					saveFiles.add(multiRequest.getFilesystemName(name)); // 바뀐 이름 가지고 오기
					originFiles.add(multiRequest.getOriginalFileName(name)); // 원래 이름 가지고 오기
				}
			}
			
//			System.out.println(saveFiles);
//			System.out.println(originFiles); // 역순으로 들어가 있음
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String writer = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			Board b = new Board(0, 2, "10", title, content, writer, null, 0, null, null, null);
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				Attachment a = new Attachment();
				a.setFilePath(savePath);
				a.setOriginName(originFiles.get(i));
				a.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) {
					a.setFileLevel(0);
				} else {
					a.setFileLevel(1);
				}
				
				fileList.add(a);
			}
			
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result >= 1 + fileList.size()) {
				// board도 넣고 파일도 여러 개를 넣었기 때문에 무조건 0이라고 할 수 없음
				// board 반환값 : 1, attachment 반환값 : fileList.size()
				response.sendRedirect("list.th");
			} else {
				request.setAttribute("msg", "사진 게시판 등록 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				
				// 등록 실패한 경우 저장된 사진을 삭제
				for(int i = 0; i < saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i));
					fail.delete();
				}
			}
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
