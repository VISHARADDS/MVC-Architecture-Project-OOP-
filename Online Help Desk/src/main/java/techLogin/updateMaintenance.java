package techLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateMaintenance")
public class updateMaintenance extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Integer mid =Integer.parseInt(request.getParameter("mid"));
	    String patchno = request.getParameter("patchno");
	    String date = request.getParameter("date");
	    String troubleshoot = request.getParameter("troubleshoot");
	    

	    boolean isSuccess= TechnicianDButil.Updatemaintenance(mid, patchno, date, troubleshoot);

	  if(isSuccess) {

	    	response.sendRedirect(request.getContextPath() + "/maintenanceDB");
	    } else {
	    	
			out.println("<script type='text/javascript'>");
			out.println("alert('Update Unsuccessful');");
			out.println("location='maintenanceDB'");
			out.println("</script>");
	    }
	}
}