<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value = Integer.parseInt(request.getParameter("value"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>value100.jsp</title>
</head>
<body>
<h1>value100</h1>

<a href="value1000.jsp?value=<%=value%>">100배값: <%=value*100%></a>
<br>앞 출력의 100배 값: <%=value*1000%>
</form>
</body>
</html>