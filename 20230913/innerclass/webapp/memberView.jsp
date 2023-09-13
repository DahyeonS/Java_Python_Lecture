<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<jsp:useBean id="member" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView.jsp</title>
</head>
<body>
<h1>회원가입 완료!!</h1>
<table border="">
<tr>
<th>ID</th><th>PW</th><th>NAME</th><th>AGE</th>
</tr>
<tr style="text-align: center;">
<td><%=member.getId() %></td>
<td><%=member.getPw() %></td>
<td><%=member.getName() %></td>
<td><%=member.getAge() %></td>
</tr>
</table>
</body>
</html>