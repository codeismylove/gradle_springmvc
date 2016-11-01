<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success JSP Page</title>
</head>
<body>
	<h1>Action Success!!!</h1>
	<h1>Id:<s:property value="id" /></h1>
	<h1>User Name:<s:property value="userName" /></h1>
	<h1>Password:<s:property value="password" /></h1>
</body>
</html>