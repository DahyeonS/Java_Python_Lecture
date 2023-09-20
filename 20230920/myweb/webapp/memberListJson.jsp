<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.getMemberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberListJson.jsp</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script>
	function getJson(param) {
	    $.ajax({
	        contentType: 'application/json',
	        type: 'GET',
	        url: 'memberListData.do',
	        dataType: 'json',
	        success: function(data) {
	            // for (item of data) console.log(item);
		        let tr = '';
	            for (item of data) {
		            const {idx, id, pw, name, age, regdate} = item;
		            tr += '<tr style="text-align: center;"><td>' + idx + '</td><td>' + id + '</td><td>' + pw + '</td><td>' + name + '</td><td>' + age + '</td><td>' + regdate + '</td></tr>';
	            }
	            $('#tbody').html(tr);
	        },
	        error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
	    });
	};
	
	function memberSearch() {
		const name = $('#name').val();
		const param = {name};
		console.log(param);
		$.ajax({
			contentType: 'application/json',
	        type: 'GET',
	        url: 'getMemberNameJson.do',
	        dataType: 'json',
	        data: param,
	        success: function(data) {
	        	let tr = '';
	        	for (item of data) {
		            const {idx, id, pw, name, age, regdate} = item;
		            tr += '<tr style="text-align: center;"><td>' + idx + '</td><td>' + id + '</td><td>' + pw + '</td><td>' + name + '</td><td>' + age + '</td><td>' + regdate + '</td></tr>';
	            }
	            $('#tbody').html(tr);
	        }, error: function(xhr, status, error) {
	        	console.log(xhr, status, error);
	        }
		});
	};
	
	$(function() {
    	getJson();
    	
    	$('#search').click(function() {
    		memberSearch();
    	});
    });
</script>
</head>
<body>
<%@include file="topmenu.jsp" %>
<h2>회원목록</h2>
<hr>
<table border="1">
<thead>
<tr>
	<th>Idx</th>
	<th>ID</th>
	<th>PW</th>
	<th>Name</th>
	<th>Age</th>
	<th>Regdate</th>
</tr>
</thead>
<tbody id="tbody">

</tbody>
</table>
<form>
	<table border="1">
	<tr><th>이름으로 회원검색</th>
	<td><input type="text" name="name" id="name"></td>
	<td><input type="button" value="검색" id="search"></tr>
	</table>
</form>
</body>
</html>