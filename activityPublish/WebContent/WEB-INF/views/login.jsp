<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--CSS-->
<link type="text/css" href="/css/jquery-ui-1.8.5.custom.css"
	rel="stylesheet" />
<link type="text/css" media="screen" href="/css/ui.jqgrid.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/Styles/base.css" />
<link rel="stylesheet" type="text/css" href="/Styles/admin-all.css" />
<link rel="stylesheet" type="text/css" href="/Styles/bootstrap.min.css" />

<!--JS-->
<!--1.必须先引入jquery的核心库-->
<%-- <script type="text/javascript" src="/js/jquery-1.4.2.js"></script> --%>
<script type="text/javascript" src="/Scripts/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.5.custom.min.js"></script>
<!--2.按照依赖顺序,再引入jquery的插件核心库: 掌握检测文件是否正确加载-->
<script type="text/javascript" src="/Scripts/jquery.spritely-0.6.js"></script>
<script type="text/javascript" src="/Scripts/chur.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Styles/login.css" />
<!--jqGrid-->
<script type="text/javascript" src="/js/i18n/grid.locale-cn.js"></script>
<!--国际化必须放到jqGrid前-->
<script type="text/javascript" src="/js/jquery.jqGrid.min.js"></script>
<!-- <link type="text/css" media="screen" href="css/my/index.css"
	rel="stylesheet" /> -->
<script type="text/javascript" src="/js/my/login.js"></script>
<script type="text/javascript">
	//使用jquery实现异步提交  
	$(document).ready(
			function() {
				$.getJSON("registerAction.action", function(json) {
					for (i = 0; i < json.list.length; i++) {
						var tname = json.list[i];
						var tid = i;
						$("#type").append(
								"<option value='"+tid+"'>" + tname
										+ "</option>");
					}
				});

			});

	function getJson() {
		var name = $('#userName').val();
		$.ajax({
			url : "jsonDataAction.action",
			type : "post",
			dataType : "json",
			data : {
				orgName : name
			},
			success : function(data) {
				alert(data);
			}
		});
	}

	$("#type").change(function() {
		var uid = $(this).find("option:selected").val();
		alert("你选择的ID是：" + uid);
	});
</script>

</head>
<body>

    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>

    <div class="row-fluid">
        <!-- <h1>活动发布系统</h1>
        <form id="loginForm" action="loginAction" method="post">
        <p>
            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="uid" name="activityUserDTO.userName"/></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="pwd" name="activityUserDTO.password"/></label>
        </p>
        <p class="pcode">
            <label>效验码：<input type="text" id="code" maxlength="5" class="code" value="e5g88" /><img src="img/code.gif" alt="" class="imgcode" /><a href="#">下一张</a></label>
        </p>
        <p class="tip">&nbsp;</p>
        <hr />
        <input type="submit" value=" 登 录 " class="btn btn-primary btn-large login" />
        &nbsp;&nbsp;&nbsp;<input type="button" value=" 取 消 " class="btn btn-large" id='register'/>
        </form> -->
        <div id="dialog-form" title="创建新用户">
			<p class="validateTips">所有的表单字段都是必填的。</p>
			<form id="dialogForm">
				<fieldset>
					<div class="form-group">
						<label for="type">类型</label>
						<div id="userType">
							<select style="padding:5px" id="type" name="type">
							</select>
						</div>
					</div>
					<div>
						<label for="userName">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="text ui-widget-content ui-corner-all"
								name="userName" id="userName" value=""
								onchange="getJson();" />
						</div>
					</div>
					<div>
						<label for="password">密码</label>
						<div class="col-sm-10">
							<input type="password" class="text ui-widget-content ui-corner-all"
								name="password" id="password" value="" />
						</div>
					</div>
					<div>
						<label for="email">邮箱</label>
						<div class="col-sm-10">
							<input type="text" class="text ui-widget-content ui-corner-all"
								name="email" id="email" value="" />
						</div>
					</div>
					<div>
						<label for="unit">单位</label>
						<div class="col-sm-10">
							<input type="text" class="text ui-widget-content ui-corner-all"
								name="unit" id="unit" value=""/>
						</div>
					</div>
				</fieldset>
			</form>
    </div>

<!-- 	<div class="login"> 
 	<h2>活动系统</h2>
		<div class="login-top">
			<h1>用户登录</h1>
			<form id="loginForm" action="loginAction" method="post">
				用户名<input type="text" name="activityUserDTO.userName" />
				<div>
					密码<input type="password" name="activityUserDTO.password" />
				</div>
				<div class="forgot">
					<a href="#">忘记密码</a> <input type="submit" value="登录" />
				</div>
			</form>
		</div>
		<div class="login-bottom">
			<h3>
				新用户 &nbsp;<a id="register">注册</a>
			</h3>
		</div>
		</div>
	</div>
	<div class="copyright">
		<p>Copyright &copy; 2015.BNUZ</p>
	</div> -->

</body>
</html>