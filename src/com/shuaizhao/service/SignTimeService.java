package com.shuaizhao.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.shuai.mapper.SignTimeMapper;
import com.shuai.mapper.TipMapper;
import com.shuaizhao.Utils.MyBatisUtils;
import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.domain.SignTime;

public class SignTimeService {
	private SqlSession sqlSession;
	private SignTimeMapper signTimeMapper;
	public SignTimeService() throws IOException{
		sqlSession=MyBatisUtils.getSqlSession();
		signTimeMapper=sqlSession.getMapper(SignTimeMapper.class);
	}
	
	public boolean signUp(String UUID){
		Phone_UUIDService pus=new Phone_UUIDService();
		Phone_UUID pu=pus.findPhoneNumByUUID(UUID);
		if(pu==null)
			return false;
		String mPhoneNum=pu.getmPhoneNum();
		//System.out.println("tel:"+mPhoneNum);
		SignTime signTime=signTimeMapper.findSignTimeByNum(mPhoneNum);//得到signTime对象
		if(signTime==null){
			return false;
		}
		
		Date olddate=signTime.getSign_time();
		Calendar cal1=Calendar.getInstance();
		cal1.setTime(olddate);
		Date newdate=new Date();
		Calendar cal2=Calendar.getInstance();
		cal2.setTime(newdate);
		if((cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR))||(newdate.getHours()<5||newdate.getHours()>8)){//判断是否为重复签到
			//System.out.println("zs");
			//System.out.println(cal1.get(Calendar.DAY_OF_YEAR)+"\n"+cal2.get(Calendar.DAY_OF_YEAR)+"\n"+(newdate.getHours()+1));
			return false;
		}
		signTime.setSign_count(signTime.getSign_count()+1);
		signTime.setSign_time(newdate);
		signTimeMapper.updateSignTime(signTime);
		sqlSession.commit();
		return true;
	}
	
	public void registe(String mPhoneNum){
		SignTime signTime=new SignTime(0, new Date(0), mPhoneNum);
		signTimeMapper.insertSignTime(signTime);
		sqlSession.commit();
	}
	
}
