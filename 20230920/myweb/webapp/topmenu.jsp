<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function deleteConfirm() {
		const input = confirm("회원을 탈퇴할까요?");
		alert(input);
		if (input) location.href = "delete.do";
		else return;
	};
	
	function deleteConfirmJson() {
		const input = confirm("회원을 탈퇴할까요?");
		alert(input);
		if (input) location.href = "deleteAjax.do";
		else return;
	};
</script>
<h1>Member Service</h1>
<h2>
<a href="index.do">Home</a> |
<a href="memberList.do">회원목록</a> |
<a href="memberListJson.do">회원목록(JSON)</a> |

<% if (session.getAttribute("id") == null) { %>
	<a href="join.do">회원가입</a> |
	<a href="joinAjax.do">회원가입(JSON)</a> |
	<a href="login.do">로그인</a> |
	<a href="loginAjax.do">로그인(JSON)</a> |
	
<% } else { %>
	<a href="update.do">정보수정</a> |
	<a href="updateAjax.do">정보수정(JSON)</a> |
	<a href="#" onclick="deleteConfirm();">회원탈퇴</a> |
	<a href="#" onclick="deleteConfirmJson();">회원탈퇴(JSON)</a> |
	<a href="logout.do">로그아웃</a> | <br>
	<%=session.getAttribute("name") %>(<%=session.getAttribute("id") %>) 로그인 중
<% } %>
</h2>
<hr>