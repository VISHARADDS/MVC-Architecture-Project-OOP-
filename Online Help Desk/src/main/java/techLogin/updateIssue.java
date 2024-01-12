package techLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateIssue")
public class updateIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
	    String tid = request.getParameter("tid");
	    String email = request.getParameter("email");
	    String subject = request.getParameter("subject");
	    String solution = request.getParameter("solution");
	    String state = request.getParameter("state");

	    boolean isSuccess= TechnicianDButil.UpdateProblem(tid, email, subject, solution, state);

	  if(isSuccess) {

	    	response.sendRedirect(request.getContextPath() + "/showIssueTable");
	    } else {

			out.println("<script type='text/javascript'>");
			out.println("alert('Update Unsuccessful');");
			out.println("location='showIssueTable'");
			out.println("</script>");
	    }
	}
}