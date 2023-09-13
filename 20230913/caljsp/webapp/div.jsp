<%@page import="hellojsp.CalService"%>
<%@page import="hellojsp.CalDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sel = request.getParameter("sel");
	String snum1 = request.getParameter("num1");
	String snum2 = request.getParameter("num2");
	
	CalDTO dto = null;
	CalService cs = new CalService();
	
	if (snum1 != null && snum2 != null) {
		int a = Integer.parseInt(snum1);
		int b = Integer.parseInt(snum2);
		dto = new CalDTO(a, b, 0, sel);
		dto = cs.cal(dto);
	} else {
		dto = new CalDTO();
		dto = cs.cal(dto);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
</head>
<body>
<%@include file="menu.jsp" %>

<h1>나누기
<form>
	<input type="text" name="num1" required="required">
	<select name="sel">
		<option>/</option>
	</select>
	<input type="text" name="num2">
	<input type="submit" value="계산하기" required="required">
</form>

<hr>

<% if (snum1 != null) { %>
	Result: <%=dto %>
<% } %>


</h1>
</body>
</html>