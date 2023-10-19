<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<%@include file="loginCheck.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
function deleteMember() {
	const pw = $('#pw').val();
	const param = {pw};
	console.log(param);
	$.ajax({
        type: 'POST',
        url: '../api/deleteJson',
        dataType: 'json',
        data: param,
        success: function(data) {
        	if (data['rs'] === 0) {
        		alert("비밀번호가 틀렸습니다.");
        		return;
        	} else {
        		alert("<회원 탈퇴 완료> 그동안 감사했습니다.");
        		location.href = "../";
        	}
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    });
}

$(function() {
	$('#submit').click(function() {
		deleteMember();
	});
	$('#pw').keydown(function(event) {
    	if (event.keyCode === 13) {
    		event.preventDefault();
    		const content = $('#pw').val();
    		if (content === '') {
    			alert('비밀번호를 입력해주세요.');
    			return;
    		} else deleteMember();
    	}
    });
});
</script>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>회원탈퇴</h1>

<form>
<table>
<tr>
<th>비밀번호</th>
<td><input type="password" name="pw" id="pw"></td>
</tr>
<tr>
<td colspan="2"><input type="button" value="제출하기" id="submit"></td>
</tr>
</table>
</form>
</body>
</html>