<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
	function idCheck(param) {
		const params = {id:param}
	    $.ajax({
	        contentType: 'application/json',
	        type: 'GET',
	        url: 'getMemberJson.jsp',
	        data: {id:id},
	        dataType: 'json',
	        success: function(data) {
		        let td = '';
		        if(data['rs'] === '1') {
	   				$('#success').hide();
	    	        $('#fail').show();
	            	td = '<td colspan="2">사용불가능한 아이디입니다.</td>';
	            	$('#fail').html(td);
	            } else {
	    			$('#fail').hide();
	            	$('#success').show();
	            	td = '<td colspan="2">사용가능한 아이디입니다.</td>';
	            	$('#success').html(td);
	            }
	        },
	        error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
	    });
	};
	
	$(function idCheck() {
		$('#check').click(function() {
			const idInput = id.value;
			console.log(ipInput);
			if(idInput === '') {
				alert('id는 필수값입니다.');
				form.id.focus();
				return;
			}
			idCheck(idInput);
		});
	});
</script>
</head>
<body>
<%@include file="topmenu.jsp" %>
<h2>회원가입</h2>
<hr>
<form action="joinProc" method="post">
	<table border="1">
		<tr><th>ID</th>
		<td>
		<input type="text" name="id" id="id">
		<input id="check" type="button" value="ID Check">
		</td></tr>
		
		<tr id="success"></tr>
		<tr id="fail"></tr>
		<tr><th>PW</th><td><input type="password" name="pw"></td></tr>
		<tr><th>PW2</th><td><input type="password" name="pw2"></td></tr>
		<tr><th>Name</th><td><input type="text" name="name"></td></tr>
		<tr><th>Age</th><td><input type="text" name="age"></td></tr>
		<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
	</table>
</form>
</body>
</html>