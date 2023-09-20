<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck.jsp</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
function getMemberAjax(id) {
	$.ajax({
		contentType: 'application/json',
		type: 'GET',
		url: 'getMemberJson.jsp',
		data: {id:id},
		dataType: 'json',
		success: function(response) {
			console.log(response);
			if(response['rs'] === '0') {
				$('#use').show();
				$('#notuse').hide();
			} else {
				$('#notuse').show();
				$('#use').hide();
			}
		},
		error: function(xhr, status, error) {
			console.log(xhr, status, error);
		}
	});
};

$(function name() {
	$('#notuse').hide();
	$('#use').hide();
	$('#checkBtn').on('click', function() {
		getMemberAjax($('#id').val());
	});
});
</script>
</head>
<body>
<h1>
<form name="joinForm" action="getMemberJson.jsp" method="post">
	<table border="1">
		<tr><th>ID</th>
		<td>
		<input type="text" name="id" id="id">
		<input type="button" value="Check ID" id="checkBtn">
		</td></tr>
		<tr id="notuse"><td colspan="2">존재하는 ID입니다.</td></tr>
		<tr id="use"><td colspan="2">사용가능 ID입니다.</td></tr>
		<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
	</table>
</form>
</h1>
</body>
</html>