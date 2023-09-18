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
	        url: 'memberListData.jsp',
	        dataType: 'json',
	        success: function(data) {
	            console.log(data);
	        },
	        error: function(xhr, status, error) {
	            console.log(xhr, status, error);
	        }
	    });
	};
	
	$(function() {
    	getJson();
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
<tbody>

</tbody>
</table>
</body>
</html>