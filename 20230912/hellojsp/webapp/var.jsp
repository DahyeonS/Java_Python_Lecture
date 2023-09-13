<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수간 값 바꾸기</title>
</head>
<body>
<%
	int a = 10;
	int b = 20;
	int temp = 0;
%>

<h2>
Before: a = <%=a %>, b = <%=b %>
</h2>

<%
	temp = a;
	a = b;
	b = temp;
%>

<h2>
After: a = <%=a %>, b = <%=b %>
</h2>
</body>
</html>