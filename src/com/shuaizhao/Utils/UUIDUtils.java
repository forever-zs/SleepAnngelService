package com.shuaizhao.Utils;

import com.shuaizhao.exception.UserNotLogin;
import com.shuaizhao.service.Phone_UUIDService;

public class UUIDUtils {
	public static String getPhoneNumByUUID(String mUUID) throws UserNotLogin {
		Phone_UUIDService phoneService = new Phone_UUIDService();
		if(!phoneService.checkUUIDExist(mUUID)){
			throw new UserNotLogin(); 
		}
		return phoneService.findPhoneNumByUUID(mUUID).getmPhoneNum();
	}
}
