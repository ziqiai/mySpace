<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to my Shopping Cart!</title>
</head>
<body>
<h2>Enjoy Your Shopping!</h2>
<p><a href="loginform.jsp">Please Login</a></p>
<p><a href="registerform.jsp">Register Here</a></p>
<%
	Integer uid = (Integer) request.getSession().getAttribute("userID");
	System.out.println("SessionID:" + uid);
%>
</body>
</html>