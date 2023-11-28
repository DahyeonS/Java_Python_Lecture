# JSP
**자바 서버 페이지**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```
Java + HTML

*예시*
```jsp
<body>
    <%
        int a = 10;
        int b = 20;
        int temp = 0;
    %>

    <h2>
    Before: a = <%=a %>, b = <%=b %>
    </h2>
</body>
```