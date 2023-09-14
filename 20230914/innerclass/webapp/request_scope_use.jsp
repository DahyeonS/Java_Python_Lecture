<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request_scope_use.jsp</title>
</head>
<body>
<%
	// 입력 - "page_scope_use.jsp?scope=Page"
	// 출력 - "request_scope_set.jsp"

	String scope = (String)request.getAttribute("scope"); // Page
	String scope2 = request.getParameter("scope"); // null
	
	MemberDTO member = (MemberDTO)request.getAttribute("member");
%>
<%=scope %> / <%=scope2 %> <br>
<%=member %>
</body>
</html>