package com.kh.spring.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.member.model.exception.MemberException;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@SessionAttributes("loginUser")
@Controller // 객체 생성, Controller의 성질을 가질 수 있도록 설정
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class); // logger 생성
	
//	private MemberServiceImpl mService = new MemberServiceImpl();
	@Autowired // 의존성 주입
	private MemberService mService;
	// 인터페이스를 불러옴
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
//	@RequestMapping(value = "login.me", method = RequestMethod.POST) // method : 어떤 방식으로 보냈는지
//	public void login() {
//		System.out.println("로그인 처리합니다.");
//	}
	
	/********** 파라미터 전송받기 **********/
	// 1. HttpServletRequest를 통해 전송받기(JSP/Servlet 방식)
//	@RequestMapping(value = "login.me", method = RequestMethod.POST) 
//	public void login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("id1 : " + id);
//		System.out.println("pwd1 : " + pwd);
//	}
	
	// 2. @RequestParam 방식
//	@RequestMapping(value = "login.me", method = RequestMethod.POST) 
//	public void login(@RequestParam("id") String userId, @RequestParam("pwd") String userPwd) {
//	public void login(@RequestParam(value="id", defaultValue="hello") String userId, 
//					  @RequestParam(value="pwd", defaultValue="world") String userPwd,
//					  @RequestParam(value="test", required=false, defaultValue="spring") String test) {
//		// "id"라는 이름의 파라미터를 받아와 userId에 저장하겠다
//		// @RequestParam에는 속성이 들어갈 수 있음, 들어가는 값이 하나일 경우에는 속성 생략 가능
//		// 		속성의 종류
//		//		 	value : view에서 받아오는 파라미터의 이름, 하나일 경우 해당 속성명 생략 가능
//		//			defaultValue : 값이 들어오지 않았거나 값이 null일 때 기본적으로 들어가 있어야 하는 데이터를 지정하는 경우에 사용
//		//			required : 지정한 파라미터가 필수적으로 받아와야 하는 파라미터인지 설정하는 경우에 사용, 기본값 : true, true인 경우 필수적으로 들어가야 하는 파라미터로 인식
//		System.out.println("id2 : " + userId);
//		System.out.println("pwd2 : " + userPwd);
//		System.out.println("test : " + test);
//	}
	
	// 3. @RequestParam 생략
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public void login(String id, String pwd) {
//		// 받아와야 할 파라미터명과 변수 이름을 동일하게 하는 경우 자동으로 받아올 수 있음 -> annotation 생략 가능
//		// 생략하는 경우 속성 설정 불가능
//		System.out.println("id3 : " + id);
//		System.out.println("pwd3 : " + pwd);
//	}
	
	// 4. @ModelAttribute 방식 : 받아오는 파라미터가 많은 경우에 사용하면 효과적
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public void login(@ModelAttribute Member m) {
//		// 파라미터를 받아와 Member 객체에 저장하겠다는 의미
//		// 기본생성자와 setter를 이용하여 주입하는 것이기 때문에 객체에 둘 중 하나라도 없으면 자동 주입이 되지 않음, setter의 이름도 파라미터 이름과 동일해야 함
//		System.out.println("id4 : " + m.getId());
//		System.out.println("pwd4 : " + m.getPwd());
//	}

	// 5. @ModelAttribute 생략
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public void login(Member m, HttpSession session) {
////		System.out.println("id5 : " + m.getId());
////		System.out.println("pwd5 : " + m.getPwd());
//		
//		// 이전 사용했던 new MemberService() 객체를 만드는 방식은 개발자가 주도권을 가지며 결합도가 높아짐
//		// 결합도가 높다는 것을 확인할 수 있는 두 가지는 1. 클래스명 변경에 직접적인 영향을 받음, 2. 매 요청마다 새로운 service 객체가 생성됨 (주소값이 계속 달라짐)
//		
////		MemberServiceImpl mService = new MemberServiceImpl();
////		System.out.println(mService);
//		// 클래스명을 변경하는 경우 같이 변경되고, 새로고침 시마다 주소값이 변경됨 => 결합도가 높음
//		
//		// 결합도 낮추기
//		// 1. 필드에 위치시켜 새로운 객체를 생성하지 않도록 하기 => 주소값 동일
//		// 		-> 하지만 여전히 이름은 영향을 받음
//		// 2. 중간에 interface 추가
//		//		-> 이름을 변경할 경우 영향을 받지 않게 됨, 하지만 MemberService 객체 생성 불가능 -> 객체를 생성하기 위한 annotation 사용
//		// 		   MemberServiceImpl에 @Service 설정
//		
//		Member loginMember = mService.memberLogin(m); // 메소드를 호출하는 경우 인터페이스에 먼저 메소드가 생성되고, 해당 추상 메소드를 오버라이드해야 함
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);
//		} else {
//			
//		}
		
//	}
	
	/********** 전달하고자 하는 데이터가 있을 경우에 대한 방법 **********/
	// 1. Model 객체 사용
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public String login(Member m, HttpSession session, Model model) {
//		Member loginMember = mService.memberLogin(m); 
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember); // request가 아니라 session에 담을 것이기 때문에 model을 사용할 필요가 없음
//			
////			return "../home"; // 현재 폴더는 member이기 때문에 나가 줘야 함
//			return "redirect:home.do"; // url 변경, sendRedirect와 같은 역할
//		} else {
//			model.addAttribute("msg", "로그인에 실패하였습니다.");
//			
//			return "../common/errorPage";
//		}
//	}
	
	// 2. ModelAndView 객체 사용
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public ModelAndView login(Member m, HttpSession session, ModelAndView mv) {
//		Member loginMember = mService.memberLogin(m); 
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember); 
//			mv.setViewName("redirect:home.do"); // session에 객체를 담았기 때문에 데이터를 담지 않고 뷰만 설정하면 됨
//		} else {
//			mv.addObject("msg", "로그인에 실패하였습니다.");
//			mv.setViewName("../common/errorPage");
//		}
//		
//		return mv;
//	}
	
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		
//		return "redirect:home.do";
//	}
	
	// 3. session에 저장할 때 @SessionAttributes 사용 -> @Controller 위에 등록
	// model 객체에 attribute가 추가될 때, 자동으로 키 값을 찾아 세션에 등록하는 기능을 가지고 있음
//	@RequestMapping(value = "login.me", method = RequestMethod.POST)
//	public String login(Member m, Model model) {
//		Member loginMember = mService.memberLogin(m); 
//		
//		if(loginMember != null) {
//			model.addAttribute("loginUser", loginMember); 
//			
//			return "redirect:home.do";
//		} else {
//			throw new MemberException("로그인에 실패하였습니다");
//		}
//		
//	}
	
	// @SessionAttributes을 사용하는 경우 invalidate()를 사용할 수 없음
	@RequestMapping("logout.me")
	public String logout(SessionStatus session) {
		session.setComplete();
		
		return "redirect:home.do";
	}
	
	@RequestMapping("enrollView.me")
	public String enrollView() {
		logger.debug("회원 등록 페이지");
		return "memberJoin";
	}
	
	@RequestMapping("minsert.me")
	public String insertMember(@ModelAttribute Member m, @RequestParam(value="post", required=false) String post, 
														 @RequestParam(value="address1", required=false) String address1, 
														 @RequestParam(value="address2", required=false) String address2) {
		
		m.setAddress(post + "/" + address1 + "/" + address2);
		
		// bcrypt 암호화 방식 : 스프링 시큐리티 모듈에서 제공
		// 		암호화 + 랜덤한 salt 값을 만듦 -> 요청할 때마다 랜덤한 salt 값이 발생하기 때문에 문자열이 같아도 결과는 다르게 나옴
//		bcrypt.encode(rawPassword):String -> rawPassword : 평문화가 되어 있는 패스워드
		String encPwd = bcrypt.encode(m.getPwd());
		m.setPwd(encPwd);
		
		int result = mService.insertMember(m);
		
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException("회원가입에 실패하였습니다");
		}
	}
	
	@RequestMapping(value = "login.me", method = RequestMethod.POST)
	public String login(Member m, Model model) {
		
//		Member loginMember = null;
//		
//		String encPwd = mService.pwdCheck(m);
//		
//		if(bcrypt.matches(m.getPwd(), encPwd)) {
//			loginMember = mService.memberLogin(m); 
//		}
		
		Member loginMember = mService.memberLogin(m);
		
		if(loginMember != null && bcrypt.matches(m.getPwd(), loginMember.getPwd())) { // 비밀번호 평문과 암호화된 비밀번호가 같은지 확인해주는 메소드
			model.addAttribute("loginUser", loginMember); 
			logger.info(loginMember.getId());
			return "redirect:home.do";
		} else {
			throw new MemberException("로그인에 실패하였습니다");
		}
		
	}
	
	@RequestMapping("myinfo.me")
	public String myinfoView() {
		return "mypage";
	}
	
	@RequestMapping("mupdateView.me")
	public String memberUpdateForm() {
		return "memberUpdateForm";
	}
	
	@RequestMapping("mupdate.me")
	public String updateMember(@ModelAttribute Member m, @RequestParam("post") String post, 
														 @RequestParam("address1") String address1, 
														 @RequestParam("address2") String address2, Model model) {
		
		m.setAddress(post + "/" + address1 + "/" + address2);
		int result = mService.updateMember(m);
		
		if(result > 0) {
			model.addAttribute("loginUser", m); // @SessionAttributes를 사용했기 때문에 Model 사용
			return "redirect:myinfo.me";
		} else {
			throw new MemberException("회원 정보 수정에 실패하였습니다");
		}
	}
	
	@RequestMapping("mpwdUpdateView.me")
	public String pwdUpdateForm() {
		return "memberPwdUpdateForm";
	}
	
	@RequestMapping("mPwdUpdate.me")
	public String updatePwd(@RequestParam("pwd") String pwd, @RequestParam("newPwd1") String newPwd, 
							@RequestParam("newPwd2") String newPwd2, Model model) {
		
		Member m = (Member)model.getAttribute("loginUser"); // update를 하고 바로 비밀번호를 수정하려고 하면 비밀번호가 없기 때문에 오류가 남
//		if(newPwd.equals(newPwd2)) {
//			String encPwd = m.getPwd();
//			if(bcrypt.matches(pwd, encPwd)) {
//				m.setPwd(bcrypt.encode(newPwd));
//				int result = mService.updatePwd(m);
//				
//				if(result > 0) {
//					model.addAttribute("loginUser", m);
//					return "redirect:myinfo.me";
//				}
//			}
//		}
//		throw new MemberException("비밀번호 수정에 실패하였습니다");
		
		Member dbMember = mService.memberLogin(m); // 오류가 나지 않도록 Member을 다시 select 해옴
		
		int result = 0;
		
		if(bcrypt.matches(pwd, dbMember.getPwd())) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", m.getId());
			map.put("newPwd", bcrypt.encode(newPwd));
			
			result = mService.updatePwd(map);
		}
		
		if(result <= 0) {
			throw new MemberException("비밀번호 수정에 실패하였습니다");
		}
		
		return "redirect:home.do";
	}

	@RequestMapping("mdelete.me")
	public String deleteMember(@RequestParam("id") String id, SessionStatus session) {
		int result = mService.deleteMember(id);
		
		if(result > 0) {
			session.setComplete();
			return "redirect:home.do";
		} else {
			throw new MemberException("회원 삭제에 실패하였습니다.");
		}
	}
	
	@RequestMapping("dupId.me")
	public void duplicateId(@RequestParam("id") String id, HttpServletResponse response) {
		String result = mService.duplicateId(id) == 0 ? "NoDup" : "Dup";
		
		try {
			response.getWriter().println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
