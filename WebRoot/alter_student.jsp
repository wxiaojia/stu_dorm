<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.students"%>
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
		margin-top: 60px;
	}
	#top{
		font-size:35px;
		margin:20px auto;
		text-align:center;
	}
	#id,#name,#age,#sex,#phone,#grade,#sub,#room{
		width:330px;
		height:34px;
	}
	#id label,#name label,#age label,#sex label,#phone label,#grade label,#sub label,#room label{
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
	</style>

  </head>
  
  <body background="img/bg.jpg">
    	<% students student = (students)session.getAttribute("alter");
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
    	<div class="box">
   		<div id="top">
			<label>修改学生信息</label>
		</div>
		<form action="alterMesg_student" method="post">
			<div id="id">
		    	<label>学&nbsp;号：</label>
				<input type="text" class="form-control" name="id" value="${id}" readonly="readonly">
		    </div>
		    <br/>
		     <div id="name">
		    	<label>姓&nbsp;名：</label>
				<input type="text" class="form-control" name="name" value="${name}">
		    </div><br/>
		    <div id="age">
		    	<label>年&nbsp;龄：</label>
		    	<input type="text" class="form-control" name="age" value="${age}">
		    </div><br/>
		    <div id="sex">
		    	<label>性&nbsp;别：</label>
		    	<select class="form-control" name="sex">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
		    </div><br/>
		    <div id="phone">
		    	<label>电&nbsp;话：</label>
		    	<input type="text" class="form-control" name="phone" value="${phone}">
		    </div><br/>
		    <div id="grade">
		    	<label>年&nbsp;级：</label>
		    	<input type="text" class="form-control" name="grade" value="${grade}">
		    </div><br/>
		    <div id="sub">
		    	<label>专&nbsp;业：</label>
		    	<input type="text" class="form-control" name="sub" value="${sub}">
		    </div><br/>
		    <div id="submit">
		   		<input type="button" value="提交" class="btn btn-primary"/> 
		    </div>
   		</form>
   	</div>
   	<script>
   		var inputs=$("input");
   		var j=0;
		$("input[type=button]").on("click",function(){
			for(var i=1;i<=2;i++){
				if(inputs[i].value==""){ alert("值不能为空");j=1;}
			}
			if(j==0) $("input[type=button]").attr('type','submit');
		});
   	</script>
  </body>
</html>
