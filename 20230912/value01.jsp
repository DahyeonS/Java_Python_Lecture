<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String value = request.getParameter("value");
	int v1 = 0;
	if (value != null) {
		v1 = Integer.parseInt(value) / 1000;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value01.jsp</title>
</head>
<body>
<h1>value01</h1>

<form action="value10.jsp" method="get">
값 입력: <input type="text" name="value">
<input type="submit" name="제출">
</form>

<br>

<% if (value != null) { %>
	최초입력값: <%=v1 %>
<% } %>
</body>
</html>
