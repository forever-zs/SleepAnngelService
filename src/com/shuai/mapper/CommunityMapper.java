package com.shuai.mapper;

import java.util.ArrayList;
import java.util.Date;

import com.shuaizhao.domain.Community;

public interface CommunityMapper {
	public void insertImage(Community mCommunity);
	public void insertContent(Community mCommunity);
	public void insertCommunity(Community mCommunity);
	public void updateImage(Community mCommunity);
	public void updateContent(Community mCommunity);
	public String isInsertedContent(String mPhoneNum);
	public String isInsertedImage(String mPhoneNum);
	public ArrayList<Community> findCommunityByTime(String time);
}
