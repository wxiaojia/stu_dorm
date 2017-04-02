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
	<link href="css/add.css" rel="stylesheet"> 
  </head>
  
  <body background="img/bg.jpg">
 <div class="box">
   		<div id="top">
			<label>注册</label>
		</div>
	 	<form action="add" method="post">
			<div id="num">
		    	<label>编&nbsp;号：</label>
				<input type="text" class="form-control" name="id">
		    </div>
		    <br/>
		     <div id="name">
		    	<label>用户名：</label>
				<input type="text" class="form-control" name="sname">
		    </div><br/>
		    <div id="pwd">
		    	<label>密&nbsp;码：</label>
		    	<input type="password" class="form-control" name="passw">
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
		    	<!--  <button><a href="add" >提交</a></button>-->
		   	 <input type="button" class="btn btn-primary" value="提交"> 
		   		<a href="index.jsp">已有账户<br/>去登录</a>
		    </div>
   	 </form>
   	</div>
   	<script>
   		var reg=reg=/^[0-9]*$/;  
		var inputs=$("input");
		$("input[type=button]").on("click",function(){
			var num=inputs[0].value;
			var pw=inputs[2].value;
	  		if((reg.test(num)!=true)&&num.length!=0)
	  			alert("编号只能是整数");
	  		else if(pw.length!=6)
	  			alert("密码长度为6");
	  		else  {$("input[type=button]").attr('type','submit');}
		});
	//	console.log($("input[name='id']").val());
	
   	</script>
     </body>
</html>
