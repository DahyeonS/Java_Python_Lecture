<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value = Integer.parseInt(request.getParameter("value"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value10.jsp</title>
</head>
<body>
<h1>value10</h1>

<a href="value100.jsp?value=<%=value*10%>">10배값: <%=value*10%></a>

<form action="value100.jsp" method="post">
10배값: <input type="text" name="value" value="<%=value*10%>" readonly="readonly">
<input type="submit" value="다음">
</form>
</body>
</html>