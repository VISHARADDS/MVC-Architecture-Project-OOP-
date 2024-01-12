package techLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	Statement stat;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String ticketID = request.getParameter("ticketID");
	
		
		
	

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/technician", "root", "alone@1309");

           Statement stat = conn.createStatement();
           stat.executeUpdate("DELETE FROM technician.techproblem WHERE ticketID ='"+ticketID+"'");
            response.sendRedirect(request.getContextPath() + "/showIssueTable");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}