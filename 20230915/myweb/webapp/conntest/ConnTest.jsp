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
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		
		String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
		String user = "root";
		String password = "rpass";
		
		conn = DriverManager.getConnection(url, user, password);
		out.print("Conn OK!! <br>");
		
		String sql = "select * from member order by idx desc";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			MemberDTO dto = null;
			
			dto = new MemberDTO(id, pw, name, age);
			list.add(dto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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