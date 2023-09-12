<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String result = null;
	String sel = request.getParameter("sel");
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	if (sel.equals("+")) result = num1 + " + " + num2 + " = " + Integer.toString(num1 + num2);
	else if (sel.equals("-")) result = num1 + " - " + num2 + " = " + Integer.toString(num1 - num2);
	else if (sel.equals("*")) result = num1 + " * " + num2 + " = " + Integer.toString(num1 * num2);
	else if (sel.equals("/")){
		if (num2 != 0) result = num1 + " / " + num2 + " = " + Double.toString((double)(num1) / num2);
		else result = "ERROR!!";
	}
	else if (sel.equals("%")){
		if (num2 != 0) result = num1 + " % " + num2 + " = " + Integer.toString(num1 % num2);
		else result = "ERROR!!";
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>calResult.jsp</title>
</head>
<body>
<h1>
Result: <%=result %>
</h1>
</body>
</html>