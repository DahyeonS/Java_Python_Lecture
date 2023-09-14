<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request_scope_set.jsp</title>
</head>
<body>
<%
	request.setAttribute("scope", "Page");
	String scope = (String)request.getAttribute("scope");
	
	MemberDTO member = new MemberDTO("hong", "1111", "홍길동", 22);
	request.setAttribute("member", member);
%>
<jsp:forward page="request_scope_use.jsp?scope=<%=scope %>"></jsp:forward>
</body>
</html>