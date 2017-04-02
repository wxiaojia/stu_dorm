<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.allot"%>
<%@ page language="java" import="User.students"%>
<%@ page language="java" import="DAO.allotDao"%>
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
<style>
	 body {
    padding-top: 50px; 
    padding-bottom: 40px;
    color: #5a5a5a;
}

th {
    text-align: center;
}
#even {
    background-color: #f9f9f9;
}
#turnPage {
    width: 28%;
    margin: 0 auto;
    margin-top: -13px;
    font-family: "妤蜂綋";
}
#page_num {
    width: 11%;
    height: 20px;
}
#but {
    width: 60px;
    font-family: "妤蜂綋";
    cursor: pointer;
}
.id,.num{
    width: 100px;
}
a{
	text-decoration:none;
}
a:hover{
	text-decoration:none;
}
</style>
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
         <ul class="nav navbar-nav nav-pills">
                <li role="presentation"><a href="show_floor"><b>宿舍楼</b></a></li>
            </ul>
            <!-- 右导航 -->
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span style="padding: 10px 15px; display:block;padding-top: 15px;"><b>
               		 您好</b><b>，您是超级管理员</b></span></li>
                <li role="presentation"><a href="index.jsp"><b>退出</b></a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="padding-top:15px;">
    <div style="float:right;margin-top:5px;margin-right:22px;">
        <div class="form-group" style="width:200px; float:left;">
            <input type="text" class="form-control" placeholder="楼编号搜索" id="search_input"></div>&nbsp
        <button type="button" class="btn btn-default" id="search" style="float:right;">搜索</button>
    </div>
      <%
		    students  studa = (students)request.getAttribute("stua");
		    students  studb = (students)request.getAttribute("stub");
			students  studc = (students)request.getAttribute("stuc");
			students  studd = (students)request.getAttribute("stud");
			pageContext.setAttribute("ida", studa.getId());
			pageContext.setAttribute("namea", studa.getName());
			pageContext.setAttribute("suba", studa.getSub());
			pageContext.setAttribute("gradea", studa.getGrade());
			
			pageContext.setAttribute("idb", studb.getId());
			pageContext.setAttribute("nameb", studb.getName());
			pageContext.setAttribute("subb", studb.getSub());
			pageContext.setAttribute("gradeb", studb.getGrade());
			
			pageContext.setAttribute("idc", studc.getId());
			pageContext.setAttribute("namec", studc.getName());
			pageContext.setAttribute("subc", studc.getSub());
			pageContext.setAttribute("gradec", studc.getGrade());
			
			pageContext.setAttribute("idd", studd.getId());
			pageContext.setAttribute("named", studd.getName());
			pageContext.setAttribute("subd", studd.getSub());
			pageContext.setAttribute("graded", studd.getGrade());
			
			int room_id = Integer.parseInt(request.getAttribute("room_id").toString());
			pageContext.setAttribute("room_id",room_id);
			
		%>
	<h1>这是第${room_id}号房</h1>
    <table class="table  table-hover" id="table">
        <tr class="success">
            <th class="id">学号</th>
            <th class="name">姓名</th>
            <th class="sub">专业</th>
            <th class="grade">年级</th>
             <th width="150px;">操作</th>
        </tr>
        <tbody>
			<tr class="info">
				<th class="ida">${ida}</th>
				<th class="name">${namea}</th>
				<th class="sub">${suba}</th>
				<th class="grade">${gradea}</th>
				<th>
					<a href='delete_roomstu?room_id=${room_id}&&id=1'>删除</a>&nbsp;
				</th>
			</tr>
			<tr class="info">
				<th class="idb">${idb}</th>
				<th class="name">${nameb}</th>
				<th class="sub">${subb}</th>
				<th class="grade">${gradeb}</th>
				<th>
					<a href='delete_roomstu?room_id=${room_id}&&id=2'>删除</a>&nbsp;
				</th>
			</tr>
			<tr class="info">
				<th class="idc">${idc}</th>
				<th class="name">${namec}</th>
				<th class="sub">${subc}</th>
				<th class="grade">${gradec}</th>
				<th>
					<a href='delete_roomstu?room_id=${room_id}&&id=3'>删除</a>&nbsp;
				</th>
			</tr>
			<tr class="info">
				<th class="ida">${idd}</th>
				<th class="name">${named}</th>
				<th class="sub">${subd}</th>
				<th class="grade">${graded}</th>
				<th>
					<a href='delete_roomstu?room_id=${room_id}&&id=4'>删除</a>&nbsp;
				</th>
			</tr>
		
		 <tr class="info"><th colspan=7><a href='add_roomid?room_id=${room_id}'>添加</a></th></tr>
        </tbody>
       
    </table>
  </div>
  <script>
  	
  </script>
</body>
</html>
