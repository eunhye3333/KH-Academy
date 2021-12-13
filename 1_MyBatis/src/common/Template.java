package common;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		// MyBatis 라이브러리를 추가하지 않으면 import 되지 않음
		
		try {
			
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			SqlSessionFactory ssf = ssfb.build(stream);
			session = ssf.openSession(false); // false : 자동 커밋을 하지 않겠다는 뜻
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
	// MyBatis에서는 commit, rollback, close를 제공하기 때문에 Template에서 따로 만들지 않아도 됨
}
