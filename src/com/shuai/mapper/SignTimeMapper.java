package com.shuai.mapper;

import com.shuaizhao.domain.SignTime;

public interface SignTimeMapper {
	public SignTime findSignTimeByNum(String mPhoneNum);
	public void insertSignTime(SignTime signTime);
	public void updateSignTime(SignTime signTime);
}
