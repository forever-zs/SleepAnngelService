package com.shuaizhao.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.MusicMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Music;

public class MusicService {
	private SqlSession sqlSession;
	private MusicMapper musicMapper;
	public MusicService() throws IOException{
		sqlSession=MyBatisUtils.getSqlSession();
		musicMapper=sqlSession.getMapper(MusicMapper.class);
	}
	public ArrayList<Music> getAllMusic(){
		return musicMapper.getAllMusic();
	}
}
