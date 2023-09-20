<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinAjax.jsp</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
	function idCheck(param) {
	    $.ajax({
	        contentType: 'application/json',
	        type: 'GET',
	        url: 'getMemberJson.jsp',
	        data: {id:param},
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
	
	function join(params) {
		$.ajax({
	        type: 'POST',
	        url: 'joinJson.jsp',
	        dataType: 'json',
	        data: params,
	        success: function(data) {
	        	if(data['rs'] === 1) {
	        		alert('회원가입을 축하드립니다!');
	        		location.href = 'login.jsp';
	        	} else {
	        		alert('다시 시도해주세요.');
	        	}
	        }, error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
		});
	};
	
	$(document).ready(function() {
		$('#check').click(function() {
			const idInput = $('#id').val();
			if(idInput === '') {
				alert('id는 필수값입니다.');
				$('#id').focus();
				return;
			}
			idCheck(idInput);
		});
		
		$('#submit').click(function() {
			const idInput = $('#id').val();
			if(idInput === '') {
				alert('id는 필수값입니다.');
				$('#id').focus();
				return;
			}
			const pwInput = $('#pw').val();
			if(pwInput === '') {
				alert('pw는 필수값입니다.');
				$('#pw').focus();
				return;
			}
			const pw2Input = $('#pw2').val();
			if(pw2Input === '') {
				alert('pw2는 필수값입니다.');
				$('#pw2').focus();
				return;
			} else if (pwInput !== pw2Input) {
				alert('pw과 pw2는 같아야합니다.');
				$('#pw2').focus();
				return;
			}
			const nameInput = $('#name').val();
			if(nameInput === '') {
				alert('name은 필수값입니다.');
				$('#name').focus();
				return;
			}
			const ageInput = $('#age').val();
			if(ageInput === '') {
				alert('age는 필수값입니다.');
				$('#age').focus();
				return;
			}
			//const params = {id, pw, name, age};
			const params = {id:idInput, pw:pwInput, name:nameInput, age:ageInput};
			join(params);
		});
	});
</script>
</head>
<body>
<%@include file="topmenu.jsp" %>
<h2>회원가입(JSON)</h2>
<hr>
<form name="joinForm" method="post">
	<table border="1">
		<tr><th>ID</th>
		<td>
		<input type="text" name="id" id="id">
		<input id="check" type="button" value="ID Check">
		</td></tr>
		
		<tr id="success"></tr>
		<tr id="fail"></tr>
		<tr><th>PW</th><td><input type="password" name="pw" id="pw"></td></tr>
		<tr><th>PW2</th><td><input type="password" name="pw2" id="pw2"></td></tr>
		<tr><th>Name</th><td><input type="text" name="name" id="name"></td></tr>
		<tr><th>Age</th><td><input type="text" name="age" id="age"></td></tr>
		<tr><td colspan="2"><input id="submit" type="button" value="회원가입"></td></tr>
	</table>
</form>
</body>
</html>