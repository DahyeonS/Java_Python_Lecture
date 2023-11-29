<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int ia = 0;
	int ib = 0;
	// 조건문이 없으면 오류 발생
	if(!(request.getParameter("aaa") == null || request.getParameter("bbb") == null)) {
		String a = request.getParameter("aaa");
		String b = request.getParameter("bbb");
		
		ia = Integer.parseInt(a);
		ib = Integer.parseInt(b);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>get.jsp</title>
</head>
<body>
<h1>
	get.jsp<br>
	보내는 페이지 or 요청(request) 페이지<br>
	<a href="get.jsp?a=10&b=20">스스로 요청</a>
</h1>
</body>
</html>