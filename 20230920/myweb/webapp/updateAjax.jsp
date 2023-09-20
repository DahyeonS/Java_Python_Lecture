<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="loginCheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("id");

	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	
	MemberDAO dao = new MemberDAO();
	dto = dao.getMember(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateAjax.jsp</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
	function updateJson() {
		const id = $('#id').val();
		const pw = $('#pw').val();
		const name = $('#name').val();
		const age = $('#age').val();
		const param = {id, pw, name, age};
		$.ajax({
	        type: 'POST',
	        url: 'updateJson.do',
	        dataType: 'json',
	        data: param,
	        success: function(data) {
	        	if(data['rs'] === 1) {
	        		alert('회원정보가 수정되었습니다.');
	        	} else {
	        		alert('죄송합니다. 다시 시도해주세요.');
	        	}
	        }, error: function(xhr, status, error) {
	        	console.log(xhr, status, error);
	        }
		});
	};
	
	$(function() {
		$('#submit').click(function() {
			updateJson();
		});
	});
</script>
</head>
<body>
<%@include file="topmenu.jsp" %>
<h2>회원정보 수정</h2>
<hr>
<form action="updateProc" method="post">
	<table border="1">
		<tr><th>ID</th><td><input type="text" name="id" value="<%=dto.getId()%>" id="id" readonly="readonly"></td></tr>
		<tr><th>PW</th><td><input type="text" name="pw" value="<%=dto.getPw()%>" id="pw"></td></tr>
		<tr><th>Name</th><td><input type="text" name="name" value="<%=dto.getName()%>" id="name"></td></tr>
		<tr><th>Age</th><td><input type="text" name="age" value="<%=dto.getAge()%>" id="age"></td></tr>
		<tr><td colspan="2"><input type="button" value="수정하기" id="submit"></td></tr>
	</table>
</form>
</body>
</html>