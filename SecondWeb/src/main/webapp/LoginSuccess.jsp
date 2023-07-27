<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:50px">
	<div class="container">
	<h2 style="color: lightseagreen;">Your Home Page </h2>
	<hr><br>
    Welcome <%=session.getAttribute("uid") %>
    <br>
    <a href="/">Home</a>
    </div>
</body>
</html>