<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <form action="/SleepAngel/Registe" method="post">
		手机<input type="text" name="mPhoneNum" /><br/>
		用户<input type="text" name="mUserName"/><br/>
		密码<input type="password" name="mPassword"/><br/>
		<input type="submit" value="提交"/><br/>
	</form>
	
	<form action="/SleepAngel/Login" method="post">
		手机<input type="text" name="PhoneNum" /><br/>
		密码<input type="password" name="Password"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<form action="/SleepAngel/SignUp" method="post">
		UUID<input type="text" name="UUID" /><br/>
		<input type="submit" value="提交"/>
	</form>
	
  </body>
</html>
