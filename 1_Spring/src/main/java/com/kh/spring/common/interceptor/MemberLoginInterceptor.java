package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;

public class MemberLoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(MemberLoginInterceptor.class);

	// 로그인 이후에 이루어져야 하기 때문에 후처리 / 뷰단 처리 후에 사용
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		Logger logger = LoggerFactory.getLogger(MemberLoginInterceptor.class);
//		
//		Member loginUser = (Member)(request.getSession().getAttribute("loginUser"));
//		
//		logger.info(loginUser.getId());
//	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		Logger logger = LoggerFactory.getLogger(MemberLoginInterceptor.class);
		
		Member loginUser = (Member)(request.getSession().getAttribute("loginUser"));
		
		if(loginUser != null) {
			logger.info(loginUser.getId());
		}
		
	}
}
