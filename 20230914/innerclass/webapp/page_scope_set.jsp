<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page_scope_set.jsp</title>
</head>
<body>
<%
	pageContext.setAttribute("scope", "Page");
	String scope = (String)pageContext.getAttribute("scope");
%>
<h1><a href="page_scope_use.jsp?scope=<%=scope %>"><%=scope %></a></h1>
</body>
</html>