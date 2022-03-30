package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//public class TestInterceptor extends HandlerInterceptorAdapter {
//public class TestInterceptor implements HandlerInterceptor {
public class TestInterceptor implements AsyncHandlerInterceptor {
	// Interceptor로 인지할 수 있도록 HandlerInterceptorAdapter를 받아와야 함
	//							-> deprecated : Spring 5.3버전부터 deprecated 됨
	//								HandlerInterceptor 또는 AsyncHandlerInterceptor 사용 : 메소드 내 내용이 조금씩 다름
	
	private Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 전처리
		// DispatcherServlet이 Controller를 호출하기 전(Controller로 요청이 들어가기 전)에 수행
		
		if(logger.isDebugEnabled()) { // 지금 들어온 것이 디버깅 레벨일 경우에만 -> 사용하지 않아도 되지만 해주면 아래 부분에서 로깅이 필요가 없음
			logger.debug("============= START =============");
			logger.debug(request.getRequestURI());
		}
		
		return AsyncHandlerInterceptor.super.preHandle(request, response, handler); // 항상 true 반환
	}
	
	// 반환값이 void라서 내용은 지워줘도 됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 후처리
		// Controller에서 DispatcherSerlvet으로 리턴되는 순간에 수행
		// ModelAndView를 이용해 작업 결과 등을 참조 가능
		
		if(logger.isDebugEnabled()) { 
			logger.debug("-------------- view --------------");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// 뷰단 처리 후
		// 뷰에서 모든 작업 (최종 결과를 생성하는 일 포함)이 완료된 후 수행
		
		if(logger.isDebugEnabled()) { 
			logger.debug("============= END =============");
		}
	}
	
	// 무조건 세 가지를 다 쓸 필요는 없고 인터셉터를 넣고자 하는 부분이 필요한 부분을 캐치해서 사용하면 됨(필요한 것만 골라서 사용 가능)
}
