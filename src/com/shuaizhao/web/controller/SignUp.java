package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shuaizhao.service.SignTimeService;

public class SignUp extends HttpServlet {

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
		doPost(request, response);
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

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("haa");
		String UUID=request.getParameter("UUID");
		System.out.println(UUID);
		if(UUID.equals("")){
			out.write("userNotLogin");
			System.out.println("userNotLogin");
			return ;
		}
		SignTimeService signTimeService=new SignTimeService();
		boolean signUpResult=signTimeService.signUp(UUID);
		if(signUpResult==true){
			out.write("Success");
			System.out.println("Success");
		}
		else{
			out.write("CanNotSignUpAgain");
			System.out.println("CanNotSignUpAgain");
		}
		out.close();
	}

}
