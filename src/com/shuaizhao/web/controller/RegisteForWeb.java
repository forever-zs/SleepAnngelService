package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.domain.User;
import com.shuaizhao.service.Phone_UUIDService;
import com.shuaizhao.service.SignTimeService;
import com.shuaizhao.service.UserService;

public class RegisteForWeb extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String mPassword=(String)request.getParameter("mPassword");
		String mPhoneNum=(String)request.getParameter("mPhoneNum");
		String mUserName=(String)request.getParameter("mUserName");
		if(mPhoneNum.length()!=11){
			out.write("手机号码格式不对");
			out.close();
			return ;
		}
		User user=new User(mPassword, mUserName, mPhoneNum,"forever");
		UserService userService=new UserService();
		userService.registe(user); //注册用户表
		SignTimeService signTimeService=new SignTimeService();
		signTimeService.registe(user.getmPhoneNum());
		String mUUID=UUID.randomUUID().toString();
		out.write("注册成功");
		Phone_UUIDService pus=new Phone_UUIDService();
		Phone_UUID phone_UUID=new Phone_UUID(user.getmPhoneNum(), mUUID);//注册用户UUID对照表
		pus.insertUUID(phone_UUID);
		out.close();
	}

}
