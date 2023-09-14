<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page_scope_use.jsp</title>
</head>
<body>
<%
	// 입력 - "page_scope_use.jsp?scope=Page"
	// 출력 - "page_scope_use.jsp?scope=Page"

	String scope = (String)pageContext.getAttribute("scope"); // null
	String scope2 = request.getParameter("scope"); // Page
%>
<%=scope %> / <%=scope2 %>
</body>
</html>