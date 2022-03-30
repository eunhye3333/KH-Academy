package com.kh.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
	
	private Logger logger = LoggerFactory.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		new Log4jTest().test();
	}
	
	public void test() {
//		logger.fatal("fatal 로그"); // logger를 생성할 경우 해당 레벨로 설정할 수 없는 영역임 : 지원하지 않음(심각한 오류이기 때문)
		logger.error("error 로그");
		logger.warn("warn 로그");
		logger.info("info 로그");
		logger.debug("debug 로그");
		logger.trace("trace 로그");
		// log4j에서 해당 패키지를 포함하는 logger의 level이 info로 설정되어 있기 때문에 error, warn, info만 출력됨
		// logger의 경우 해당 패키지 안에 속해있다고 하더라도 더 가까운 logger에 맞춰서 진행됨
		// logger에 appender-ref를 설정하는 경우 결과가 두 개씩 출력됨 : 내가 가진 appender-ref를 이용해 console에 한 번 출력되고, root logger에 가야 하는데 해당 부분에 appender-ref가 또 있어서 거기에서 한 번 더 출력됨
	}
}
