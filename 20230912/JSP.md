# JSP
**자바 서버 페이지**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```
- Java + HTML
- Web에서 전송받은 값을 Java로 처리할 수 있음
- <% %>(쿼리), <%@ @%>(임포트), <%= %>(값), <%! %>(메소드)으로 사용

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

## 조건문 처리
- Java로 처리
```jsp
<%
	String role = "admin";
	if (role.equals("admin")) {
		out.print("ADMIN <br>");
		out.print("<img src='./imgs/cat/cat1.jpg' alt='야옹이'>");
	}
	else {
		out.print("GUEST <br>");
		out.print("<img src='./imgs/dog/dog1.jpg' alt='멍멍이'>");
	}
%>
```

- Java와 HTML 섞어서 처리
```jsp
<%
	role = "guest";
	if(role.equals("admin")) {
%>
		ADMIN <br>
		<img src='./imgs/cat/cat1.jpg' alt='야옹이'>
<%	} else { %>
		GUEST <br>
		<img src='./imgs/dog/dog1.jpg' alt='멍멍이'>
<%	} %>
```

## 반복문 처리
- Java로 처리
```jsp
<% 
	int sum = 0;
	for (int i=0; i<10; i++)  sum += (i + 1);
%>

<h2>sum = <%=sum %></h2>
```

- Java와 HTML 섞어서 처리
```jsp
<h2>for</h2>
<%	for (int i=1; i<=6; i++) { %>
		<h<%=i %>>Heading Tag <%=i %> <br></h<%=i %>>
<%	} %>
```

## 메소드 처리
```jsp
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
%>
<!DOCTYPE html>
<html>
    <body>
        <%
            int v1 = 3;
            int v2 = 9;
            int result = add(v1, v2);
        %>
        <h1><%=v1 %> + <%=v2 %> = <%=result %></h1>

        <%
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = format.format(date);
        %>
        <h1>Today is <%=strDate %></h1>
    </body>
</html>
```