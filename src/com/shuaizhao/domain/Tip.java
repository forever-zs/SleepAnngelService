package com.shuaizhao.domain;

public class Tip {
	private int id;
	private String mMessage;
	private String mAuthor;
	public Tip(){
		
	}
	public Tip(String mMessage, String mAuthor) {
		super();
		this.mMessage = mMessage;
		this.mAuthor = mAuthor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getmMessage() {
		return mMessage;
	}
	public void setmMessage(String mMessage) {
		this.mMessage = mMessage;
	}
	public String getmAuthor() {
		return mAuthor;
	}
	public void setmAuthor(String mAuthor) {
		this.mAuthor = mAuthor;
	}
}
