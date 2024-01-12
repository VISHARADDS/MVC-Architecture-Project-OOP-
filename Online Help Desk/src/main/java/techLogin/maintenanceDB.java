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

@WebServlet("/maintenanceDB")
public class maintenanceDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/technician","root","alone@1309");
		
		PreparedStatement ps = con.prepareStatement("select * from technician.maintenancedb");
		out.print(" <html> <head>" + "<link rel=\"stylesheet\" href=\"stylesheet/table2.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/Home.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/Homepage.css\">" + "<link rel=\"stylesheet\" href=\"stylesheet/tableform2.css\">" 
		   + " <title> Technician | System Maintenance </title>" +"</head><body>" +"<div class=\"sidebar\">  <div class=\"logo-details\"> " +" <span class=\"logo_name\"> &nbsp  &nbsp Technician</span>"
		   		+ "    </div> " +" <ul class=\"nav-links\">"
		   				 +" <li>"
		   						+ "            <a href=\"staffaccount.jsp\">"
		   						+ "              <i class='bx bx-user' ></i>"
		   						+ "              <span class=\"links_name\">User profile</span>"
		   						+ "            </a>" 
		   						+ "          </li>"+"<li>"
		   								+ "          <a href=\"maintenanceDB\" class=\"active\">"
		   								+ "            <i class='bx bx-line-chart' ></i>"
		   								+ "            <span class=\"links_name\">System Maintenance </span>"
		   								+ "          </a>"
		   								+ "        </li>"+" <li>"
		   										+ "          <a href=\"showIssueTable\">"
		   										+ "            <i class='bx bx-coin-stack' ></i>"
		   										+ "            <span class=\"links_name\">Technical Issue </span>"
		   										+ "          </a>"
		   										+ "        </li>"+" <li>"
		   												+" <li class=\"log_out\">"
		   														+ "          <a href=\"techLoginPage.jsp\"onclick=\"logout()\">"
		   														+ "            <i class='bx bx-log-out'></i>"
		   														+ "            <span class=\"links_name\">Log out</span>"
		   														+ "          </a>"
		   														+ "        </li>"+ "</ul>"+"</div>"+"<section class=\"home-section\">"
		   																+ "    <nav>"
		   																+ "      <div class=\"sidebar-button\">"
		   																+ "        <i class='bx bx-menu sidebarBtn'></i>"
		   																+ "        <span class=\"dashboard\">System Maintenance </span>"
		   																+ "      </div>"+ "<div class=\"search-box\">"
		   																		+ "        <input type=\"text\" placeholder=\"Search...\">"
		   																		+ "        <i class='bx bx-search'onclick='searchTable()' ></i>"
		   																		+ "      </div>"+"<div class=\"box2\">"
		   																				+ "    <a href=\"#myForm\" onclick=\"insert()\" class=\"btn one\"> <span class=\"bx bx-plus\">ADD ISSUE</span></a>"
		   																				+ "      </div>"+ " </nav>"+ "<div class=\"home-content\">"+ "<section class=\"wrapper\">"); 
		
		out.print("<main class=\"row title\">");
		
			
			ResultSet rs=ps.executeQuery();
			out.print("<ul>");
			out.print("<li><b><u>Maintenance ID</b></u></li>");
			out.print("<li><b><u>Patch No</b></u></li>");
			out.print("<li><b><u>Date</b></u></li>");
			out.print("<li><b><u>Troubleshoot</b></u></li>");
			
			 out.print("</ul>");
			 out.print("</main>");
			
			 while(rs.next()) {
				    out.print( "<section class='row-fadeIn-wrapper'>"+"<article class='row fadeIn datarow'>"+"<ul><li>"+rs.getString(1)+"</li><li><a href='#' class=\"link\">"+rs.getString(2)+"</a></li><li>"+rs.getString(3)+"</li><li>"+rs.getString(4)+"</li></ul>"
				        + " <ul class='more-content'>" + " <li>" + "<a href=\"#myForm1\" onclick='updateIssue(\"" + rs.getString(1) + "\", \"" + rs.getString(2) + "\", \"" + rs.getString(3) + "\",\"" + rs.getString(4) + "\")' class='btn'>" +"<i class='fa fa-edit'></i> Update" +"</a>" +"&nbsp" + "<a href='DeleteServlet2?mid=" + rs.getString(1) + "' class='btn'>"
			            + "<i class='fa fa-trash'></i> Delete</a>"
				        + "</li></ul></article></section> " );
				}
			 out.print("</section>");
			 out.print("</div>");
			 out.print("</section>");
			 out.print(" <div class=\"form-popup\"  id=\"myForm\">");
			 out.print("<div class=\"overlay\">");
			 out.print("<form  action=\"maintenanceDB\" method=\"post\"  class=\"form-container\" >");
			 out.print("<br>");
			 out.print("<label for=\"mid\"><b>Maintenance ID </b></label>");
			 out.print(" <input type=\"text\"  name=\"mid\" required> ");
			 out.print("<br>");
			 out.print("<label for=\"patchno\"><b> Patch No </b></label>");
			 out.print("<input type=\"text\" placeholder=\"#Patch No.\" name=\"patchno\" required>");
			 out.print("<br>");
			 out.print("<label for=\"date\"><b>Date</b></label>");
			 out.print("<br>");
			 out.print("<input type=\"date\"  name=\"date\" required>");
			 out.print("<br>");
			 out.print("<br>");
			 out.print("<label for=\"troubleshoot\"><b>Troubleshoot</b></label>");
			 out.print("<textarea id=\"troubleshoot\" name=\"troubleshoot\" placeholder=\"description\" rows=\"2\" cols=\"30\" required></textarea>");
			 out.print("<br>");
			 out.print("<input  type=\"submit\" class=\"blue\" value=\"Submit\">");
			 out.print("<button type=\"button\" class=\"cancel\" onclick=\"closeForm()\">Close</button>");
			 out.print(" </form>");
			 out.print("</div>");
			 out.print("</div>");
			 
			 
			 out.print("<div class=\"form-popup2\"  id=\"myForm1\">");
			 out.print("<div class=\"overlay\">");
			 out.print("<form  action=\"updateMaintenance\" method=\"post\"  class=\"form-container\" >");
			 out.print(" <input type=\"hidden\" id=\"mid1\" name=\"mid\" required> ");
			 out.print("<label for=\"patchno1\"><b> Patch No</b></label>");
			 out.print("<input type=\"text\" placeholder=\"#Patch No.\" id=\"patchno1\" name=\"patchno\" >");
			 out.print("<label for=\"date1\"><b>Date</b></label>");
			 out.print("<br>");
			 out.print("<input type=\"date\" id=\"date1\" name=\"date\" >");
			 out.print("<br>");
			 out.print("<label for=\"troubleshoot1\"><b>Troubleshoot</b></label>");
			 out.print("<textarea id=\"troubleshoot1\" name=\"troubleshoot\" placeholder=\"description\" rows=\"2\" cols=\"30\"></textarea>");
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
			 			    + "function updateIssue(mid,patchno, date, troubleshoot) {"
			 			    + "  document.getElementById(\"myForm1\").style.display = \"block\";"
			 			    + "  document.getElementById('mid1').value = mid;"
			 			    + "  document.getElementById('patchno1').value = patchno;"
			 			    + "  document.getElementById('date1').value = date;"
			 			    + "  document.getElementById('troubleshoot1').value = troubleshoot;"
			 			    
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
			
			Integer mid =Integer.parseInt(request.getParameter("mid"));
			String patchno=request.getParameter("patchno");
			String date=request.getParameter("date");
			String troubleshoot=request.getParameter("troubleshoot");
			
			
			
			
			 boolean isTrue;
			
			isTrue=TechnicianDButil.Insertproblem(mid,patchno, date,troubleshoot);
			
			if(isTrue==true) {
				response.sendRedirect(request.getRequestURI());
				
			}else
				
			{
				out.println("<script type='text/javascript'>");
				out.println("alert('Insert Unsuccessful');");
				out.println("location='maintenanceDB'");
				out.println("</script>");
						
				
				
			}
			
			
				
		}
 


	
}
