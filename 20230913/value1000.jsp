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

<a href="value01.jsp?value=<%=value%>">1000배값: <%=value*1000%></a>
<br>앞 출력의 1000배 값: <%=value*100000%>
</form>
</body>
</html>