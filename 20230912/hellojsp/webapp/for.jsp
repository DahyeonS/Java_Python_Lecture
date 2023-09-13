<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for.jsp</title>
</head>
<body>
<h1>1 ~ 10까지 출력하시오.</h1>

<% 
	int sum = 0;
	for (int i=0; i<10; i++)  sum += (i + 1);
%>

<h2>sum = <%=sum %></h2>

<hr>

<h2>for</h2>
<%	for (int i=1; i<=6; i++) { %>
		<h<%=i %>>Heading Tag <%=i %> <br></h<%=i %>>
<%	} %>
</body>
</html>