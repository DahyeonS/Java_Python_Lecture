# MVC
웹 페이지를 모델(Model), 뷰(View), 컨트롤러(Controller)로 나눠서 처리하는 방식

- 모델 - 자바의 DTO, DAO 클래스
- 뷰 - JSP 페이지
- 컨트롤러 - 서블릿

### pom.xml 설정
```xml
<dependencies>
    <dependency>
    	<groupId>javax.servlet</groupId>
    	<artifactId>jstl</artifactId>
    	<version>1.2</version>
	</dependency>
</dependencies>
```

## 컨트롤러
```java
@WebServlet("*.do") // 주소창이 .do로 끝나면 실행
public class DispatcherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		한글 처리
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

    // POST, GET 모두 처리
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 주소창을 요청받음
		String action = uri.substring(uri.lastIndexOf("/")); // 주소창의 마지막 부분을 추출

		if (action.equals("/login.do")) response.sendRedirect("login.jsp"); // 주소창이 login.do로 끝나면 실행

		else if (action.equals("/loginProc.do")) {
            // 작업 처리
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			
			MemberDAO dao = new MemberDAO();
			dto = dao.getMember(dto);
			
			if (dto != null) {
				if (dto.getPw().equals(pw)) {
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("name", dto.getName());
					response.sendRedirect("index.do");
				} else response.sendRedirect("login.do");
			} else response.sendRedirect("login.do");
		} 

        else if (action.equals("/loginJson.do")) {
            // 값을 전달하면서 페이지 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginJson.jsp");
			dispatcher.forward(request, response);
		}
	}
}
```