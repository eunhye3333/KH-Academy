package board.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmMailServlet
 */
@WebServlet("/confirmMail.me")
public class ConfirmMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 필터를 해줬기 때문에 인코딩을 진행하지 않아도 됨
		String recevier = request.getParameter("email"); // 받는 사람
		String title = "[JSP/Servlet] 유효 메일 확인";
		String content = "본 메일은 현재 고객님의 메일이 <b>유효한지 확인</b>하기 위한 메일입니다."; // html 태그 삽입 가능
		// 네이버 메일 기준
		String host = "smtp.naver.com";
		String sender = "*****@naver.com"; // 실제 보내는 사람의 메일이 유효한 메일이어야 함
		String senderPwd = "******"; // 그 메일의 실제 비밀번호
		
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", host);
		prop.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			// 클래스를 따로 만들기는 힘들기 때문에 익명 클래스를 만들어서 사용함 -> 새로운 곳에서 받지 않고 익명 클래스에서 받아서 처리하는 방식 -> 여기에서 오버라이딩을 함
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, senderPwd); // 보내는 사람에 대한 세션을 만들어주는 작업
			}
		}); // mail에 대한 jar 파일이 필요함(javax.mail)
		// 매개변수가 존재해야 함
		// Authenticator() : Cannot instantiate the type Authenticator -> 객체를 만들 수 없음, 익명 클래스로 만들어야 함
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recevier)); // 진짜 유효한 메일인지 확인
			message.setSubject(title);
			message.setText(content, "UTF-8", "html"); // html을 보낼 수 있기 때문에 html도 추가해줌
			
			Transport.send(message); // 전송
			
			response.getWriter().println("success");
		} catch (AddressException e) {
			e.printStackTrace();
			response.getWriter().println("fail");
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().println("fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
