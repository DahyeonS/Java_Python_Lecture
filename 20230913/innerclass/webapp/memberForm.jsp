<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
</head>
<body>
<h1>회원가입</h1>
<form action="memberView.jsp" method="post">
ID: <input type="text" name="id" maxlength="10"> <br>
비밀번호: <input type="password" name="pw" maxlength="10"> <br>
이름: <input type="text" name="name" maxlength="10"> <br>
나이: <input type="text" name="age" maxlength="3"> <br>
<input type="submit" value="회원가입">
</form>
</body>
</html>