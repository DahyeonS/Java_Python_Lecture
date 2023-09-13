<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String a = request.getParameter("a");
	String b = request.getParameter("b");
%>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp</title>
</head>
<body>
<h1>b.jsp</h1>
<h2>a = <%=a %>, b = <%=b %></h2>
</body>
</html>