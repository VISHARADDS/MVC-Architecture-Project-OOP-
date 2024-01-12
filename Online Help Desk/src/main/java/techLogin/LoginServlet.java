package techLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		isTrue = TechnicianDButil.validate(userName,password);
		
		
		if(isTrue==true) {
			List<Technician> techDetails=TechnicianDButil.getTechnician(userName);
			request.setAttribute("techDetails",techDetails);
			RequestDispatcher dis =request.getRequestDispatcher("staffaccount.jsp");
			dis.forward(request, response);
		}
		
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='techLoginPage.jsp'");
			out.println("</script>");
					
			
				
		       
		        
		}
	
	}

}
