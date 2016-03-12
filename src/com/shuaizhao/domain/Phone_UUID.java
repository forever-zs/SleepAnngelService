package com.shuaizhao.domain;

public class Phone_UUID {
	private String mPhoneNum;
	private String mUUID;
	public Phone_UUID(){
		
	}
	public Phone_UUID(String mPhoneNum, String mUUID) {
		super();
		this.mPhoneNum = mPhoneNum;
		this.mUUID = mUUID;
	}
	public String getmPhoneNum() {
		return mPhoneNum;
	}
	public void setmPhoneNum(String mPhoneNum) {
		this.mPhoneNum = mPhoneNum;
	}
	public String getmUUID() {
		return mUUID;
	}
	public void setmUUID(String mUUID) {
		this.mUUID = mUUID;
	}
	
}
