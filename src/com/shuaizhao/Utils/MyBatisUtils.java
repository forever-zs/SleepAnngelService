package com.shuaizhao.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	public static ArrayList<SqlSession> sqlSessionList=new ArrayList<SqlSession>();
	public static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "SqlMapConfig.xml";
		InputStream configStream;
		try {
			configStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(configStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() throws IOException {
		SqlSession sqlSession;
		sqlSession = sqlSessionFactory.openSession();
		sqlSessionList.add(sqlSession);
		return sqlSession;
	}
}
