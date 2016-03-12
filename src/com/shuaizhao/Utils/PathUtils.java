package com.shuaizhao.Utils;

import com.shuaizhao.global.GlobalContants;

public class PathUtils {
	public static String getSavePath(String mPhoneNum,String fileName){
		String path="/"+mPhoneNum+"/"+fileName;
		return path;
	}
}