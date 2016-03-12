package com.shuaizhao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.google.gson.Gson;
import com.shuai.mapper.Phone_UUIDMapper;
import com.shuai.mapper.UserMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Community;
import com.shuaizhao.domain.Music;
import com.shuaizhao.domain.MusicList;
import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.domain.User;
import com.shuaizhao.domain.UserDetailInfo;
import com.shuaizhao.service.CommunityService;
import com.shuaizhao.service.MusicService;
import com.shuaizhao.service.UserService;

public class JunitTest {
	@Test
	public void testDao() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream configStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configStream);
		SqlSession sqlsession=sqlSessionFactory.openSession();
		User user=new User("123", "赵帅","18862106331","forever");
		//sqlsession.insert("com.shuaizhao.domain.User.insertUser", user);
		//int i=sqlsession.selectOne("com.shuaizhao.domain.User.checkUserIsExits", "18862106779");
		//System.out.println("number:"+i);
		UserMapper um=sqlsession.getMapper(UserMapper.class);
		um.insertUser(user);
		sqlsession.commit();
		sqlsession.close();
	}
	@Test
	public void TestUUID() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream configStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configStream);
		SqlSession sqlsession=sqlSessionFactory.openSession();
		Phone_UUID pu=new Phone_UUID("123", "54sdaddas");
		Phone_UUIDMapper pum=sqlsession.getMapper(Phone_UUIDMapper.class);
		//pum.insertUUID(pu);
		System.out.println(pum.checkUUIDExist("54sdaddas"));
		pum.findPhoneNumByUUID("54sdaddas");
		//pum.updateUUID(pu);
		sqlsession.commit();
	}
	
	@Test
	public void TestTip() throws IOException{
		String resource="SqlMapConfig.xml";
		InputStream configStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configStream);
		SqlSession sqlsession=sqlSessionFactory.openSession();
		UserDetailInfo user=new UserDetailInfo();
		user.setmPhoneNum("18862106779");
		user.setmSex("男");
		user.setmSignature("你们给我搞得这个啊，excited！");
		user.setmUserName("forever");
		UserMapper up=sqlsession.getMapper(UserMapper.class);
		up.saveUserInfo(user);
		sqlsession.commit();
	}
	
	@Test
	public void TestSignTime() throws IOException{
		SqlSession s1=MyBatisUtils.getSqlSession();
		SqlSession s2=MyBatisUtils.getSqlSession();
		System.out.println(s1==s2);
	}
	
	
}
