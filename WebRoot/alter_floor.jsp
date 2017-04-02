<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.floor"%>
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
	#id,#num,#position{
		width:330px;
		height:34px;
	}
	#id label,#num label,#position label{
		float:left;
		font-size:25px;
	}
	.form-control{
		font-size:25px;
		width:228px;
	}
	#submit{
		margin: 33px auto;
	    text-align: center;
	}
	</style>

  </head>
  
  <body background="img/bg.jpg">
    	<%  floor floor = (floor)session.getAttribute("alter");
  			int id=floor.getId();
			int num=floor.getNum(); 
			String position=floor.getPosition();
			pageContext.setAttribute("id", id);
	    	pageContext.setAttribute("num", num);
	    	pageContext.setAttribute("position", position);
 		%>
    	<div class="box">
   		<div id="top">
			<label>修改宿舍楼信息</label>
		</div>
		<form action="alterMesg_floor" method="post">
			<div id="id">
		    	<label>编&nbsp;号：</label>
				<input type="text" class="form-control" name="id" value="${id}" readonly="readonly">
		    </div>
		    <br/>
		     <div id="num">
		    	<label>宿舍数：</label>
				<input type="text" class="form-control" name="num" value="${num}">
		    </div><br/>
		    <div id="position">
		    	<label>位&nbsp;置：</label>
		    	<input type="text" class="form-control" name="position" value="${position}">
		    </div>
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
