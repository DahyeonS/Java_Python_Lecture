<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
<h1>Hello World!!</h1>
<h2>Hello JSP!!</h2>
<%
	String name = "test";
	String email = "test@email.com";
	String cat = "./imgs/cat/cat1.jpg";
	String catAlt = "야옹이";
	String dog = "./imgs/dog/dog1.jpg";
	String dogAlt = "멍멍이";
	
	out.print(name); // 출력
	out.print("<br>");
	out.print(email);
%>
<br>

<ul>
<li><%=name %></li>
<li><%=email %></li>
<li>Cat: <img src="<%=cat%>" alt="<%=catAlt%>>"></li>
<li>Dog: <img src="<%=dog%>" alt="<%=dogAlt%>>"></li>
</ul>

<table>
<tr><td><%=name %></td></tr><tr><td><%=email %></td></tr>
</table>
</body>
</html>