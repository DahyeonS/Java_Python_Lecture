<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewParameter.jsp</title>
</head>
<body>
<h1>EL param</h1>
<h2>
name: ${param.name} <br>
address: ${param.address}
</h2>
<hr>
<h1>EL paramValues</h1>
<h2>
${paramValues["pet"][0]} <br>
${paramValues["pet"][1]} <br>
${paramValues["pet"][2]} <br>
</h2>
</body>
</html>