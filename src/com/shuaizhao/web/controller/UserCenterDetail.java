package com.shuaizhao.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shuaizhao.domain.UserTip;
import com.shuaizhao.service.TipService;

public class UserCenterDetail extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String UUID=request.getParameter("UUID");
		TipService tipService=new TipService();
		UserTip userTip=tipService.getUserTip(UUID);
		String userTipGson=new Gson().toJson(userTip);
		out.write(userTipGson);
		out.close();
	}

}
