<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.students"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生宿舍管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<link href="css/super_floor.css" rel="stylesheet">
  </head>
  
  <body background="img/bg.jpg">
	<!-- 导航栏 -->
<nav class="navbar  navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- 响应式导航栏 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><b>学生宿舍管理系统</b></a>
        </div>
        <!-- 栅栏导航  -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <!--   <ul class="nav navbar-nav nav-pills">
                <li role="presentation" class="active"><a href="show_students"><b>学生信息</b></a></li>
                <li role="presentation"><a href="come"><b>来访登记</b></a></li>
            </ul>-->
            <!-- 右导航 -->
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span style="padding: 10px 15px; display:block;padding-top: 15px;"><b>
               		 您好</b><b>，您是普通用户</b></span></li>
                <li role="presentation"><a href="index.jsp"><b>退出</b></a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="padding-top:30px;">
    <table class="table  table-hover" id="table">
     <%  students  student = (students)session.getAttribute("list");
     		int room_id = Integer.parseInt(request.getAttribute("room_id").toString());
			 pageContext.setAttribute("room_id", room_id);
     		String str= (String)request.getAttribute("str");
     		 pageContext.setAttribute("res", str);
  			int id=student.getId();
			String name=student.getName(); 
			int age=student.getAge();
		    int sex=student.getSex();
			int phone=student.getPhone();
			int grade=student.getGrade();
			String sub=student.getSub();
			pageContext.setAttribute("id", id);
	    	pageContext.setAttribute("name", name);
	    	pageContext.setAttribute("age", age);
	    	pageContext.setAttribute("sex", sex);
	    	pageContext.setAttribute("phone", phone);
	    	pageContext.setAttribute("grade", grade);
	    	pageContext.setAttribute("sub", sub);
 	%>
 		<h4>${res}</h4>
        <tr class="info">
            <th class="id">学号</th>
            <th>${id}</th>
            <th class="num">姓名</th>
            <th>${name}</th>
        </tr>
        <tr>
            <th >年龄</th>
             <th>${age}</th>
            <th width="120px;">性别</th>
             <th>${sex}</th>
        </tr>
        <tr>
            <th width="120px;">电话</th>
            <th>${phone}</th>
            <th width="120px;">年级</th>
            <th>${grade}</th>
         </tr>
         <tr>
            <th width="120px;">专业</th>
            <th>${sub}</th>
            <th width="120px;">宿舍编号</th>
            <th>${room_id}</th>
        </tr>
       
    </table>

</div>
</body>
</html>
