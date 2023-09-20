<%@page import="com.google.gson.JsonObject"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	MemberDAO dao = new MemberDAO();
	dto = dao.getMember(dto);
	
	JsonObject jsonObject = new JsonObject();
	
	if (pw.equals(dto.getPw())) {
		session.setAttribute("id", id);
		session.setAttribute("name", dto.getName());
		jsonObject.addProperty("rs", 1);
	}
	else jsonObject.addProperty("rs", 0);
%>
<%=jsonObject%>