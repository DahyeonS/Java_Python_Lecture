<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberListViewJstl.jsp</title>
</head>
<body>
<h1>스크립트릿 방식</h1>
<%
	String name = (String)request.getAttribute("name");
%>
<%=name %> <br>
<%
	String[] nameArray = (String [])request.getAttribute("nameArray");
%>
<% for (String n : nameArray) { %>
	<%=n %>
<% } %> <br>
<%
	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
%>
<% for (MemberDTO dto : list) { %>
	<%=dto.getId() %>, <%=dto.getPw() %>, <%=dto.getName() %>, <%=dto.getAge() %> <br>
<% } %>
<%
	MemberDTO member = (MemberDTO)request.getAttribute("member");
%>
<% if (member != null) { %>
	<%=member.getId() %>, <%=member.getPw() %>, <%=member.getName() %>, <%=member.getAge() %> <br>
<% } %>

<h1>EL + JSTL 방식</h1>
${requestScope.name} <br>
<c:forEach var="n" items="${nameArray}">
${n}
</c:forEach> <br>
<c:forEach var="dto" items="${list}">
${dto.id}, ${dto.pw}, ${dto.name}, ${dto.age} <br>
</c:forEach>
<c:if test="${member != null}">
${member.id}, ${member.pw}, ${member.name}, ${member.age}
</c:if>
</body>
</html>