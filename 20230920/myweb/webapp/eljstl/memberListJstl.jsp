<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberListJstl.jsp</title>
</head>
<body>
<%
	String name = "hong1";
	String[] nameArray = {"hong2", "hong3", "hong4"};
	MemberDTO member = new MemberDTO("hong5", "5555", "홍길동5", 55);
	List<MemberDTO> list = new ArrayList();
	list.add(new MemberDTO("hong1", "1111", "홍길동1", 11));
	list.add(new MemberDTO("hong2", "2222", "홍길동2", 22));
	list.add(new MemberDTO("hong3", "3333", "홍길동3", 33));
	list.add(new MemberDTO("hong4", "4444", "홍길동4", 44));
	
	request.setAttribute("name", name);
	request.setAttribute("nameArray", nameArray);
	request.setAttribute("member", member);
	request.setAttribute("list", list);
%>
<jsp:forward page="memberListViewJstl.jsp"></jsp:forward>
</body>
</html>