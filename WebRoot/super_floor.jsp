<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.User"%>
<%@ page language="java" import="User.floor"%>
<%@ page language="java" import="DAO.floorDao"%>
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
            <ul class="nav navbar-nav nav-pills">
                <li role="presentation"><a href="show_floor" active><b>宿舍楼</b></a></li>
            </ul> 
           <ul class="nav navbar-nav nav-pills">
                <li role="presentation"><a href="show_allroom"><b>宿舍信息</b></a></li>
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
<div class="container" style="padding-top:30px;">
 <!--  <div style="float:right;margin-top:5px;margin-right:22px;">
         <div class="form-group" style="width:200px; float:left;">
            <input type="text" class="form-control" placeholder="楼编号搜索" id="search_input"></div>&nbsp
        <button type="button" class="btn btn-default" id="search" style="float:right;">搜索</button> 
    </div> -->
    <table class="table  table-hover" id="table">
        <tr class="success">
            <th class="id">楼编号</th>
            <th class="num">宿舍数</th>
            <th class="location">楼位置</th>
            <th width="150px;">操作</th>
        </tr>
        <tbody>
        <%
			List<floor> list = (List<floor>)session.getAttribute("list");
			int now_page=Integer.parseInt((String)session.getAttribute("page"));
		%>
		<c:forEach var="list" items="${list}" varStatus="item">
			<tr class="info">
				<th class="id">${list.getId()}</th>
				<th class="num">${list.getNum()}</th>
				<th class="location" style="width:740px;">${list.getPosition()}</th>
				<th>
					<!-- <button class="btn btn-info btn-sm" type="button" onclick="">编辑</button>
		            <button class="btn btn-warning btn-sm" type="button" id="delet" onclick="">删除</button>
		            <button class="btn btn-info  btn-sm" type="button"  onclick="">查看</button> -->
				    <a href='alter_floor?id=${list.getId()}'>编辑</a>&nbsp;
					<a href='delete_floor?id=${list.getId()}'>删除</a>&nbsp;
					<a href="show_room?floor_id=${list.getId()}">查看</a>
				</th>
			</tr>
   	   </c:forEach>

		 <tr class="info"><th colspan=4><a href='add_floor.jsp'>添加</a></th></tr>
        </tbody>
       
    </table>
    <!-- 分页按钮 -->
    <div id="turnPage">
        <ul class="pagination pagination;width:300px;">
            <li><a href="show_floor?page=${page-1}" id="last_page">&laquo;上一页</a></li>
            <li><a href="show_floor?page=${page+1}" id="next_page">下一页&raquo;</a></li>
        </ul>
    </div>

</div>
</body>
</html>
