<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.quinnox.training.empcrud.dao.EmployeeDAO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<jsp:useBean id="u" class="com.quinnox.training.empcrud.model.Employee"></jsp:useBean>
	<jsp:setProperty property="*" name="u" />
	<%
	EmployeeDAO.deleteUser(u);
	response.sendRedirect("ViewServlet");
	%>
</body>
</html>