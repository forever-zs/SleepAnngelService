package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shuaizhao.Utils.PathUtils;
import com.shuaizhao.Utils.UUIDUtils;
import com.shuaizhao.domain.Community;
import com.shuaizhao.domain.User;
import com.shuaizhao.exception.UserNotLogin;
import com.shuaizhao.global.GlobalContants;
import com.shuaizhao.service.CommunityService;
import com.shuaizhao.service.UserService;

public class UploadCommunity extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		String mUUID=request.getParameter("UUID");
		if(mUUID!=null){
			String comtent=request.getParameter("content");
			try {
				Community community=getCommunityByUUID(mUUID);
				community.setmContent(comtent);
				System.out.println("ÄÚÈÝÎª£º"+comtent);
				new CommunityService().insertCommunity(community);
			} catch (UserNotLogin e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.write("pleaseLoginFirst");
				return ;
			}
		}
		else{
			SmartUpload smartUpload=new SmartUpload();
			smartUpload.initialize(getServletConfig(),request,response);
			try {
				smartUpload.upload();
				Request smartRequest=smartUpload.getRequest();
				mUUID=smartRequest.getParameter("UUID");
				String phoneNum=UUIDUtils.getPhoneNumByUUID(mUUID);
				String mContent=smartRequest.getParameter("content");
				Community community=getCommunityByUUID(mUUID);
				community.setmContent(mContent);
				File file=smartUpload.getFiles().getFile(0);
				String path;
				if(!file.isMissing()){
					path=PathUtils.getSavePath(phoneNum, file.getFileName());
					file.saveAs(path,File.SAVEAS_VIRTUAL);
					community.setmImageURL(GlobalContants.URL+path);
				}
				new CommunityService().insertCommunity(community);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotLogin e) {
				// TODO Auto-generated catch block
				out.write("pleaseLoginFirst");
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}
	
	private Community getCommunityByUUID(String mUUID) throws UserNotLogin{
		Community community=new Community();
		String PhoneNum=UUIDUtils.getPhoneNumByUUID(mUUID);
		UserService us=new UserService();
		User user=us.findUserByPhoneNum(PhoneNum);
		community.setmName(user.getmUserName());
		community.setmPhoneNum(PhoneNum);
		community.setmHeadURL(user.getmHeadURL());
		community.setMtime(new Date());
		return community;
	}

}
