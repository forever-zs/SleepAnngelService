package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.domain.UserDetailInfo;
import com.shuaizhao.service.Phone_UUIDService;
import com.shuaizhao.service.UserService;

public class UpdateUserInfo extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String mUUID = request.getParameter("UUID");
		System.out.println(mUUID);
		Phone_UUIDService pus = new Phone_UUIDService();
		if (!pus.checkUUIDExist(mUUID)) {
			out.print("pleaseLoginFirst");
			return;
		}
		Phone_UUID mPhone_UUID=pus.findPhoneNumByUUID(mUUID);
		saveUserInfo(request,mPhone_UUID);

		out.close();
	}

	private void saveUserInfo(HttpServletRequest request,Phone_UUID mPhone_UUID ) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String mPhoneNum = mPhone_UUID.getmPhoneNum();
		UserDetailInfo userDetailInfo = new UserDetailInfo();
		String userDetailInfoGson = request.getParameter("userDetailInfo");
		Gson gson = new Gson();
		userDetailInfo = gson.fromJson(userDetailInfoGson, UserDetailInfo.class);
		userDetailInfo.setmPhoneNum(mPhoneNum);
		UserService us=new UserService();
		us.saveUserDetailInfo(userDetailInfo);
	}

	
}
