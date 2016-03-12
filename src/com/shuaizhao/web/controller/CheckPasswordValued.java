package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shuaizhao.domain.Phone_UUID;
import com.shuaizhao.exception.UserNotExistException;
import com.shuaizhao.exception.UserPasswordNotMatchException;
import com.shuaizhao.service.Phone_UUIDService;
import com.shuaizhao.service.UserService;

public class CheckPasswordValued extends HttpServlet {

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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
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
		String mPassword=request.getParameter("password");
		System.out.println(mPassword);
		Phone_UUIDService pus=new Phone_UUIDService();
		Phone_UUID phone_UUID=pus.findPhoneNumByUUID(mUUID);
		String mPhoneNum=phone_UUID.getmPhoneNum();         //通过UUID获得电话号码
		UserService us=new UserService();
		try {
			us.login(mPhoneNum, mPassword);
		} catch (UserPasswordNotMatchException e) {
			
			out.write("passwordIsNotValued");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (UserNotExistException e) {
			// TODO Auto-generated catch block
			out.write("userNotExist");
			e.printStackTrace();
			return ;
		}
		out.write("passwordIsvalued");
		out.close();
	}

}
