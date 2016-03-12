package com.shuaizhao.domain;

import java.util.Date;

public class Community {
	private int id;
	private Date mTime;
	private String mHeadURL;
	private String mName;
	private String mPhoneNum;
	private String mContent;
	private String mImageURL;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMtime() {
		return mTime;
	}
	public void setMtime(Date mtime) {
		this.mTime = mtime;
	}
	public String getmHeadURL() {
		return mHeadURL;
	}
	public void setmHeadURL(String mHeadURL) {
		this.mHeadURL = mHeadURL;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPhoneNum() {
		return mPhoneNum;
	}
	public void setmPhoneNum(String mPhoneNum) {
		this.mPhoneNum = mPhoneNum;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getmImageURL() {
		return mImageURL;
	}
	public void setmImageURL(String mImageURL) {
		this.mImageURL = mImageURL;
	}
}
