<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<link type="text/css" href="/css/jquery-ui-1.8.5.custom.css"
	rel="stylesheet" />
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//使用jquery实现异步提交  
	function getJson() {
	/* 	$.post("jsonDateAction.action", {}, function(data, status) {
			if ("success" == status) {
				alert(data);
			}
		}) */
		var name=$('#userName').val();
		 $.ajax({
	            url: "jsonDataAction.action",
	            // 数据发送方式
	            type: "post",
	            // 接受数据格式
	            dataType : "json",
	            // 要传递的数据
	            data : {orgName : name},
	            // 回调函数，接受服务器端返回给客户端的值，即result值
	            success : function (data) {
	                //返回的数据用data.d获取内容      
	                alert(data);
	             }  
	        });
	}
</script>
<style type="text/css">
.col-sm-2 {
	width: 120px;
}

.form-control {
	width: 400px;
	margin-left: 20px;
	margin-right: auto
}

form {
	width: 700px;
	margin-left: auto;
	margin-right: auto
}
</style>
</head>
<body>
	<h1 align="center">用户注册</h1>
	<form action="saveRegisterAction" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="userType" class="col-sm-2 control-label">类型</label>
			<div class="col-sm-10" id="userType">
				<s:select class="form-control" name="activityUserDTO.type"
					list="%{#request.list}" />
			</div>
		</div>
		<div class="form-group">
			<label for="userName" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
				<s:textfield class="form-control" name="activityUserDTO.userName"
					id="userName" value="" onchange="getJson();"/>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<s:password class="form-control" name="activityUserDTO.password"
					id="password" value="" />
			</div>
		</div>
		<div class="form-group">
			<label for="unit" class="col-sm-2 control-label">单位</label>
			<div class="col-sm-10">
				<s:textfield class="form-control" name="activityUserDTO.unit"
					id="unit" />
			</div>
		</div>
		<div class="form-group">
			<div align="center" class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Submit" class="btn btn-default"/>
			</div>
		</div>
	</form>
</body>
</html>