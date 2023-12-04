<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String scope = (String)session.getAttribute("scope"); // Page
	String scope2 = request.getParameter("scope"); // Null
	
	if (scope == null) {
		response.sendRedirect("index.jsp");
	}
	
	MemberDTO member = (MemberDTO)session.getAttribute("member");
	
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_scope_use.jsp</title>
</head>
<body>
<%=scope %> / <%=scope2 %> <br>
<%=member %>
</body>
</html>