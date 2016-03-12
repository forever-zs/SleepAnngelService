package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shuaizhao.Utils.PathUtils;
import com.shuaizhao.Utils.UUIDUtils;
import com.shuaizhao.domain.UserDetailInfo;
import com.shuaizhao.exception.UserNotLogin;
import com.shuaizhao.global.GlobalContants;
import com.shuaizhao.service.UserService;

public class UploadHeadPicture extends HttpServlet {

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
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			smartUpload.upload();
			String UUID=smartUpload.getRequest().getParameter("UUID");
			String PhoneNum=UUIDUtils.getPhoneNumByUUID(UUID);
			Files smartFiles = smartUpload.getFiles();
			System.out.println("count" + smartFiles.getCount());
			for (int i = 0; i < smartFiles.getCount(); i++) {
				File file = smartFiles.getFile(i);
				String savePath=PathUtils.getSavePath(PhoneNum, file.getFileName());
				file.saveAs(savePath, File.SAVEAS_VIRTUAL);   //代表存储在以当前项目当前项目为根目录中
				UserDetailInfo userDetailInfo=new UserDetailInfo();
				userDetailInfo.setmPhoneNum(PhoneNum);
				userDetailInfo.setmHeadURL(GlobalContants.URL+savePath);
				new UserService().updateHeadURL(userDetailInfo);
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotLogin e) {
			// TODO Auto-generated catch block
			out.write("pleaseLoginFirst");
			e.printStackTrace();
		}
		out.close();
	}

}
