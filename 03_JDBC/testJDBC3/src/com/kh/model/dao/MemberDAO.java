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
			
			String[] department = {"국어국문학과", "영어영문학과", "철학과", "문헌정보학과", "심리학과", "경제학과", "경영학과", "물리학과", "화학과", "건축공학과", "기계공학과", "신소재공학과", "산업공학과", "도시공학과", "사회학과", "법학과", "음악학과", "체육학과", "치의학과"};
			
			
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
	    List<String> 성 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
	        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
	        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "변", "노", "도", "소", 
	        "신", "석");
	    List<String> 이름 = Arrays.asList("윤", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "율", "남", "악", "람", "심",
	        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	        "백", "범", "별", "병", "보", "영", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	        "송", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "용", "우", "원", "월", "위", "예",
	        "유", "윤", "율", "은", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준", "중", "지", 
	        "진", "찬", "창", "채", "태", "택", "한", "해", "혁", "현", "형", "롱", "평", "늘", "랑", "얀", "향", "울", "련", "엽", "학", "란",
	        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "비", "헌",
	        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "열", "웅", "분", "변", "양", "번", 
	        "식");
	    Collections.shuffle(성);
	    Collections.shuffle(이름);
	    return 성.get(0) + 이름.get(0) + 이름.get(1);
	  }
	
	public String randomAddress() {
		List<String> si = Arrays.asList("서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "대전광역시", "울산광역시", "세종특별자치시", 
				"경기도", "강원도", "충청북도", "충청남도", "경상북도", "경상남도", "전라북도", "전라남도", "제주특별자치도");
		List<String> gu = Arrays.asList("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", 
				"서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구", "강서구", "금정구", "남구", "동구", "동래구", 
				"부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", 
				"남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "대덕구", "동구", "서구", "유성구", "중구", "광산구", "남구", "동구", "북구");
		List<String> dong = Arrays.asList("청운효자동", "사직동", "삼청동", "부암동", "평창동", "무악동", "교남동", "가회동", "종로1.2.3.4가동", "종로5.6가동", "이화동", "혜화동", "창신제1동", "창신제2동", 
				"창신제3동", "숭인제1동", "숭인제2동", "소공동", "회현동", "명동", "필동", "장충동", "광희동", "을지로동", "신당동", "다산동", "약수동", "청구동", "신당제5동", 
				"이태원제1동", "이태원제2동", "한남동", "서빙고동", "보광동", "왕십리제2동", "왕십리도선동", "마장동", "사근동", "행당제1동", "행당제2동", "응봉동", "금호1가동", 
				"금호2.3가동", "금호4가동", "옥수동", "성수1가제1동", "성수1가제2동", "성수2가제1동", "성수2가제3동", "송정동", "용답동", "화양동", "군자동", "중곡제1동", "중곡제2동", 
				"중곡제3동", "중곡제4동", "능동", "광장동", "자양제1동", "자양제2동", "자양제3동", "자양제4동", "구의제1동", "구의제2동", "구의제3동", "용신동", "제기동", "전농제1동", 
				"전농제2동", "답십리제1동", "답십리제2동", "장안제1동", "장안제2동", "청량리동", "회기동", "휘경제1동", "휘경제2동", "이문제1동", "이문제2동", "면목제2동", "면목제4동", 
				"신내2동", "성북동", "삼선동", "동선동", "돈암제1동", "돈암제2동", "안암동", "보문동", "정릉제1동", "정릉제2동", "정릉제3동", "정릉제4동", "길음제1동", "길음제2동", 
				"쌍문제3동", "쌍문제4동", "방학제1동", "방학제2동", "방학제3동", "월계1동", "월계2동", "월계3동", "공릉1동", "공릉2동", "하계1동", "하계2동", "중계본동", "중계1동", 
				"중계4동", "중계2.3동", "상계1동", "상계2동", "상계3.4동", "상계5동", "상계6.7동", "상계8동", "상계9동", "상계10동", "녹번동", "불광제1동", "불광제2동", 
				"갈현제1동", "갈현제2동", "구산동", "대조동", "응암제1동", "응암제2동", "응암제3동", "역촌동", "신사제1동", "신사제2동", "증산동", "수색동", "진관동", "천연동", 
				"북아현동", "충현동", "신촌동", "연희동", "홍제제1동", "홍제제3동", "홍제제2동", "홍은제1동", "홍은제2동", "남가좌제1동", "남가좌제2동", "북가좌제1동", "북가좌제2동", 
				"아현동", "공덕동", "도화동", "용강동", "대흥동", "염리동", "신수동", "서강동", "서교동", "합정동", "망원제1동", "망원제2동", "연남동", "성산제1동", "성산제2동", 
				"상암동", "목1동", "목2동", "목3동", "목4동", "목5동", "신월1동", "신월2동", "신월3동", "신월4동", "신월5동", "신월6동", "신월7동", "신정1동", "신정2동", 
				"신정3동", "신정4동", "신정6동", "신정7동", "염창동", "등촌제1동", "등촌제2동", "등촌제3동", "화곡제1동", "화곡제2동", "화곡제3동", "화곡제4동", "화곡본동", 
				"구로제2동", "구로제3동", "구로제4동", "구로제5동", "가리봉동", "고척제1동", "고척제2동", "개봉제1동", "개봉제2동", "개봉제3동", "오류제1동", "오류제2동", "수궁동", 
				"항동", "가산동", "독산제1동", "독산제2동", "독산제3동", "독산제4동", "시흥제1동", "시흥제2동", "시흥제3동", "시흥제4동", "시흥제5동", "영등포본동", "영등포동", 
				"여의동", "당산제1동", "당산제2동", "도림동", "문래동", "양평제1동", "양평제2동", "신길제1동", "신길제3동", "신길제4동", "신길제5동", "신길제6동", "신길제7동", 
				"대림제1동", "대림제2동", "대림제3동", "노량진제1동", "노량진제2동", "상도제1동", "상도제2동", "상도제3동", "상도제4동", "흑석동", "사당제1동", "사당제2동", "사당제3동", 
				"사당제4동", "사당제5동", "대방동", "신대방제1동", "신대방제2동", "보라매동", "청림동", "성현동", "행운동", "낙성대동", "청룡동", "은천동", "중앙동", "인헌동", "남현동", "서원동", "신원동", "서림동", "신사동", "신림동", "난향동", "조원동", "대학동", "삼성동", 
				"미성동", "난곡동", "서초1동", "서초2동", "서초3동", "서초4동", "잠원동", "반포본동", "반포1동", "반포2동", "반포3동", "반포4동", "방배본동", "방배1동", "방배2동", "방배3동", "방배4동",
				"양재1동", "양재2동", "내곡동", "신사동", "논현1동", "논현2동", "압구정동", "청담동", "삼성1동", "삼성2동", "대치1동", "대치2동", "대치4동", "역삼1동", "역삼2동", "도곡1동", "도곡2동", "개포1동", "개포2동", "개포4동", "세곡동", "일원본동", "일원1동", "일원2동", "수서동", "풍납1동", "풍납2동", "거여1동", "거여2동", "마천1동", "마천2동", "방이1동", "방이2동", "오륜동", "오금동", "송파1동", "송파2동", "석촌동", "삼전동", "가락본동", "가락1동", "가락2동", "문정1동", "문정2동", "장지동", "위례동", "잠실본동", "잠실2동", "잠실3동", "잠실4동", "잠실6동", "잠실7동", "강일동", "상일제1동", "상일제2동", "명일제1동", "명일제2동", "고덕제1동", "고덕제2동", "암사제1동", "암사제2동", "암사제3동", "천호제1동", "천호제2동", "천호제3동", "성내제1동", "성내제2동", "성내제3동", "길동", "둔촌제1동", "둔촌제2동", "중앙동", "동광동", "대청동", "보수동", "부평동", "광복동", "남포동", "영주제1동", "영주제2동", "동대신제1동", "동대신제2동", "동대신제3동", "서대신제1동", "서대신제3동", "서대신제4동", "부민동", "아미동", "초장동", "충무동", "남부민제1동", "남부민제2동", "암남동", "초량제1동", "초량제2동", "초량제3동", "초량제6동", "수정제1동", "수정제2동", "수정제4동", "수정제5동", "좌천동", "범일제1동", "범일제2동", "범일제5동", "남항동", "영선제1동", "영선제2동", "신선동", "봉래제1동", "봉래제2동", "청학제1동", "청학제2동", "동삼제1동", "동삼제2동", "동삼제3동", "부전제1동", "부전제2동", "연지동", "초읍동", "양정제1동", "양정제2동", 
				"언양읍", "온양읍", "범서읍", "청량읍", "삼남읍", "서생면", "삼동면", "웅촌면", "두동면", "두서면", "상북면");
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
