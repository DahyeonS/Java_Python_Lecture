<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestSet.jsp</title>
</head>
<body>
<%
	request.setAttribute("scope", "Request");
%>
<jsp:forward page="requestUse.jsp"></jsp:forward>
</body>
</html>