package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect1 {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAspect1.class); // 공통적으로 삽입할 logger
	
	// before
//	public void loggerAdvice(JoinPoint joinPoint) { // Advice는 JoinPoint 타입의 파라미터를 첫 번째 매개변수로 선언하여야 함
//		
//		Signature signature = joinPoint.getSignature(); // 내가 접근할 메소드에 대한 정보를 가지고 옴 (반환값, 매개변수, 메소드 등 다 가지고 올 수 있음)
//		
//		logger.debug("signature : " + signature);
//		
//		String type = signature.getDeclaringTypeName(); // 해당 메소드가 있는 클래스에 대한 이름
//		String methodName = signature.getName(); // 해당 메소드의 이름 자체
//		
//		logger.debug("type : " + type);
//		logger.debug("methodName : " + methodName);
//		
//		String componentName = null;
//		if(type.indexOf("Controller") > -1) { // type 안에 Controller가 있으면
//			componentName = "Controller  \t:  ";
//		} else if(type.indexOf("Service") > -1) {
//			componentName = "ServiceImpl  \t:  ";
//		} else if(type.indexOf("DAO") > -1) {
//			componentName = "DAO  \t\t:  ";
//		}
//		
//		logger.debug("[Before] " + componentName + type + "." + methodName + "()");
//	}
	
	// around
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) { // Advice는 JoinPoint 타입의 파라미터를 첫 번째 매개변수로 선언하여야 함
		
		Signature signature = joinPoint.getSignature(); // 내가 접근할 메소드에 대한 정보를 가지고 옴 (반환값, 매개변수, 메소드 등 다 가지고 올 수 있음)
		
		logger.debug("signature : " + signature);
		
		String type = signature.getDeclaringTypeName(); // 해당 메소드가 있는 클래스에 대한 이름
		String methodName = signature.getName(); // 해당 메소드의 이름 자체
		
		logger.debug("type : " + type);
		logger.debug("methodName : " + methodName);
		
		String componentName = null;
		if(type.indexOf("Controller") > -1) { // type 안에 Controller가 있으면
			componentName = "Controller  \t:  ";
		} else if(type.indexOf("Service") > -1) {
			componentName = "ServiceImpl  \t:  ";
		} else if(type.indexOf("DAO") > -1) {
			componentName = "DAO  \t\t:  ";
		}
		
		logger.debug("[Before] " + componentName + type + "." + methodName + "()");
		
		Object obj = null;
		
		try {
			obj = joinPoint.proceed(); // 내가 다음 어드바이스가 있다거나 다음 타겟으로 넘어갈 수 있도록(계속 나아가도록) 설정해주는 것
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		logger.debug("[After] " + componentName + type + "." + methodName + "()");
		
		return obj;
	}
}
