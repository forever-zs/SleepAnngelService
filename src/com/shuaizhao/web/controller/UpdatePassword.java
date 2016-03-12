package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shuaizhao.domain.User;
import com.shuaizhao.service.Phone_UUIDService;
import com.shuaizhao.service.UserService;

public class UpdatePassword extends HttpServlet {

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
		out.close();
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
		PrintWriter out = response.getWriter();
		String mUUID=request.getParameter("UUID");
		Phone_UUIDService pus=new Phone_UUIDService();
		String mPhoneNum=pus.findPhoneNumByUUID(mUUID).getmPhoneNum();
		String mPassword=request.getParameter("newPassword");
		System.out.println("ÐÂÃÜÂë£º"+mPassword);
		User user=new User();
		user.setmPassword(mPassword);
		user.setmPhoneNum(mPhoneNum);
		UserService userService=new UserService();
		userService.updatePassword(user);
		
		out.flush();
		out.close();
	}

}
