<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.quinnox.training.empcrud.dao.EmployeeDAO,
    com.quinnox.training.empcrud.model.Employee"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<!--<jsp:useBean id="emp" class="com.quinnox.training.empcrud.model.Employee"></jsp:useBean>
	
	<jsp:setProperty property="*" name="emp"/>-->


	<%
	String email = request.getParameter("email");
	String password = request.getParameter("Pass");
	Employee emp1 = new Employee();
	emp1.setEmail(email);
	emp1.setPassword(password);
	
	boolean status = EmployeeDAO.loginEmployee(emp1);
	if (status) {
		//session.setAttribute("user", "true");
		//RequestDispatcher rd=request.getRequestDispatcher("home.html");
		//rd.forward(request, response);
		response.sendRedirect("home.html?uname="+email);
	} else 
	{
		String errMsg="Invalid_Username_Or_Password";
		response.sendRedirect("index.html?var="+errMsg);

	}
	%>



</body>
</html>