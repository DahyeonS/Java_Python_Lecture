<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
function memberList() {
	const params = {};
	$.ajax({
        type: 'GET',
        url: '../api/memberListJson',
        dataType: 'json',
        data: params,
        success: function(data) {
        	const rs = data['rs'];
        	if (rs !== 0) {
        		console.log(rs);
        		$('#resultView').text(` : ${'${rs.length}'}명`);
        		memberShow(rs);
        	}
        	else {
        		$('#resultView').text(' : 0명');
            	return;
        	}
        },
        error: function(xhr, status, error) {
            console.log(xhr, status, error);
        }
    });
};

function memberShow(rs) {
	let tr = ``;
	for(item of rs){
		const idx = item['idx'];
		const id = item['id'];
		const pw = item['pw'];
		const name = item['name'];
		const role = item['role'];
		const regdate = item['regdate'];
		tr += `
		<tr>
		<td>${ '${idx}' }</td>
		<td>${ '${id}' }</td>
		<td>${ '${pw}' }</td>
		<td>${ '${name}' }</td>`;
		if (role === '1') tr += `<td>일반</td>`;
		else tr += `<td>관리자</td>`;
		tr += `<td>${ '${regdate}' }</td>
		</tr>`;    		
	}
	$('tbody').html(tr);
};

$(function() {
	memberList();
});
</script>
</head>
<%@include file="../topmenu.jsp"%>
<body>
<h1>회원목록</h1>

<h2>현재 회원 수<span id="resultView" style="color:red;"></span></h2>
<table border="1">
<thead>
<tr>
<th>일련번호</th>
<th>아이디</th>
<th>비밀번호</th>
<th>이름</th>
<th>등급</th>
<th>가입일자</th>
</tr>
</thead>
<tbody>
</tbody>
</table>
</body>
</html>