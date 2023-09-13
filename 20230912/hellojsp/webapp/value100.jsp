<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value = Integer.parseInt(request.getParameter("value")) / 10;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value100.jsp</title>
</head>
<body>
<h1>value100</h1>

<a href="value1000.jsp?value=<%=value*100%>">100배값: <%=value*100%>, 앞 출력의 100배 값: <%=value*1000%></a>

<form action="value1000.jsp" method="post">
100배값: <input type="text" name="value" value="<%=value*100%>" readonly="readonly">
<input type="submit" value="다음">
</form>
</body>
</html>