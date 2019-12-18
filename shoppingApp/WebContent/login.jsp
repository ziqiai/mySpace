<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.demo.model.User" />
	<jsp:setProperty property="*" name="user" />
	<jsp:useBean id="userService" class="com.demo.service.UserService" />
	<jsp:useBean id="cartService" class="com.demo.service.CartService" />
	<%
		if (session.getAttribute("userID") != null) {
	%>
	<script type="text/javascript" language="javascript">
		alert("Already logged in!");
		window.document.location.href = "dashboard.jsp";
	</script>
	<%
		} else {
			int uid = userService.getUserId(user);
			System.out.println("uid: " + uid);
			if (uid != 0 && userService.checkPassword(user)) {
				session.setAttribute("userID", uid);
				response.sendRedirect("dashboard.jsp");
			} else {
				response.sendRedirect("error.html");
			}
		}
	%>

</body>
</html>
