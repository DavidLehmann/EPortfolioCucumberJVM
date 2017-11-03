<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temp Calculator</title>
</head>
<body>
	<jsp:useBean id="loginUser" class="de.dhbwka.application.UserBean"
		scope="session"></jsp:useBean>
		<jsp:useBean id="calc" class="de.dhbwka.application.CalculationBean"
		scope="request"></jsp:useBean>
		<form action="Login.jsp">
		<h1>Temperature Calculator</h1>
		<table>
			<tr>
				<td><h3>Logged in as: ${loginUser.username}</h3></td>
				<td><input id="logoutID" type="submit" value="Logout"></td>
			</tr>
			<tr>
				<c:choose>
			<c:when test="${loginUser.admin}">
				<h3 id="userLevel">Administrator</h3>
			</c:when>
			<c:otherwise>
				<h3 id="userLevel">User</h3>
			</c:otherwise>
				</c:choose>
			</tr>
		</table>
		</form>
		<form action="TempCalculatorServlet" method="get">
		<table>
			<thead>
				<tr>
					<td>Celcius</td>
					<td>Farenheit</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="celciusInputID" type="number" value="${calc.celcius}" name="celcius" ></td>
					<td><input id="fahrenheitOutputID" type="number" name="farenheit" disabled="disabled" value="${calc.farenheit}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="calculateID" type="submit" value="Calculate"></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${calc.calcError}">
							<div id="calcSuccessfulID" style="color: red">Calculation Error!</div>
						</c:when>
						<c:otherwise>
							<div id="calcSuccessfulID"></div>
						</c:otherwise>
					</c:choose>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>