<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.room"%>
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
     <%  room  room = (room)session.getAttribute("list");
     		String str= (String)request.getAttribute("str");
     		 pageContext.setAttribute("res", str);
  			int id=room.getId();
			int floor=room.getFloor(); 
			int bed=room.getBed();
		    int price=room.getPrice();
			int people=room.getPeople();
			int floor_id=room.getFloor_id();
			pageContext.setAttribute("id", id);
	    	pageContext.setAttribute("floor", floor);
	    	pageContext.setAttribute("bed", bed);
	    	pageContext.setAttribute("price", price);
	    	pageContext.setAttribute("people", people);
	    	pageContext.setAttribute("floor_id", floor_id);
 	%>
 		<h4>${res}</h4>
        <tr class="info">
            <th class="id">宿舍编号</th>
            <th>${id}</th>
            <th class="floor">楼层</th>
            <th>${floor}</th>
        </tr>
        <tr>
            <th >床位</th>
             <th>${bed}</th>
            <th width="120px;">价格</th>
             <th>${price}</th>
        </tr>
        <tr>
            <th width="120px;">人数</th>
            <th>${people}</th>
            <th width="120px;">楼编号</th>
            <th>${floor_id}</th>
         </tr>       
    </table>

</div>
</body>
</html>
