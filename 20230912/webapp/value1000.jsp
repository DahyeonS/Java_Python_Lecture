<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value = Integer.parseInt(request.getParameter("value")) / 100;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value1000.jsp</title>
</head>
<body>
<h1>value1000</h1>

<a href="value01.jsp?value=<%=value*1000%>">1000배값: <%=value*1000%>, 앞 출력의 1000배 값: <%=value*100000%></a>

<form action="value01.jsp" method="post">
1000배값: <input type="text" name="value" value="<%=value*1000%>" readonly="readonly">
<input type="submit" value="돌아가기">
</form>
</body>
</html>