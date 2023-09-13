<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value = Integer.parseInt(request.getParameter("value"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value1000.jsp</title>
</head>
<body>
<h1>value1000</h1>

<form action="value01.jsp" method="post">
1000배값: <input type="text" name="value" value="<%=value*10%>" readonly="readonly">
<input type="submit" value="돌아가기">
</form>
</body>
</html>