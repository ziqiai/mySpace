<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.demo.model.User" />
	<jsp:setProperty property="*" name="user" />
	<jsp:useBean id="userService" class="com.demo.service.UserService"></jsp:useBean>
	<%
		boolean existUser = userService.checkUsername(user);
		if (existUser) {
			out.println("<p style=\"color: red;\">User Already Existed!</p>");
		} else {
			int key = userService.insert(user);
			System.out.println("key is: " + key);
			response.sendRedirect("loginform.jsp");
		}
	%>
</body>
</html>