<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.quinnox.training.empcrud.dao.EmployeeDAO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>

</head>
<body>
	<jsp:useBean id="emp" class="com.quinnox.training.empcrud.model.Employee"></jsp:useBean>
	
	<jsp:setProperty property="*" name="emp"/>
	
	<%
	int i=EmployeeDAO.save(emp);
	if(i>0)
	{
	response.sendRedirect("addUserSuccess.jsp");
	}
	else {response.sendRedirect("addUserError.jsp");}
	%>
</body>
</html>