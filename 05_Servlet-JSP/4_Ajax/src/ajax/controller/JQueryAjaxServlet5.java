package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet5
 */
@WebServlet("/jQueryAjax5.do")
public class JQueryAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
		
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "박신우", "한국"));
		userList.add(new User(2, "타일러 라쉬", "미국"));
		userList.add(new User(3, "쯔위", "중국"));
		userList.add(new User(4, "모모", "일본"));
		userList.add(new User(5, "리사", "태국"));
		userList.add(new User(6, "알베르토 몬디", "이탈리아"));
		userList.add(new User(7, "샘 해밍턴", "호주"));
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		User user = null;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserNo() == userNo) {
				user = userList.get(i);
				break;
			}
		}
		
		JSONObject userObj = new JSONObject();
		
		if(user != null) {
			userObj.put("userNo", user.getUserNo());
			userObj.put("userName", user.getUserName());
			userObj.put("userNation", user.getUserNation());
			// Map 방식
		}
		
		// contentType을 따로 지정하지 않으면 자동으로 text로 성정되기 때문에 JSON으로 보내도 String으로 보내짐, 따라서 활용 불가능
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(userObj);
		
		out.flush();
		out.close(); // 안 써도 잘 나오지만 비워주고 닫아줘야 오류가 나지 않음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
