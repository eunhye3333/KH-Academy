package com.kh.spring.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring.member.model.vo.Member;

public class BoardEnterInterceptor implements HandlerInterceptor {
	
	// 컨트롤러에 접근 전 로그인이 안 되어 있으면 막아야 하기 때문에 전처리가 필요
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Member loginUser = (Member)(request.getSession().getAttribute("loginUser"));
		
		if(loginUser == null) {
//			response.setContentType("text/html; charset=UTF-8");
//
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('로그인 후 이용하세요.'); location.href='home.do';</script>");
//			
//			out.flush();
//			out.close();
			
			request.setAttribute("msg", "로그인 후 이용하세요");
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response); // JSP Servlet 방식을 사용해도 됨
			
			return false;
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler); // 항상 true만 반환하는데, true인 경우에는 컨트롤러에 넘어가게 됨
		// 하지만 위 if문의 상황인 경우에는 컨트롤러로 넘어가서는 안 되는 상황이기 때문에 return false를 해줘야 함
	}
	
}
