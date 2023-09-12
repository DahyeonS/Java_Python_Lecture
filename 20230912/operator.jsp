<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operator.jsp</title>
</head>
<body>
<h1>연산자</h1>

<%
	int a = 10;
	int b = 10;
%>

<ul>
<h2>산술 연산자</h2>
<li>a + b = <%=a+b%></li>
<li>a - b = <%=a-b%></li>
<li>a * b = <%=a*b%></li>
<li>a % b = <%=a%b%></li>
</ul>

<ul>
<h2>비교 연산자</h2>
<li>a == b = <%=a==b%></li>
<li>a >= b = <%=a>=b%></li>
<li>a > b = <%=a>b%></li>
<li>a <= b = <%=a<=b%></li>
<li>a < b = <%=a<b%></li>
<li>a != b = <%=a!=b%></li>
</ul>

<ul>
<h2>논리 연산자</h2>
<li>a == b && a <= b = <%=a == b && a <= b%></li>
<li>a == b || a <= b = <%=a == b || a <= b%></li>
<li>!(a == b) = <%=!(a == b)%></li>
</ul>

</body>
</html>