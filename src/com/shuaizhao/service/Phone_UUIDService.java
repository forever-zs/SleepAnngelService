package com.shuaizhao.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.Phone_UUIDMapper;
import com.shuai.mapper.UserMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Phone_UUID;

public class Phone_UUIDService {
	private SqlSession sqlSession;
	private Phone_UUIDMapper phone_UUIDMapper;
	public Phone_UUIDService(){
		try {
			sqlSession=MyBatisUtils.getSqlSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phone_UUIDMapper=sqlSession.getMapper(Phone_UUIDMapper.class);
	}
	public Boolean checkUUIDExist(String mUUID){
		int checkResult=phone_UUIDMapper.checkUUIDExist(mUUID);
		if(checkResult==1){
			return true;
		}
		else{
			return false;
		}
	}
	public Phone_UUID findPhoneNumByUUID(String mUUID){
		return phone_UUIDMapper.findPhoneNumByUUID(mUUID);
	}
	public void insertUUID(Phone_UUID phone_UUID){
		phone_UUIDMapper.insertUUID(phone_UUID);
		sqlSession.commit();
	}
	public void updateUUID(Phone_UUID phone_UUID){
		phone_UUIDMapper.updateUUID(phone_UUID);
		sqlSession.commit();
	}
	public void deleteUUID(Phone_UUID phone_UUID){
		phone_UUIDMapper.deleteUUID(phone_UUID);
		sqlSession.commit();
	}
	
}
