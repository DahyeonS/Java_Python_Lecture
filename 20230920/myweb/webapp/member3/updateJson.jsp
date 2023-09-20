<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String sAge = request.getParameter("age");
	int age = 0;
	if (sAge != null) age = Integer.parseInt(sAge);
	
	MemberDTO dto = new MemberDTO(id, pw, name, age);
	MemberDAO dao = new MemberDAO();
	int rs = 0;
	rs = dao.update(dto);
	
	JsonObject jsonObject = new JsonObject();
	jsonObject.addProperty("rs", rs);
%>
<%=jsonObject%>