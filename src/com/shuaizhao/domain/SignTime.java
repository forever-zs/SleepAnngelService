package com.shuaizhao.domain;

import java.util.Calendar;
import java.util.Date;

public class SignTime {
	private int sign_count;
	private Date sign_time;
	private String mPhoneNum;
	public SignTime(){
		
	}
	public SignTime(int sign_count, Date sing_time, String mPhoneNum) {
		super();
		this.sign_count = sign_count;
		this.sign_time = sing_time;
		this.mPhoneNum = mPhoneNum;
	}
	public int getSign_count() {
		return sign_count;
	}
	public void setSign_count(int sign_count) {
		this.sign_count = sign_count;
	}
	public Date getSign_time() {
		return sign_time;
	}
	public void setSign_time(Date sign_time) {
		this.sign_time = sign_time;
	}
	public String getmPhoneNum() {
		return mPhoneNum;
	}
	public void setmPhoneNum(String mPhoneNum) {
		this.mPhoneNum = mPhoneNum;
	}
	
}
