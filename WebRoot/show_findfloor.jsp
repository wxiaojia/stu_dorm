<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.room"%>
<%@ page language="java" import="DAO.roomDao"%>
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
            <!-- 右导航 -->
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span style="padding: 10px 15px; display:block;padding-top: 15px;"><b>
               		 您好</b><b>，您是普通用户</b></span></li>
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
    <table class="table  table-hover" id="table">
        <tr class="success">
            <th class="id">宿舍编号</th>
            <th class="num">楼层</th>
            <th class="bed">床位数</th>
            <th class="price">单价</th>
            <th class="people">人数</th>
        </tr>
        <tbody>
        <%
			List<room> list = (List<room>)session.getAttribute("list");
		%>
		<c:forEach var="list" items="${list}" varStatus="item">
			<tr class="info">
				<th class="id">${list.getId()}</th>
				<th class="num">${list.getFloor()}</th>
				<th class="bed">${list.getBed()}</th>
				<th class="price">${list.getPrice()}</th>
				<th class="people">${list.getPeople()}</th>
			 <!-- 	<th class="floor_id">${list.getFloor_id()}</th> -->
				
			</tr>
   	   </c:forEach>
        </tbody>
       
    </table>
    <!-- 分页按钮 -->
    <div id="turnPage">
        <ul class="pagination pagination;width:300px;">
            <li><a href="#" id="last_page">&laquo;上一页</a></li>
            <!-- <li id="page_1"></li>
            <li id="page_2"></li>
            <li id="page_3"></li>
            <li id="page_4"></li>
            <li id="page_5"></li> -->
            <li><a href="#" id="next_page">下一页&raquo;</a></li>
        </ul>
    </div>

    <div style="float:right;margin-top:-55px;margin-right:22px;">
        <div class="form-group" style="width:150px; float:left;">
            <input type="text" class="form-control" placeholder="跳转到页数" id="page_input">
        </div>
        &nbsp;
        <button type="button" class="btn btn-default" style="float:right;" id="turn">确定</button>
    </div>
</div>
</body>
</html>
