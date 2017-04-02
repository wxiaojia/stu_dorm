<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
  	<center>
  	 	<%
			User stu = (User)session.getAttribute("use");
  			int num=stu.getId();
			String name=stu.getName(); 
			String pw=stu.getPw();
			int right=stu.getRights();
			String rights;
			if(right==0) rights="超级管理员";
			else if(right==1) rights="普通管理员";
			else rights="普通用户";
			pageContext.setAttribute("id", num);
	    	pageContext.setAttribute("name", name);
	    	pageContext.setAttribute("Pw", pw);
	    	pageContext.setAttribute("rights", rights);
		%>
  		<h1>欢迎您！${name}</h1><br/>
  		您的个人信息如下：
  		<br/>编号：${id}
  		<br/>姓名：${name}
  		<br/>密码：${Pw}
  		<br/>权限：${rights}
 
  	</center>
  </body>
</html>
