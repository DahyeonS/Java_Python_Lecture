<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
<form action="viewParam.jsp" method="post">
Name: <input type="text" name="name" size="10" maxlength="10"><br>
Address: <input type="text" name="address" size="30"><br>
좋아하는 동물: 
<input type="checkbox" name="pet" value="강아지">강아지
<input type="checkbox" name="pet" value="고양이">고양이
<input type="checkbox" name="pet" value="송아지">송아지<br>
<input type="submit" value="Submit">
</form>
</body>
</html>