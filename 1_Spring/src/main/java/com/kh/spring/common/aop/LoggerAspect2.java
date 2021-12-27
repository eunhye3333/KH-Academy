package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect2 {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAspect2.class); 
	
//	@Pointcut("execution(* com.kh.spring.board..*(..))")
//	public void myPointcut() {} // Pointcut 등록을 위한 함수로 내용은 반드시 비어 있어야 함
	// 아무 기능이 존재하지 않고 해당 Pointcut을 부를 이름을 지정하는 것, 따라서 아무 기능, 매개변수도 넣으면 안 됨
	
	
	
//	@Around("myPointcut()") // 위에서 지정한 포인트컷의 이름을 지정함, 메소드이기 때문에 () 작성
	// 예전에는 위처럼 메소드를 만들어야 했는데 이름 지정을 위해 비어있는 메소드를 만드는 것은 비효율적이기 때문에 @Around에 합칠 수 있음
	@Around("execution(* com.kh.spring.board..*(..))")
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable { 
		
		Signature signature = joinPoint.getSignature(); 
		
		logger.debug("signature : " + signature);
		
		String type = signature.getDeclaringTypeName(); 
		String methodName = signature.getName(); 
		
		logger.debug("type : " + type);
		logger.debug("methodName : " + methodName);
		
		String componentName = null;
		if(type.indexOf("Controller") > -1) {
			componentName = "Controller  \t:  ";
		} else if(type.indexOf("Service") > -1) {
			componentName = "ServiceImpl  \t:  ";
		} else if(type.indexOf("DAO") > -1) {
			componentName = "DAO  \t\t:  ";
		}
		
		logger.debug("[Before] " + componentName + type + "." + methodName + "()");
		
//		Object obj = null;
//		
//		try {
//			obj = joinPoint.proceed(); 
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} 
		
		Object obj = joinPoint.proceed(); 
		
		logger.debug("[After] " + componentName + type + "." + methodName + "()");
		
		return obj;
	}
}
