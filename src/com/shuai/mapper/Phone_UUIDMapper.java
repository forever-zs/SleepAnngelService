package com.shuai.mapper;

import com.shuaizhao.domain.Phone_UUID;

public interface Phone_UUIDMapper {
	public int checkUUIDExist(String mUUID);
	public Phone_UUID findPhoneNumByUUID(String mUUID);
	public void insertUUID(Phone_UUID phone_UUID);
	public void updateUUID(Phone_UUID phone_UUID);
	public void deleteUUID(Phone_UUID phone_UUID);
}
