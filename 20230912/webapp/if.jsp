<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if.jsp</title>
</head>
<body>
<h1>if문</h1>
<%
	String role = "admin";
	if (role.equals("admin")) {
		out.print("ADMIN <br>");
		out.print("<img src='./imgs/cat/cat1.jpg' alt='야옹이'>");
	}
	else {
		out.print("GUEST <br>");
		out.print("<img src='./imgs/dog/dog1.jpg' alt='멍멍이'>");
	}
%>

<hr>

<%
	role = "guest";
	if(role.equals("admin")) {
%>
		ADMIN <br>
		<img src='./imgs/cat/cat1.jpg' alt='야옹이'>
<%	} else { %>
		GUEST <br>
		<img src='./imgs/dog/dog1.jpg' alt='멍멍이'>
<%	} %>
</body>
</html>