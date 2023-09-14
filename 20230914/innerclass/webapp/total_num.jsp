<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// total_num.jsp
	Object ovisit = application.getAttribute("visit");
	
	int iVisit = 0;
	if (ovisit != null) iVisit = (int)ovisit;
	iVisit += 1;
	application.setAttribute("visit", iVisit);
%>
