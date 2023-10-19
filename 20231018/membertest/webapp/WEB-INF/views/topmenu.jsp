<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
function deleteCheck() {
	const check = confirm("회원을 탈퇴할까요?");
	if (check) location.href = "<%=contextPath%>/member/delete";
	else return;
}
</script>
</head>
<body>
<c:if test="${id != null}">
<c:if test="${role == 1}">
일반 회원
</c:if>
<c:if test="${role == 0}">
관리자
</c:if>
 ${name}(${id})님 환영합니다!
</c:if>
<h3><a href="<%=contextPath%>">HOME</a> 
<c:if test="${id == null}">
| <a href="<%=contextPath%>/member/join">회원가입</a> | <a href="<%=contextPath%>/member/login">로그인</a>
</c:if>
<c:if test="${id != null}">
| <a href="<%=contextPath%>/member/update">회원정보수정</a> | <a href="<%=contextPath%>/member/logout">로그아웃</a>
</c:if>
</h3>
<hr>
</body>
</html>