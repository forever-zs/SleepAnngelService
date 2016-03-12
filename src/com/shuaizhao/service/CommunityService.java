package com.shuaizhao.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.CommunityMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Community;

public class CommunityService implements Service{
	private SqlSession sqlSession;
	private CommunityMapper communityMapper;
	public CommunityService() throws IOException{
		sqlSession=MyBatisUtils.getSqlSession();
		communityMapper=sqlSession.getMapper(CommunityMapper.class);
	}
	
	public void insertImage(Community mCommunity){
		communityMapper.insertImage(mCommunity);
		sqlSession.commit();
	}
	
	public void insertContent(Community mCommunity){
		communityMapper.insertContent(mCommunity);
		sqlSession.commit();
	}
	
	public void updateImage(Community mCommunity){
		communityMapper.updateImage(mCommunity);
		sqlSession.commit();
	}
	
	public void updateContent(Community mCommunity){
		communityMapper.updateContent(mCommunity);
		sqlSession.commit();
	}
	
	public boolean isInsertedContent(String mPhoneNum){
		if(communityMapper.isInsertedContent(mPhoneNum)==null){
			return false;
		}
		return true;
	}
	
	public boolean isInsertedImage(String mPhoneNum){
		if(communityMapper.isInsertedImage(mPhoneNum)==null){
			return false;
		}
		return true;
	}
	
	public void insertCommunity(Community mCommunity){
		communityMapper.insertCommunity(mCommunity);
		sqlSession.commit();
	}
	
	public ArrayList<Community> findCommunityByTime(String time){
		return communityMapper.findCommunityByTime(time);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sqlSession.close();
		MyBatisUtils.sqlSessionList.remove(sqlSession);
	}
	
}
