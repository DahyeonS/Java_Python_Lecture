<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>회원가입</h1>

<form action="join" method="post">
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
<th>비밀번호 확인</th>
<td><input type="password" name="pw2" id="pw2"></td>
</tr>
<tr>
<th>이름</th>
<td><input type="text" name="name" id="name"></td>
</tr>
<tr>
<th>분류</th>
<td><input type="radio" name="role" value="1" checked="checked">일반
<input type="radio" name="role" value="0">관리자</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="가입하기" id="submit"></td>
</tr>
</table>
</form>
</body>
</html>