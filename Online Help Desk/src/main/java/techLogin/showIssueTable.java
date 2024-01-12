package techLogin;

import java.io.IOException;




import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showIssueTable")
public class showIssueTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/technician","root","alone@1309");
		
		PreparedStatement ps = con.prepareStatement("select * from technician.techproblem");
		out.print(" <html> <head>" + "<link rel=\"stylesheet\" href=\"stylesheet/table.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/Home.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/Homepage.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/tableform.css\">" 
		   + " <title> Technician | Technical Issue  </title>" +"</head><body>" +"<div class=\"sidebar\">  <div class=\"logo-details\"> " +" <span class=\"logo_name\"> &nbsp  &nbsp Technician</span>"
		   		+ "    </div> " +" <ul class=\"nav-links\">"
		   				 +" <li>"
		   						+ "            <a href=\"staffaccount.jsp\">"
		   						+ "              <i class='bx bx-user' ></i>"
		   						+ "              <span class=\"links_name\">User profile</span>"
		   						+ "            </a>" 
		   						+ "          </li>"+"<li>"
		   								+ "          <a href=\"maintenanceDB\">"
		   								+ "            <i class='bx bx-line-chart' ></i>"
		   								+ "            <span class=\"links_name\">System Maintenance </span>"
		   								+ "          </a>"
		   								+ "        </li>"+" <li>"
		   										+ "          <a class=\"active\">"
		   										+ "            <i class='bx bx-coin-stack' ></i>"
		   										+ "            <span class=\"links_name\">Technical Issue </span>"
		   										+ "          </a>"
		   										+ "        </li>"+" <li class=\"log_out\">"
		   														+ "          <a href=\"techLoginPage.jsp\" onclick=\"logout()\">"
		   														+ "            <i class='bx bx-log-out'></i>"
		   														+ "            <span class=\"links_name\">Log out</span>"
		   														+ "          </a>"
		   														+ "        </li>"+ "</ul>"+"</div>"+"<section class=\"home-section\">"
		   																+ "    <nav>"
		   																+ "      <div class=\"sidebar-button\">"
		   																+ "        <i class='bx bx-menu sidebarBtn'></i>"
		   																+ "        <span class=\"dashboard\">Technical Issue </span>"
		   																+ "      </div>"+ "<div class=\"search-box\">"
		   																		+ "        <input type=\"text\" placeholder=\"Search...\" id=\"searchInput\">"
		   																		+ "        <i class='bx bx-search' onclick='searchTable()' ></i>"
		   																		+ "      </div>"+"<div class=\"box2\">"
		   																				+ "    <a href=\"#myForm\" onclick=\"insert()\" class=\"btn one\"> <span class=\"bx bx-plus\">ADD ISSUE</span></a>"
		   																				+ "      </div>"+ " </nav>"+ "<div class=\"home-content\">"+ "<section class=\"wrapper\">"); 
		
		out.print("<main class=\"row title\">");
		
			
			ResultSet rs=ps.executeQuery();
			out.print("<ul>");
			out.print("<li><b><u>Ticket ID</b></u></li>"); 
			out.print("<li><b><u>User Email</b></u></li>");
			out.print("<li><b><u>Subject</b></u></li>");
			out.print("<li><b><u>Solution</b></u></li>");
			out.print("<li><b><u>State</b></u></li>");
			
			 out.print("</ul>");
			 out.print("</main>");
			
			 while(rs.next()) {
				    out.print( "<section class='row-fadeIn-wrapper'>"+"<article class='row fadeIn datarow'>"+"<ul><li><a href='#' class=\"link\">"+rs.getString(1)+"</a></li><li>"+rs.getString(2)+"</li><li>"+rs.getString(3)+"</li><li>"+rs.getString(4)+"</li><li>"+rs.getString(5)+"</li></ul>"
				        + " <ul class='more-content'>" + " <li>" + "<a href=\"#myForm1\" onclick='updateIssue(\"" + rs.getString(1) + "\", \"" + rs.getString(2) + "\", \"" + rs.getString(3) + "\",\"" + rs.getString(4) + "\",\"" + rs.getString(5) + "\")' class='btn'>" +"<i class='fa fa-edit'></i> Update" +"</a>" +"&nbsp" + "<a href='DeleteServlet?ticketID=" + rs.getString(1) + "' class='btn'>"
			            + "<i class='fa fa-trash'></i> Delete</a>"
				        + "</li></ul></article></section> " );
				}
			 out.print("</section>");
			 out.print("</div>");
			 out.print("</section>");
			 out.print(" <div class=\"form-popup\"  id=\"myForm\">");
			 out.print("<div class=\"overlay\">");
			 out.print("<form  action=\"showIssueTable\" method=\"post\"  class=\"form-container\" >");
			 out.print("<label for=\"tid\"><b> Ticket ID </b></label>");
			 out.print(" <input type=\"text\"  name=\"tid\" required> ");
			 out.print("<label for=\"email\"><b> User Email</b></label>");
			 out.print("<input type=\"email\" placeholder=\"Enter Email\" name=\"email\" required>");
			 out.print("<label for=\"subject\"><b>Subject</b></label>");
			 out.print("<input type=\"text\" placeholder=\"subject\" name=\"subject\" required>");
			 out.print("<label for=\"solution\"><b>Solution</b></label>");
			 out.print("<textarea id=\"textarea\" name=\"solution\" placeholder=\"description\" rows=\"2\" cols=\"30\" required></textarea>");
			 out.print("<label for=\"state\"><b>State</b></label>");
			 out.print("<input type=\"text\" placeholder=\"description\" name=\"state\" required>");
			 out.print("<input  type=\"submit\" class=\"blue\" value=\"Submit\">");
			 out.print("<button type=\"button\" class=\"cancel\" onclick=\"closeForm()\">Close</button>");
			 out.print(" </form>");
			 out.print("</div>");
			 out.print("</div>");
			 
			 
			 out.print("<div class=\"form-popup2\"  id=\"myForm1\">");
			 out.print("<div class=\"overlay\">");
			 out.print("<form  action=\"updateIssue\" method=\"post\"  class=\"form-container\" >");
			 out.print(" <input type=\"hidden\" id=\"tid1\" name=\"tid\" required> ");
			 out.print("<label for=\"email1\"><b> User Email</b></label>");
			 out.print("<input type=\"email\" placeholder=\"Enter Email\" id=\"email1\" name=\"email\" >");
			 out.print("<label for=\"subject1\"><b>Subject</b></label>");
			 out.print("<input type=\"text\" placeholder=\"subject\" id=\"subject1\" name=\"subject\" >");
			 out.print("<label for=\"solution1\"><b>Solution</b></label>");
			 out.print("<textarea id=\"textarea\" id=\"solution1\" name=\"solution\" placeholder=\"description\" rows=\"2\" cols=\"30\"></textarea>");
			 out.print("<label for=\"state1\"><b>State</b></label>");
			 out.print("<input type=\"text\" placeholder=\"description\" id=\"state1\" name=\"state\" >");
			 out.print("<input  type=\"submit\" class=\"blue\" value=\"Update\">");
			 out.print("<button type=\"button\" class=\"cancel\" onclick=\"closeForm1()\">Close</button>");
			 out.print(" </form>");
			 out.print("</div>");
			 out.print("</div>");
			 
			
			 
			 out.print("<script>"
			 		+ "   let sidebar = document.querySelector(\".sidebar\");"
			 		+ "let sidebarBtn = document.querySelector(\".sidebarBtn\");"
			 		+ "sidebarBtn.onclick = function() {"
			 		+ "  sidebar.classList.toggle(\"active\");"
			 		+ "  if(sidebar.classList.contains(\"active\")){"
			 		+ "  sidebarBtn.classList.replace(\"bx-menu\" ,\"bx-menu-alt-right\");"
			 		+ "}else"
			 		+ "  sidebarBtn.classList.replace(\"bx-menu-alt-right\", \"bx-menu\");"
			 		+ "}" );
			 out.print("</script>");
			 
			 		out.print("<script>"
			 		+ "function insert() {"
			 		+ "document.getElementById(\"myForm\").style.display = \"block\";"
			 		+"}"
			 		
			 		+ "function closeForm() {"
			 		+ "document.getElementById(\"myForm\").style.display = \"none\";"
			 		+ "}"
			 		
			 		+ "</script>");
			 		
			 		out.print("<script>"
			 			    + "function updateIssue(ticketID, email, subject, solution, state) {"
			 			    + "  document.getElementById(\"myForm1\").style.display = \"block\";"
			 			    + "  document.getElementById('tid1').value = ticketID;"
			 			    + "  document.getElementById('email1').value = email;"
			 			    + "  document.getElementById('subject1').value = subject;"
			 			    + "  document.getElementById('solution1').value = solution;"
			 			    + "  document.getElementById('state1').value = state;"
			 			    
			 			    + "}"
					 		+ "function closeForm1() {"
					 		+ "document.getElementById(\"myForm1\").style.display = \"none\";"
					 		+ "}"
					 		+ "</script>");
			 		
			 		out.print("<script>"
			 	           + "function searchTable() {"
			 	           +    "var input, filter, row, a, i, txtValue;"
			 	           +    "input = document.getElementById('searchInput');"
			 	           +    "filter = input.value.toUpperCase();"
			 	           +    "row = document.getElementsByClassName('datarow');"
			 	           +    "for (i = 0; i < row.length; i++) {"
			 	           +        "a = row[i].getElementsByTagName('a')[0];"
			 	           +        "txtValue = a.textContent || a.innerText;"
			 	           +        "if (txtValue.toUpperCase().indexOf(filter) > -1) {"
			 	           +            "row[i].style.display = '';"
			 	           +        "} else {"
			 	           +            "row[i].style.display = 'none';"
			 	           +        "}"
			 	           +    "}"
			 	           + "}"
			 	           + "</script>");
			 		
			 		out.print(" <script>"
			 				+ "  function logout() {"
			 				+ "    sessionStorage.clear(); "
			 				+ "    window.location.replace(\"techLoginPage.jsp\");" 
			 				+ "  }"
			 				+ "  window.addEventListener(\"pageshow\", function(event) {"
			 				+ "    var historyTraversal = event.persisted || (typeof window.performance != \"undefined\" && window.performance.navigation.type === 2);"
			 				+ "  });"
			 				+ "</script>");
				 
			 
			 		
			 out.print("</body>");
			 out.print("</html>");
			
				 
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	
			String tid =request.getParameter("tid");
			String email=request.getParameter("email");
			String subject=request.getParameter("subject");
			String solution=request.getParameter("solution");
			String state=request.getParameter("state");
			
			
			
			 boolean isTrue;
			
			isTrue=TechnicianDButil.Insertproblem(tid, email, subject, solution, state);
			
			if(isTrue==true) {
				response.sendRedirect(request.getRequestURI());
				
			}else
				
			{
				out.println("<script type='text/javascript'>");
				out.println("alert('Insert Unsuccessful');");
				out.println("location='showIssueTable'");
				out.println("</script>");
						
				
				
				
			}
			
			
				
		}
 


	
}
