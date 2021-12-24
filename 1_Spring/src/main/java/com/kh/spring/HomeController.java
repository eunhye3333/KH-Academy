package com.kh.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// HomeController.class : 어떤 클래스에 들어가 있는 logger를 읽어올 것인지 (꼭 현재와 동일한 Controller를 적어야 하는 것은 아님)
	// HomeController 안에 있다고 해서 꼭 HomeController를 넣어야 하는 것은 아니며 MemberDAO, Pagenation 등 다른 클래스 작성 가능 
	// 단, 다른 클래스를 작성하게 되면 해당 logger는 다른 클래스의 log를 읽어들이는 것이기 때문에 32번째 줄은 의미가 없어짐 -> 다른 컨트롤러 안의 로그를 읽어오는 것이기 때문
	// 현재는 내 안에 있는 로그(Line 32)를 읽을 것이기 때문에 HomrController를 쓴 것
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET) // web-xml의 /는 모든 부분을 담당한다는 의미이기 때문에 여기에서만 url을 변경해도 작동됨
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
