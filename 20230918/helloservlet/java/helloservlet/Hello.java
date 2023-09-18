package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html lang='ko'>");
		pw.println("<title> servlet test </title>");
		pw.println("<body>");
		pw.println("<h1>Servlet Test</h1>");
		pw.println("<h2>GET ID: " + id + "</h2>");
		pw.println("</body>");
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html lang='ko'>");
		pw.println("<title> servlet test </title>");
		pw.println("<body>");
		pw.println("<h1>Servlet Test</h1>");
		pw.println("<h2>POST ID: " + id + "</h2>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
