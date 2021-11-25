<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

	<%
		session.invalidate();
	%>
	<h1>Logout Successfully</h1>
	<jsp:include page="index.html"></jsp:include>
</body>
</html>