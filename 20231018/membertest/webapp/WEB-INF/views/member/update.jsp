<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<%@include file="loginCheck.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>회원정보수정</h1>

<form action="update" method="post">
<table>
<tr>
<th>아이디</th>
<td><input type="text" name="id" id="id" value="${id}" readonly="readonly"></td>
</tr>
<tr>
<th>이름</th>
<td><input type="text" name="name" id="name" value="${name}"></td>
</tr>
<tr>
<th>분류</th>
<c:if test="${role == 1}">
<td><input type="radio" name="role" value="1" checked="checked">일반
<input type="radio" name="role" value="0">관리자</td>
</c:if>
<c:if test="${role == 0}">
<td><input type="radio" name="role" value="1">일반
<input type="radio" name="role" value="0" checked="checked">관리자</td>
</c:if>
</tr>
<tr>
<td colspan="2"><input type="submit" value="수정하기" id="submit"></td>
</tr>
</table>
</form>
</body>
</html>