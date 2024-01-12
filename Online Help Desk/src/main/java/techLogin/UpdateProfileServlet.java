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

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// Retrieve the updated values from the form parameters
	    String username = request.getParameter("username");
	    String name = request.getParameter("name");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    
	    boolean isTrue;
	 try {   
	    isTrue=TechnicianDButil.updateProfile(username,name, email, gender, phone);
     if(isTrue) {
    	 
    	 List<Technician> techDetails=TechnicianDButil.getTechnicianDetails(username);
    	 //set updated values
    	 request.setAttribute("techDetails",techDetails);
    	 
    	 RequestDispatcher dis5=request.getRequestDispatcher("staffaccount.jsp");
    	 dis5.forward(request, response);
     }else
    	  {
    	 out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='techLoginPage.jsp'");
			out.println("</script>");
     } 
	 }catch(Exception e) {
		 out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='techLoginPage.jsp'");
			out.println("</script>");
	 }
 }
}