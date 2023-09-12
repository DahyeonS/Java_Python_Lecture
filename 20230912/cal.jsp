<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = null;
	String sel = request.getParameter("sel");
	String snum1 = request.getParameter("num1");
	String snum2 = request.getParameter("num2");
	
	if(snum1 != null && snum2 != null) {
		int num1 = Integer.parseInt(snum1);
		int num2 = Integer.parseInt(snum2);
		
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
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cal.jsp</title>
</head>
<body>
<h1>
<form>
	<input type="text" name="num1" required="required">
	<select name="sel">
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
		<option>%</option>
	</select>
	<input type="text" name="num2">
	<input type="submit" value="계산하기" required="required">
</form>

<hr>

Result: <%=result %>
</h1>
</body>
</html>