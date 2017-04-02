<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		body{
	margin:0;
	padding:0;
	font-family: "宋体";
}
.box{
	width:330px;
	margin:0 auto;
	margin-top: 120px;
}
#top{
	font-size:35px;
	margin:20px auto;
	text-align:center;
}
.form-control{
	font-size:15px;
	width:228px;
	margin:0 auto;
}

	</style>
  </head>
  
  <body background="img/bg.jpg">
 <div class="box">
   		<div id="top">
			<label>查询</label>
		</div>
	 	<form action="find_floor" method="post">
		    <input type="text" class="form-control" name="id">
   		   <input type="submit" class="btn btn-default" style="float:right"  value="确定"></input>
   		 </form>
   	</div>
     </body>
</html>
