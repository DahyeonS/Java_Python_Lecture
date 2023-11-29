# JSP
**자바 서버 페이지**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```
- Java + HTML
- Web에서 전송받은 값을 Java로 처리할 수 있음
- <% %>(쿼리), <%@ @%>(임포트), <%= %>(값)으로 사용

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

## 연산자 처리
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sA = request.getParameter("a"); // 요청 받은 값을 전달 받음(반드시 문자열로 해야함)
	String sB = request.getParameter("b");
%>
<!DOCTYPE html>
<html>
    <body>
        <%
            int a = Integer.parseInt(sA);
            int b = Integer.parseInt(sB);
        %>

        <ul>
            <li>a + b = <%=a+b%></li>
            <li>a - b = <%=a-b%></li>
            <li>a * b = <%=a*b%></li>
            <li>a % b = <%=a%b%></li>
        </ul>
    </body>
</html>
```