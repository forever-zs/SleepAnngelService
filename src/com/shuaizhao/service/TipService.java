package com.shuaizhao.service;

import java.io.IOException;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.TipMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.domain.Tip;
import com.shuaizhao.domain.User;
import com.shuaizhao.domain.UserTip;

public class TipService {
	private SqlSession sqlSession;
	private TipMapper tipMapper;
	public TipService() throws IOException{
		sqlSession=MyBatisUtils.getSqlSession();
		tipMapper=sqlSession.getMapper(TipMapper.class);
	}
	
	public Tip getTip(){
		int id=new Random().nextInt(3)+1;
		return tipMapper.findTipById(id);
	}
	public UserTip getUserTip(String UUID){
		UserTip userTip=new UserTip();
		userTip.setMtip(getTip());
		Phone_UUIDService phone_UUIDService=new Phone_UUIDService();
		if(phone_UUIDService.checkUUIDExist(UUID)){
			Phone_UUID pu=phone_UUIDService.findPhoneNumByUUID(UUID);
			User user=new UserService().findUserByPhoneNum(pu.getmPhoneNum());
			userTip.setmUserName(user.getmUserName());
			return userTip;
		}
		else{
			userTip.setmUserName("");
			return userTip;
		}
	}
}
