package com.shuaizhao.web.controller;

import java.io.File;
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

public class Registe extends HttpServlet {

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
		System.out.println("haha");
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
		//System.out.println("haha");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String json_str=request.getParameter("jsonStr");
		Gson gson=new Gson();
		User user=gson.fromJson(json_str,User.class);
		/*String mPassword=(String)request.getParameter("mPassword");
		String mPhoneNum=(String)request.getParameter("mPhoneNum");
		String mUserName=(String)request.getParameter("mUserName");
		User user=new User(mPassword, mUserName, mPhoneNum,"forever");*/
		UserService userService=new UserService();
		userService.registe(user); //ע���û���
		
		File file=new File(getServletContext().getRealPath("/")+"/"+user.getmPhoneNum());
		file.mkdir();
		SignTimeService signTimeService=new SignTimeService();
		signTimeService.registe(user.getmPhoneNum());
		String mUUID=UUID.randomUUID().toString();
		out.write(mUUID);
		Phone_UUIDService pus=new Phone_UUIDService();
		Phone_UUID phone_UUID=new Phone_UUID(user.getmPhoneNum(), mUUID);//ע���û�UUID���ձ�
		pus.insertUUID(phone_UUID);
		out.close();
	}

}
