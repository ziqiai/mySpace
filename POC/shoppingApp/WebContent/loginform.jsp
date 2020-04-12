<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
</head>
<body>
	<p><a href="index.jsp">GO BACK HOME PAGE</a></p>
    <div class="container">
        <div class="page-header">
			<h1>Login Here</h1>
		</div>
        <form action="login.jsp">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" size="30" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" size="30" /></td>
                </tr>
            </table>
            <p><input type="submit" value="Login" /></p>
        </form>
        <p><a href="registerform.jsp">New user? Please register first!</a></p>
    </div>
</body>
</html>