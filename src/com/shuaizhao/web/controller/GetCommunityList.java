package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shuaizhao.domain.Community;
import com.shuaizhao.domain.CommunityForClient;
import com.shuaizhao.domain.CommunityList;
import com.shuaizhao.service.CommunityService;

public class GetCommunityList extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String time=request.getParameter("time");
		//String local_time=new Date(time).toLocaleString();
		System.out.println(time);
		
		ArrayList<Community> communitys= new CommunityService().findCommunityByTime(time);
		ArrayList<CommunityForClient> cfcs=new ArrayList<CommunityForClient>();
		for(int i=0;i<communitys.size();i++){
			CommunityForClient cfc=new CommunityForClient();
			cfc.setId(communitys.get(i).getId());
			cfc.setmContent(communitys.get(i).getmContent());
			cfc.setmHeadURL(communitys.get(i).getmHeadURL());
			cfc.setmImageURL(communitys.get(i).getmImageURL());
			cfc.setmName(communitys.get(i).getmName());
			cfc.setmPhoneNum(communitys.get(i).getmPhoneNum());
			cfc.setMtime(communitys.get(i).getMtime().toLocaleString());
			cfcs.add(cfc);
		}
		Gson gson=new Gson();
		CommunityList communityList=new CommunityList();
		communityList.setmContentList(cfcs);
		out.write(gson.toJson(communityList));
		System.out.println(gson.toJson(communityList));
		out.flush();
		out.close();
	}

}
