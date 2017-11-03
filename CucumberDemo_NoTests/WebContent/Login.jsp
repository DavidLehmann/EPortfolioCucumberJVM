<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Site</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	<jsp:useBean id="loginUser" class="de.dhbwka.application.UserBean" scope="session"></jsp:useBean>
	<h1>Login</h1>
	<c:if test="${loginUser.loginFailed}"><h3 style="color: red">Login Failed!</h3></c:if>
	<table>
		<tr>
			<td>Username: </td>
			<td><input id="usernameID" type="text" name="username" value="${loginUser.username}"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input id="passwordID" type="password" name="password" value="${loginUser.password}"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
	</form>
</body>
</html>