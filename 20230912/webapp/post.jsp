<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String a = request.getParameter("a");
	String b = request.getParameter("b");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post.jsp</title>
</head>
<body>
<h2>A: <%=a %>, B: <%=b %></h2>
</body>
</html>