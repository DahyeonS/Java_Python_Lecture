<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewHeaderList.jsp</title>
</head>
<body>
<h1>Request Header Info</h1>
<h2>
<%
	Enumeration<String> hn = request.getHeaderNames();
	while(hn.hasMoreElements()) {
		String se = hn.nextElement();
		String header = request.getHeader(se);
		out.print(se + "/" + header + "<br>");
	}
%>
</h2>
</body>
</html>