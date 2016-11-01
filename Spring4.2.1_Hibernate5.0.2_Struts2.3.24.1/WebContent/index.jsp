<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index JSP Page</title>
</head>
<body>
	<h1>Demo 01</h1>
	<s:form action="saveUserAction" >  
		<s:textfield name="userName" label="User Name" />       
		<s:textfield name="password" label="Password" />        
		<s:submit />     
	</s:form> 
</body>
</html>