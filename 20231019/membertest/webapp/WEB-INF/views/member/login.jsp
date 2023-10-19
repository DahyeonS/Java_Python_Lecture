<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>로그인</h1>
<form action="login" method="post">
<table>
<tr>
<th>아이디</th>
<td><input type="text" name="id" id="id"></td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type="password" name="pw" id="pw"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="로그인" id="submit"></td>
</tr>
</table>
</form>
</body>
</html>