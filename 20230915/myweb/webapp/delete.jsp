<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="loginCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
</head>
<body>
<%@include file="topmenu.jsp" %>
<h2>회원탈퇴</h2>
<hr>
<form action="deleteProc.jsp" method="post">
	<table border="1">
		<tr><th>ID</th><td><input type="text" name="id"></td></tr>
		<tr><th>PW</th><td><input type="password" name="pw"></td></tr>
		<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
	</table>
</form>
</body>
</html>