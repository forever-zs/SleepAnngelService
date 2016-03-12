package com.shuaizhao.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.UserMapper;
import com.shuaizhao.Utils.MD5Untils;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.User;
import com.shuaizhao.domain.UserDetailInfo;
import com.shuaizhao.exception.UserNotExistException;
import com.shuaizhao.exception.UserPasswordNotMatchException;

public class UserService{
	
	private SqlSession sqlSession;
	private UserMapper userMapper;
	public UserService() {
		try {
			sqlSession=MyBatisUtils.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userMapper=sqlSession.getMapper(UserMapper.class);
	}
	
	public User findUserByPhoneNum(String PhoneNum){
		return userMapper.findUserByPhoneNum(PhoneNum);
	}
	
	public UserDetailInfo findUserDetailInfoByPhoneNum(String mPhoneNum){
		return userMapper.findUserDetailInfoByPhoneNum(mPhoneNum);
	}
	public void addUser(User user){
		userMapper.insertUser(user);
		sqlSession.commit();
	}
	
	public void updateUser(User user){
		userMapper.updateUser(user);
		sqlSession.commit();
	}
	
	public void deleteUser(User user){
		userMapper.deleteUser(user);
		sqlSession.commit();
	}
	
	public boolean checkUserIsExits(String mPhoneNum){
		int user_number=userMapper.checkUserIsExits(mPhoneNum);
		if(user_number>0){
			return true;
		}
		else
			return false;
	}
	
	public void registe(User user){
		String mPassword=user.getmPassword();
		user.setmPassword(MD5Untils.md5(mPassword));
		addUser(user);
	}
	
	public void login(String mPhoneNum,String mPassword) throws UserPasswordNotMatchException, UserNotExistException{
		mPassword=MD5Untils.md5(mPassword);
		User user=new User(mPassword, mPhoneNum);
		int userIsExist=userMapper.checkUserIsExits(mPhoneNum);
		if(userIsExist==0){
			throw new UserNotExistException("用户不存在");
		}
		int loginResult=userMapper.login(user);
		if(loginResult==0){
			throw new UserPasswordNotMatchException("用户名与密码不匹配");
		}
	}
	
	public void saveUserDetailInfo(UserDetailInfo userDetailInfo){
		userMapper.saveUserInfo(userDetailInfo);
		sqlSession.commit();
	}
	
	public void updatePassword(User user){
		String mPassword=user.getmPassword();
		user.setmPassword(MD5Untils.md5(mPassword));
		userMapper.updatePassword(user);
		sqlSession.commit();
	}
	
	public void updateHeadURL(UserDetailInfo userDetailInfo){
		userMapper.updateHeadURL(userDetailInfo);
		sqlSession.commit();
	}
	
	public String findHeadURLByPhoneNum(String mPhoneNum){
		return userMapper.findHeadURLByPhoneNum(mPhoneNum);
	}
}
