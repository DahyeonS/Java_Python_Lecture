package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteProc")
public class DeleteProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");
		int rs = 0;
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		MemberDAO dao = new MemberDAO();
		dto = dao.getMember(dto);
		
		if (dto.getPw().equals(pw)) rs = dao.delete(dto);
		
		if (rs == 1) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else response.sendRedirect("delete.jsp");
	}

}
