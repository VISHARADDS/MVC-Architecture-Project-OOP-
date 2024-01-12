<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Technician | StaffAccount </title>
    <link rel="stylesheet" href="stylesheet/Homepage.css">
    <link rel="stylesheet" href="stylesheet/Home.css">
    <link rel="stylesheet" href="stylesheet/userprofile.css">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      
      <span class="logo_name">&nbsp &nbsp Technician</span>
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
            <span class="links_name">System Maintenance </span>
          </a>
        </li>
        
        <li>
          <a href="showIssueTable">
            <i class='bx bx-coin-stack' ></i>
            <span class="links_name">Technical Issue</span>
          </a>
        </li>
       
        <li class="log_out" onclick="logout()">
          <a href="techLoginPage.jsp">
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
        <span class="dashboard">User Profile</span>
      </div>
    </nav>
    
 <div class="home-content">
  <section class="user-content">
    <div class="uimage">
    <img src="user.png"  alt="User-Profile-Image">
    <p class="user-name">
    <c:forEach var="tech" items="${techDetails}">
   <c:set var="userName" value="${tech.userName}"/>
     ${tech.userName}
    </c:forEach>
    </p>
    </div>

    <div class="vl"></div>
    
    <div class="info">
    
        <p class="Name">Name :</p>
        <c:forEach  var="tech" items="${techDetails}">  
        <c:set var="name" value="${tech.name}"/>
        ${tech.name}
        </c:forEach>
        <hr>
        
        <p class="Gender">Gender :</p>
        <c:forEach   var="tech" items="${techDetails}">
        <c:set var="gender" value="${tech.gender}"/>
         ${tech.gender}
        </c:forEach>
        <hr>
        
        <p class="E-mail">E-mail :</p>
        <c:forEach   var="tech" items="${techDetails}"> 
        <c:set var="email" value="${tech.email}"/>
        ${tech.email} 
        </c:forEach>
        <hr>
        
        <p class="Contact">Contact No :</p>
        <c:forEach  var="tech" items="${techDetails}">
        <c:set var="phone" value="${tech.phone}"/>
         ${tech.phone}
        </c:forEach>
        <hr>
       
    </div>

  <c:url value="profileUpdate.jsp" var="profileUpdate">
     <c:param name="username" value="${userName}"></c:param>
     <c:param name="name" value="${name}"></c:param>
     <c:param name="gender" value="${gender}"></c:param>
     <c:param name="email" value="${email}"></c:param>
     <c:param name="phone" value="${phone}"></c:param>
  </c:url>
     
    <a href="${profileUpdate}"  class="edit-btn"><i class="fa fa-edit"></i>Edit Profile</a>
    
        
    


  </section>
 
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



 