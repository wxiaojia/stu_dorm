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
		margin-top: 150px;
	}
	#top{
		font-size:35px;
		margin:50px auto;
		text-align:center;
	}
	#id,#name,#pwd,#right{
		width:330px;
		height:34px;
	}
	#id label,#name label,#pwd label,#right label{
		float:left;
		font-size:25px;
	}
	.form-control{
		font-size:15px;
		width:228px;
	}
	#submit{
		margin: 33px auto;
	    text-align: center;
	}
	option{
		font-size: 15px;
	}
	select{
		font-size:15px;
		width:228px;
	}
	a{
		float: right;
		margin-top: 8px;;
	}
	a:hover{
		text-decoration: none; 
	}
	</style>
  </head>
 
  <body background="img/bg.jpg">
   	<div class="box">
   		<div id="top">
			<label>登录</label>
		</div>
		<form action="login" method="post">
			<div id="id">
		    	<label>编&nbsp;号：</label>
				<input type="text" class="form-control" name="id">
		    </div>
		    <br/>
		     <div id="name">
		    	<label>用户名：</label>
				<input type="text" class="form-control" name="username">
		    </div><br/>
		    <div id="pwd">
		    	<label>密&nbsp;码：</label>
		    	<input type="password" class="form-control" name="password">
		    </div><br/>
		      <div id="right">
		    	<label>权&nbsp;限：</label>
				<select class="form-control" name="right">
					<option value="0">超级管理员</option>
					<option value="1">普通管理员</option>
					<option value="2">普通用户</option>
				</select>
		    </div><br/>
		    <div id="submit">
		   		<input type="button" value="提交" class="btn btn-primary"/> 
		   		<a href="add.jsp">注册</a>
		    </div>
   		</form>
   	</div>
   	<script>
   		var inputs=$("input");
   		var j=0;
		$("input[type=button]").on("click",function(){
			for(var i=0;i<inputs.length-1;i++){
				if(inputs[i].value==""){ alert("值不能为空");j=1;}
			}
			if(j==0) $("input[type=button]").attr('type','submit');
		});
   	</script>
  </body>
</html>
