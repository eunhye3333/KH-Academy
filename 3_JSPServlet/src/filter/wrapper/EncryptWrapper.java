package filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{
	// 비밀번호를 받아서 암호화하는 것이기 때문에 요청에서부터 암호화가 되어야 함
	// HttpServletRequestWrapper를 상속받음
	// 해당 클래스를 상속받으면 아래 기본 생성자가 필수로 존재해야 함

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// HttpServletRequest를 상속받는 것이나 마찬가지
	}
	
	@Override
	public String getParameter(String name) {
		// 비밀번호만 암호화해야 하기 때문에 조건을 걸어야 함
		String value = null;
		if(name != null && (name.equals("joinUserPwd") || name.equals("newPwd") || name.equals("userPwd"))) {
			// name이 비밀번호가 맞으면 암호화를 하고 아니면 원래대로 함
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				// 암호화 객체 : SHA-512라는 암호화 방식(로직)을 사용하겠다
				byte[] bytes = super.getParameter(name).getBytes(Charset.forName("UTF-8"));
				// 받아온 값을 UTF-8 방식으로 byte 단위로 쪼개겠다
				md.update(bytes); // void라서 암호화된 결과물을 반환하지는 않음
				value = Base64.getEncoder().encodeToString(md.digest()); // byte[]을 가지고 와서 String으로 다시 바꿔줌
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {
			// 비밀번호가 아닌 경우
			value = super.getParameter(name);
		}
		
		return value;
	}

}
