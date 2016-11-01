<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<title>springmvc论坛登陆</title>
<link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="sui-container">

		<div class="sui-row">
			<div class="span4"></div>
			<div class="span4">
				<br> <br>
				<form class="sui-form form-horizontal " action="loginCheck"
					method="post">
					<div class="control-group">
						<label for="inputuserName" class="control-label">用户名：</label>
						<div class="controls">
							<input type="text" name="userName">
						</div>
					</div>
					<div class="control-group">
						<label for="inputPassword" class="control-label">密码：</label>
						<div class="controls">
							<input type="password" name="password">
						</div>
					</div>
					<c:if test="${!empty error}">

						<div class="control-group error">
							<label class="control-label"></label>
							<div class="controls">
								<span class="help-inline"><c:out value="${error}" /></span>
							</div>
						</div>

					</c:if>

					<div class="control-group">
						<label class="control-label"></label>
						<div class="controls">
							<button type="submit" class="sui-btn btn-primary">登陆</button>
							<button type="submit" class="sui-btn btn-warning">重置</button>
						</div>
					</div>
				</form>
			</div>

		</div>
		<div class="span4"></div>
	</div>
	</div>
</body>
<script type="text/javascript"
	src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
</html>