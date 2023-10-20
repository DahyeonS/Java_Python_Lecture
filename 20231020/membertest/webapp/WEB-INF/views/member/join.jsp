<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
function idCheck() {
	const id = $('#id').val();
	const param = {id};
	$.ajax({
        type: 'POST',
        url: '../mx/idCheckJson',
        dataType: 'json',
        data: param,
        success: function(data) {
        	if (data['rs'] === 1) {
        		$('#success').hide();
        		$('#fail').show();
        	} else {
        		$('#success').show();
        		$('#fail').hide();
        	}
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    });
}

$(function() {
	$('#success').hide();
	$('#fail').hide();
	$('#check').click(function() {
		idCheck();
	});
});
</script>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>회원가입</h1>

<form action="join" method="post">
<table>
<tr>
<th>아이디</th>
<td><input type="text" name="id" id="id"></td>
<td><input type="button" id="check" value="중복확인" style="margin-left: 20px"></td>
</tr>
<tr id="fail">
<th>&nbsp</th>
<td>중복된 아이디입니다.</td>
</tr>
<tr id="success">
<th>&nbsp</th>
<td>사용할 수 있는 아이디입니다.</td>
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
<th colspan="2">&nbsp</th>
<td><input type="submit" value="가입하기" id="submit" style="margin-left: 20px"></td>
</tr>
</table>
</form>
</body>
</html>