package com.shuai.mapper;

import com.shuaizhao.domain.User;
import com.shuaizhao.domain.UserDetailInfo;

public interface UserMapper {
	public int checkUserIsExits(String mPhoneNum);
	public void insertUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public int login(User user);
	public User findUserByPhoneNum(String mPhoneNum);
	public void saveUserInfo(UserDetailInfo userDetailInfo);
	public UserDetailInfo findUserDetailInfoByPhoneNum(String mPhoneNum);
	public void updatePassword(User user);
	public void updateHeadURL(UserDetailInfo userDetailInfo);
	public String findHeadURLByPhoneNum(String mPhoneNum);
}
