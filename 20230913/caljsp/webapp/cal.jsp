<%@page import="hellojsp.CalDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cal.jsp</title>
</head>
<body>
<%
	String a = request.getParameter("a");
	String b = request.getParameter("b");
	String sel = request.getParameter("sel");
%>
<jsp:useBean id="dto" class="hellojsp.CalDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<jsp:useBean id="cs" class="hellojsp.CalService"></jsp:useBean>
<%
	dto = cs.cal(dto);
%>

<h1>5칙연산 계산기
<form action="<%=request.getContextPath()%>/cal.jsp" method="post">
	<input type="text" name="a" required="required">
	<select name="sel">
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
		<option>%</option>
	</select>
	<input type="text" name="b">
	<input type="submit" value="계산하기" required="required">
</form>

<hr>

<% if (a != null) { %>
	Result: <%=dto.toString() %>
<% } %>

</h1>
</body>
</html>