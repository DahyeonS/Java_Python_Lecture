<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_scope_set.jsp</title>
</head>
<body>
<%
	session.setAttribute("scope", "Page");
	String scope = (String)session.getAttribute("scope");
	
	MemberDTO member = new MemberDTO("hong", "1111", "홍길동", 22);
	session.setAttribute("member", member);
%>
<h1><a href="session_scope_use.jsp?scope="><%=scope %></a></h1>
</body>
</html>