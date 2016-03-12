package com.shuaizhao.domain;

import java.sql.Date;

public class User {
	private String id;
	private String mPassword;
	private String mUserName;
	private String mPhoneNum;
	private String mNickName;
	private String mHeadURL;

	public String getmHeadURL() {
		return mHeadURL;
	}

	public void setmHeadURL(String mHeadURL) {
		this.mHeadURL = mHeadURL;
	}

	public User(String mPassword, String mUserName, String mPhoneNum,
			String mNickName) {
		super();
		this.mPassword = mPassword;
		this.mUserName = mUserName;
		this.mPhoneNum = mPhoneNum;
		this.mNickName = mNickName;
	}
	
	public User(String mPassword, String mUserName, String mPhoneNum) {
		super();
		this.mPassword = mPassword;
		this.mUserName = mUserName;
		this.mPhoneNum = mPhoneNum;
	}
	
	public User(String mPassword,String mPhoneNum) {
		super();
		this.mPassword = mPassword;
		this.mPhoneNum = mPhoneNum;
	}
	
	public User(){
		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmPhoneNum() {
		return mPhoneNum;
	}

	public void setmPhoneNum(String mPhoneNum) {
		this.mPhoneNum = mPhoneNum;
	}

	public String getmNickName() {
		return mNickName;
	}

	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}

}
