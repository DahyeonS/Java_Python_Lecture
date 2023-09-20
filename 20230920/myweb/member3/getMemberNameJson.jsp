<%@page import="java.util.List"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	
	MemberDTO dto = new MemberDTO();
	dto.setName(name);
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.getMemberListName(dto);
	
	JsonArray jsonArray = new JsonArray();
	
	for (MemberDTO member : list) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("idx", member.getIdx());
		jsonObject.addProperty("id", member.getId());
		jsonObject.addProperty("pw", member.getPw());
		jsonObject.addProperty("name", member.getName());
		jsonObject.addProperty("age", member.getAge());
		jsonObject.addProperty("regdate", member.getRegdate());
		jsonArray.add(jsonObject);
	}
	
	out.print(jsonArray.toString());
%>