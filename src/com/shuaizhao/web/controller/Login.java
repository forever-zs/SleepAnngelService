package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.exception.UserNotExistException;
import com.shuaizhao.exception.UserPasswordNotMatchException;
import com.shuaizhao.service.Phone_UUIDService;
import com.shuaizhao.service.UserService;

public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.close();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mPhoneNum=request.getParameter("PhoneNum");
		String mPassword=request.getParameter("Password");
		System.out.println("tel"+mPhoneNum);
		System.out.println("pass:"+mPassword);
		UserService userService=new UserService();
		try {
			userService.login(mPhoneNum, mPassword);
		} catch (UserPasswordNotMatchException e) {
			// TODO Auto-generated catch block
			//out.write("user_not_exit");方便app端的编写，因此暂时不考虑用户不存在的异常；
			out.write("userName_Password_not_match");
			out.close();
			return ;
		} catch (UserNotExistException e) {
			// TODO Auto-generated catch block
			out.write("userName_Password_not_match");
			out.close();
			return ;
		}
		String mUUID=UUID.randomUUID().toString();
		out.write(mUUID);
		Phone_UUIDService pus=new Phone_UUIDService();
		Phone_UUID phone_UUID=new Phone_UUID(mPhoneNum, mUUID);
		pus.updateUUID(phone_UUID);
		out.close();
	}

}
