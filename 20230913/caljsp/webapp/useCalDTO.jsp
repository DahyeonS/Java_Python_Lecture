<%@page import="hellojsp.CalDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useCalDTO.jsp</title>
</head>
<body>
<%
	//. 1. 스크립트릿 사용
	CalDTO dto1 = new CalDTO();
	dto1.setA(10);
	dto1.setB(20);
	dto1.setSel("+");
%>
<h1>
A: <%=dto1.getA() %>,
B: <%=dto1.getB() %>,
Sel: <%=dto1.getSel() %>,
</h1>
<!-- 2. jsp:userBean -->
<jsp:useBean id="dto2" class="hellojsp.CalDTO"></jsp:useBean>
<jsp:setProperty property="a" name="dto2" value="10"/>
<jsp:setProperty property="b" name="dto2" value="20"/>
<jsp:setProperty property="sel" name="dto2" value="+"/>
<h1>
A: <%=dto2.getA() %>,
B: <%=dto2.getB() %>,
Sel: <%=dto2.getSel() %>,
</h1>
</body>
</html>