<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionSet.jsp</title>
</head>
<body>
<%
	session.setAttribute("scope", "Session");
%>
<a href="sessionUse.jsp">session use</a>
</body>
</html>