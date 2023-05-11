package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
//		prop = new Properties();
//		try {
//			prop.load(new FileReader("query.properties"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public int insertMember(Connection conn) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int result = 0;
		
//		String query = prop.getProperty("insertMember");
		String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, NULL, NULL, NULL, DEFAULT, DEFAULT)";
//		String query2 = prop.getProperty("insertTemp");
		String query2 = "INSERT INTO TEMP VALUES(?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt2 = conn.prepareStatement(query2);
			
			String[] department = {"������а�", "������а�", "ö�а�", "���������а�", "�ɸ��а�", "�����а�", "�濵�а�", "�����а�", "ȭ�а�", "������а�", "�����а�", "�ż�����а�", "������а�", "���ð��а�", "��ȸ�а�", "���а�", "�����а�", "ü���а�", "ġ���а�"};
			
			
			for(int i = 0; i < department.length; i++) {
				for(int j = 0; j < 10; j++) {
					int num = (int)(Math.random() * (99999 - 10000 + 1) + 1);
					String studentNo = entYear() + num;
					
					String pw = year() + month() + day();
					String newPw = null;
					
					MessageDigest md;
					try {
						md = MessageDigest.getInstance("SHA-512");
						byte[] bytes = pw.getBytes(Charset.forName("UTF-8"));
						md.update(bytes);
						newPw = Base64.getEncoder().encodeToString(md.digest());
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					
					pstmt.setString(1, studentNo);
					pstmt.setString(2, newPw);
					pstmt.setString(3, randomHangulName());
					pstmt.setString(4, department[i]); 
					result += pstmt.executeUpdate();
					
					pstmt2.setString(1, studentNo);
					pstmt2.setString(2, pw);
					result += pstmt2.executeUpdate();
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public String year() {
		String year = Integer.toString((int)(Math.random() * (2002 - 1996 + 1) + 1996));
		return year;
	}
	
	public String entYear() {
		String year = Integer.toString((int)(Math.random() * (2021 - 2014 + 1) + 2014));
		return year;
	}
	
	public String month() {
		int m = (int)(Math.random() * (12 - 1 + 1) + 1);
		String month = "";
		if(m < 10) {
			month = "0";
		}
		
		month += Integer.toString(m);
		
		return month;
	}
	
	public String day() {
		int d = (int)(Math.random() * (31 - 1 + 1) + 1);
		
		
		String day = "";
		
		
		if(d < 10) {
			day = "0";
		}
		
		day += Integer.toString(d);
		
		return day;
	}
	
	public String randomHangulName() {
	    List<String> �� = Arrays.asList("��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ȳ", "��",
	        "��", "��", "��", "ȫ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ä", "��", "õ", "��", "��", "��", "��", "��", "��", "��", "��", 
	        "��", "��");
	    List<String> �̸� = Arrays.asList("��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", 
	        "��", "��", "â", "ä", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
	        "��", "ȣ", "ȫ", "ȭ", "ȯ", "ȸ", "ȿ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ȥ", "Ȳ", "��", "��", "��", "��",
	        "��", "��", "��", "Ź", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", 
	        "��");
	    Collections.shuffle(��);
	    Collections.shuffle(�̸�);
	    return ��.get(0) + �̸�.get(0) + �̸�.get(1);
	  }
	
	public String randomAddress() {
		List<String> si = Arrays.asList("����Ư����", "�λ걤����", "�뱸������", "��õ������", "���ֱ�����", "����������", "��걤����", "����Ư����ġ��", 
				"��⵵", "������", "��û�ϵ�", "��û����", "���ϵ�", "��󳲵�", "����ϵ�", "���󳲵�", "����Ư����ġ��");
		List<String> gu = Arrays.asList("������", "������", "���ϱ�", "������", "���Ǳ�", "������", "���α�", "��õ��", "�����", "������", "���빮��", "���۱�", "������", 
				"���빮��", "���ʱ�", "������", "���ϱ�", "���ı�", "��õ��", "��������", "��걸", "����", "���α�", "�߱�", "�߶���", "������", "������", "����", "����", "������", 
				"�λ�����", "�ϱ�", "���", "���ϱ�", "����", "������", "������", "������", "�߱�", "�ؿ�뱸", "�߱�", "����", "����Ȧ��", "������", "������", "����", "��籸", "����", 
				"����", "�޼���", "����", "�ϱ�", "����", "������", "�߱�", "�����", "����", "����", "������", "�߱�", "���걸", "����", "����", "�ϱ�");
		List<String> dong = Arrays.asList("û��ȿ�ڵ�", "������", "��û��", "�ξϵ�", "��â��", "���ǵ�", "������", "��ȸ��", "����1.2.3.4����", "����5.6����", "��ȭ��", "��ȭ��", "â����1��", "â����2��", 
				"â����3��", "������1��", "������2��", "�Ұ���", "ȸ����", "��", "�ʵ�", "���浿", "����", "�����ε�", "�Ŵ絿", "�ٻ굿", "�����", "û����", "�Ŵ���5��", 
				"���¿���1��", "���¿���2��", "�ѳ���", "������", "������", "�սʸ���2��", "�սʸ�������", "���嵿", "��ٵ�", "�����1��", "�����2��", "������", "��ȣ1����", 
				"��ȣ2.3����", "��ȣ4����", "������", "����1����1��", "����1����2��", "����2����1��", "����2����3��", "������", "��䵿", "ȭ�絿", "���ڵ�", "�߰���1��", "�߰���2��", 
				"�߰���3��", "�߰���4��", "�ɵ�", "���嵿", "�ھ���1��", "�ھ���2��", "�ھ���3��", "�ھ���4��", "������1��", "������2��", "������3��", "��ŵ�", "���⵿", "������1��", 
				"������2��", "��ʸ���1��", "��ʸ���2��", "�����1��", "�����2��", "û������", "ȸ�⵿", "�ְ���1��", "�ְ���2��", "�̹���1��", "�̹���2��", "�����2��", "�����4��", 
				"�ų�2��", "���ϵ�", "�Ｑ��", "������", "������1��", "������2��", "�Ⱦϵ�", "������", "������1��", "������2��", "������3��", "������4��", "������1��", "������2��", 
				"�ֹ���3��", "�ֹ���4��", "������1��", "������2��", "������3��", "����1��", "����2��", "����3��", "����1��", "����2��", "�ϰ�1��", "�ϰ�2��", "�߰躻��", "�߰�1��", 
				"�߰�4��", "�߰�2.3��", "���1��", "���2��", "���3.4��", "���5��", "���6.7��", "���8��", "���9��", "���10��", "�����", "�ұ���1��", "�ұ���2��", 
				"������1��", "������2��", "���굿", "������", "������1��", "������2��", "������3��", "���̵�", "�Ż���1��", "�Ż���2��", "���굿", "������", "������", "õ����", 
				"�Ͼ�����", "������", "���̵�", "����", "ȫ����1��", "ȫ����3��", "ȫ����2��", "ȫ����1��", "ȫ����2��", "��������1��", "��������2��", "�ϰ�����1��", "�ϰ�����2��", 
				"������", "������", "��ȭ��", "�밭��", "���ﵿ", "������", "�ż���", "������", "������", "������", "������1��", "������2��", "������", "������1��", "������2��", 
				"��ϵ�", "��1��", "��2��", "��3��", "��4��", "��5��", "�ſ�1��", "�ſ�2��", "�ſ�3��", "�ſ�4��", "�ſ�5��", "�ſ�6��", "�ſ�7��", "����1��", "����2��", 
				"����3��", "����4��", "����6��", "����7��", "��â��", "������1��", "������2��", "������3��", "ȭ����1��", "ȭ����2��", "ȭ����3��", "ȭ����4��", "ȭ���", 
				"������2��", "������3��", "������4��", "������5��", "��������", "��ô��1��", "��ô��2��", "������1��", "������2��", "������3��", "������1��", "������2��", "���õ�", 
				"�׵�", "���굿", "������1��", "������2��", "������3��", "������4��", "������1��", "������2��", "������3��", "������4��", "������5��", "����������", "��������", 
				"���ǵ�", "�����1��", "�����2��", "������", "������", "������1��", "������2��", "�ű���1��", "�ű���3��", "�ű���4��", "�ű���5��", "�ű���6��", "�ű���7��", 
				"�븲��1��", "�븲��2��", "�븲��3��", "�뷮����1��", "�뷮����2��", "����1��", "����2��", "����3��", "����4��", "�漮��", "�����1��", "�����2��", "�����3��", 
				"�����4��", "�����5��", "��浿", "�Ŵ����1��", "�Ŵ����2��", "����ŵ�", "û����", "������", "��", "�����뵿", "û�浿", "��õ��", "�߾ӵ�", "���嵿", "������", "������", "�ſ���", "������", "�Ż絿", "�Ÿ���", "���⵿", "������", "���е�", "�Ｚ��", 
				"�̼���", "���", "����1��", "����2��", "����3��", "����4��", "�����", "��������", "����1��", "����2��", "����3��", "����4��", "��躻��", "���1��", "���2��", "���3��", "���4��",
				"����1��", "����2��", "���", "�Ż絿", "����1��", "����2��", "�б�����", "û�㵿", "�Ｚ1��", "�Ｚ2��", "��ġ1��", "��ġ2��", "��ġ4��", "����1��", "����2��", "����1��", "����2��", "����1��", "����2��", "����4��", "���", "�Ͽ�����", "�Ͽ�1��", "�Ͽ�2��", "������", "ǳ��1��", "ǳ��2��", "�ſ�1��", "�ſ�2��", "��õ1��", "��õ2��", "����1��", "����2��", "������", "���ݵ�", "����1��", "����2��", "���̵�", "������", "��������", "����1��", "����2��", "����1��", "����2��", "������", "���ʵ�", "��Ǻ���", "���2��", "���3��", "���4��", "���6��", "���7��", "���ϵ�", "������1��", "������2��", "������1��", "������2��", "�����1��", "�����2��", "�ϻ���1��", "�ϻ���2��", "�ϻ���3��", "õȣ��1��", "õȣ��2��", "õȣ��3��", "������1��", "������2��", "������3��", "�浿", "������1��", "������2��", "�߾ӵ�", "������", "��û��", "������", "����", "������", "������", "������1��", "������2��", "�������1��", "�������2��", "�������3��", "�������1��", "�������3��", "�������4��", "�ιε�", "�ƹ̵�", "���嵿", "�湫��", "���ι���1��", "���ι���2��", "�ϳ���", "�ʷ���1��", "�ʷ���2��", "�ʷ���3��", "�ʷ���6��", "������1��", "������2��", "������4��", "������5��", "��õ��", "������1��", "������2��", "������5��", "���׵�", "������1��", "������2��", "�ż���", "������1��", "������2��", "û����1��", "û����2��", "������1��", "������2��", "������3��", "������1��", "������2��", "������", "������", "������1��", "������2��", 
				"�����", "�¾���", "������", "û����", "�ﳲ��", "������", "�ﵿ��", "���̸�", "�ε���", "�μ���", "��ϸ�");
		Collections.shuffle(si);
		Collections.shuffle(gu);
		Collections.shuffle(dong);
		return si.get(0) + gu.get(0) + "&&" + dong.get(1);
	}
	
	public String randomEmail(int wordLength) {

		Random r = new Random();
		StringBuilder sb = new StringBuilder(wordLength);

		for(int i = 0; i < wordLength; i++) {
			char tmp = (char) ('a' + r.nextInt('z' - 'a'));
			sb.append(tmp);
		}
		
		List<String> mail = Arrays.asList("naver.com", "google.com", "daum.com", "nate.com", "hanmail.net");
		Collections.shuffle(mail);
		
		String v = sb.toString() + Integer.toString((int)(Math.random() * (999 - 1 + 1) + 1)) + "@" + mail.get(0);

		return v;
	}



	public int updateMember(Connection conn, ArrayList<String> mem) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET PHONE = ?, ADDRESS = ?, EMAIL = ?, STATUS = 'Y' WHERE MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			
			for(int i = 0; i < mem.size(); i++) {
				String phone = "010" + Integer.toString((int)(Math.random() * (99999999 - 10000000 + 1) + 10000000));
				String addr = randomAddress() ;
				String email = randomEmail((int)(Math.random() * (8 - 5) + 5));
				
				pstmt.setString(1, phone);
				pstmt.setString(2, addr);
				pstmt.setString(3, email);
				pstmt.setString(4, mem.get(i));
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<String> selectMember(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<String> result = null;
		
		String query = "SELECT MEMBER_ID FROM MEMBER WHERE STATUS = 'N'";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			result = new ArrayList<>();
			while(rset.next()){
				result.add(rset.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	


}
