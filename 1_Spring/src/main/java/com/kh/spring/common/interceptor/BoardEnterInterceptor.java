package com.kh.spring.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

import com.kh.spring.member.model.vo.Member;

public class BoardEnterInterceptor implements AsyncHandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Member loginUser = (Member)(request.getSession().getAttribute("loginUser"));
		
		if(loginUser == null) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 이용하세요.'); location.href='home.do';</script>");
			
			out.flush();
			out.close();
			
		}
		
		return false;
	}
	
}
