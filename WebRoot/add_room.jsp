<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="User.room"%>
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
	#id,#floor,#bed,#price,#people,#floor_id{
		width:330px;
		height:34px;
	}
	#id label,#floor label,#bed label,#price label,#people label,#floor_id label{
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
  
  </head>
  <% 
  	 pageContext.setAttribute("floor_id", request.getAttribute("floor_id"));		
  %>
  <body background="img/bg.jpg">
    	<div class="box">
   		<div id="top">
			<label>添加房间信息</label>
		</div>
		<form action="add_room" method="post">
			<div id="id">
		    	<label>编&nbsp;号：</label>
				<input type="text" class="form-control" name="id">
		    </div>
		    <br/>
		     <div id="floor">
		    	<label>楼&nbsp;层：</label>
				<input type="text" class="form-control" name="floor">
		    </div><br/>
		    <div id="bed">
		    	<label>床&nbsp;位：</label>
		    	<input type="text" class="form-control" name="bed">
		    </div><br/>
		     <div id="price">
		    	<label>单&nbsp;价：</label>
		    	<input type="text" class="form-control" name="price">
		    </div><br/>
		      <div id="people">
		    	<label>人&nbsp;数：</label>
		    	<input type="text" class="form-control" name="people">
		    </div><br/>
		    <div id="floor_id">
		    	<label>楼&nbsp;号：</label>
		    	<input type="text" class="form-control" name="floor_id" value="${floor_id}" readonly="readonly">
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
			for(var i=0;i<=4;i++){
				if(inputs[i].value==""){ alert("值不能为空");j=1;}
			}
			if(j==0) $("input[type=button]").attr('type','submit');
		});
   	</script>
  </body>
</html>
