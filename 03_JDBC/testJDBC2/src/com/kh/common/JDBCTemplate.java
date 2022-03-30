package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	private static Connection conn = null;
	
	private JDBCTemplate() {} // 생성자를 private으로 만들어서 외부에서 객체 생성을 할 수 없도록 함
	// 기본 생성자를 private로 하여 객체를 생성할 수 없게 하고, 모든 필드와 메소드를 public static으로 선언 하는 것 : 싱글톤패턴
	// 많이 사용되는 클래스를 자주 객체를 만들면 메모리에 무리가 감. 따라서 자주 사용하는 객체는 객체를 생성하지 않고도 사용하기 위한 목적으로 고안됨.(static 영역에 딱 한 번만 생성되도록)
	// JDBCTemplate은 완벽한 싱글톤 패턴은 아님 -> 완벽한 싱글톤 패턴은 모든 멤버가 public static이어야 하는데 private static 사용
	
	// 1, 2번
	public static Connection getConnection() { // => DriverManager.getConnection()를 우리 입장에 맞춰 사용자 정의 메소드로 만듦

		if(conn == null) {
			try {
				Properties prop = new Properties();
				prop.load(new FileReader("driver.properties")); // properties 파일에 있는 데이터를 읽어와서 Properties 객체에 저장하는 메소드
				// 파일을 읽어와야 하기 때문에 매개변수에 스트림이 들어감
				
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MEMBER", "MEMBER");
				// 이렇게 값을 넣는 것이 아니라 파일에 있는 값을 가지고 와서 사용할 수 있음 => 유지보수가 용이
				// 파일을 이용하여 값을 가지고 오는 것 : 프로퍼티지 => 키와 값이 String 타입으로만 제한된 Map 컬렉션
				
				// 프로퍼티 이용
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"),
												   prop.getProperty("user"),
												   prop.getProperty("password"));
				
				conn.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return conn;
	}
	
	
	// 4번
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { // 객체가 있으면서 닫히지 않았을 때
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5번
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		// 매개변수의 타입이 달라서 오버로딩이 적용됨
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
// PreparedStatement는 close 메소드를 생성하지 않음 
//	-> PreparedStatement가 Statement를 상속받고 있기 때문에 위 메소드에서 같이 처리 가능
//  -> Statement로 PreparedStatement를 같이 받을 수 있음 (다형성이 적용됨 : 부모를 넣으면 자식까지 같이 가지고 옴)
//	-> 아래 stmt.close()에서는 PreparedStatement를 가지고 온다고 했을 때 동적 바인딩이 적용됨

}
