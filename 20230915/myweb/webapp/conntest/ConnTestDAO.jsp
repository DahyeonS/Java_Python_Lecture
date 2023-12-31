<%@page import="member.MemberDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.getMemberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConnTest.jsp</title>
</head>
<body>
<h1>Member List</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>PW</th>
		<th>Name</th>
		<th>Age</th>
	</tr>
	<% if (list.size() != 0) { %>
		<% for(MemberDTO dto : list) { %>
			<tr style="text-align: center;">
				<td><%=dto.getId() %></td>
				<td><%=dto.getPw() %></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getAge() %></td>
			</tr>
		<% } %>
	<% } else { %>
		<tr style="text-align: center;">
			<td colspan="4">Member Not Found!!</td>
		</tr>
	<% } %>
	
</table>
</body>
</html>