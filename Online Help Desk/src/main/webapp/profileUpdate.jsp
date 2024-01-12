<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="stylesheet/Homepage.css">
    <link rel="stylesheet" href="stylesheet/Home.css">
    <link rel="stylesheet" href="stylesheet/userprofile.css">
    <link rel="stylesheet" href="stylesheet/profileUpdate.css">
</head>
<body>
    <div class="sidebar">
      <div class="logo-details">
        <span class="logo_name"> &nbsp  &nbsp Technician</span>
      </div>
        <ul class="nav-links">
          <li>
              <a class="active">
                <i class='bx bx-user' ></i>
                <span class="links_name">User profile</span>
              </a>
            </li>
          <li>
            <a href="maintenanceDB">
              <i class='bx bx-line-chart' ></i>
              <span class="links_name">Maintenance DB</span>
            </a>
          </li>
          
          <li>
            <a href="showIssueTable">
              <i class='bx bx-coin-stack' ></i>
              <span class="links_name">Technical Issue  </span>
            </a>
          </li>
          
          <li class="log_out">
            <a href="techLoginPage.jsp" onclick="logout()">
              <i class='bx bx-log-out'></i>
              <span class="links_name">Log out</span>
            </a>
          </li>
        </ul>
    </div>
    <section class="home-section">
      <nav>
        <div class="sidebar-button">
          <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard"> User Profile </span>
        </div>
        
      </nav>
      
      <div class="home-content">
 <%
 String userName = request.getParameter("username");
 String name = request.getParameter("name");
 String email = request.getParameter("email");
 String phone = request.getParameter("phone");
 String gender = request.getParameter("gender");
 
 
 %>

  <form action="UpdateProfileServlet" method="post" class="form-container">
    <h3>Update Personal Profile</h3>
    <br>
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="TECH########" value="<%=userName%>" name="username" readonly >
    <label for="name"><b> Name </b></label>
    <input type="text" value="<%=name%>"  name="name" >
    <label for="email"><b>Email</b></label>
    <input type="email" placeholder="email@gmail.com" value="<%=email%>" name="email" >
    <label for="phone"><b>Phone</b></label>
    <input type="text" value="<%=phone%>"  name="phone" >
     <br>
    <label for="gender"><b>Gender</b></label> <br> 
    <select name="gender"> 
     <option value="Female"<%= gender.equals("Female")?"selected" : "" %>>Female</option>
    <option value="Male"<%= gender.equals("Male")?"selected" : "" %>>Male</option>
   
</select>


   

    

    <input  type="submit" value="Update" class="btn">
    <button type="button" class="btn cancel" onclick="window.location.href='staffaccount.jsp'">Close</button>
  </form>
      </div>
  
</section>


  


<script>
    let sidebar = document.querySelector(".sidebar");
 let sidebarBtn = document.querySelector(".sidebarBtn");
 sidebarBtn.onclick = function() {
   sidebar.classList.toggle("active");
   if(sidebar.classList.contains("active")){
   sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
 }else
   sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
 }
  </script>
  
  <script>
 
  function logout() {
    // Clear the session and navigate to the login page
    sessionStorage.clear(); 
    window.location.replace("techLoginPage.jsp"); // Replace the current page with the login page
  }
  
  // Prevent going back to the user profile page after logout
  window.addEventListener("pageshow", function(event) {
    var historyTraversal = event.persisted || (typeof window.performance != "undefined" && window.performance.navigation.type === 2);
    
    if (historyTraversal) {
      // Clear the session and navigate to the login page
      sessionStorage.clear(); // Optional: Clear session storage
      window.location.replace("techLoginPage.jsp"); // Replace the current page with the login page
    }
  });
</script>

</body>
</html>