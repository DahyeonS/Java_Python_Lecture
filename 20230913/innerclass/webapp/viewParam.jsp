<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String pets[] = request.getParameterValues("pet");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewParam.jsp</title>
</head>
<body>
<h1>한글 처리</h1>
<h2>
Name: <%=name %> <br>
Address: <%=address %> <br>
<ul>
	좋아하는 동물
	<% for (String pet : pets) { %>
		<li><%=pet %></li>
	<% } %>
</ul>

</h2>
</body>
</html>