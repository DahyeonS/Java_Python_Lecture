<%@page import="com.google.gson.JsonObject"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String pw = request.getParameter("pw");
	
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	MemberDAO dao = new MemberDAO();
	dto = dao.getMember(dto);
	int rs = 0;
	
	if (pw.equals(dto.getPw())) {
		session.invalidate();
		rs = dao.delete(dto);
	}
	
	JsonObject jsonObject = new JsonObject();
	jsonObject.addProperty("rs", rs);
%>
<%=jsonObject%>