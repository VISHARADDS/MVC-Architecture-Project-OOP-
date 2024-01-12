package techLogin;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TechnicianDButil {

public static boolean  validate(String userName ,String password){

		// create Database connection 
		
		String url="jdbc:mysql://localhost:3306/technician";
		String user= "root";
		String pass = "alone@1309";
		
		
		//validate
		
		boolean isSuccess = false;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stat = con.createStatement();
			
			String sql ="select * from technicianlogin where Username ='"+userName+ "'  and  Password ='"+password+"'";
		    
			ResultSet result = stat.executeQuery(sql);
			
			if(result.next()) {
				
				isSuccess=true;
				
			} else {
		  isSuccess=false;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
}		
		


public static boolean Insertproblem(String tid,String email,String subject,String solution,String state) {
	boolean isSuccess =false;
	
	 //create database connection
	
	String url="jdbc:mysql://localhost:3306/technician";
	String user= "root";
	String pass = "alone@1309";
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stat = con.createStatement();
		
		String sql = "Insert into techproblem values('"+tid+ "','"+email+ "','"+subject+ "','"+solution+ "','"+state+ "')";
		int  rs= stat.executeUpdate(sql); //return 2 values (0 or 1)
		
		if(rs>0) {
			
			isSuccess=true;
		}else
		{
			
			isSuccess=false;
			
		}
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return isSuccess;
}

public static boolean UpdateProblem(String tid, String email, String subject, String solution, String state) {
    boolean isSuccess = false;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/technician", "root", "alone@1309");

        PreparedStatement ps = con.prepareStatement("UPDATE technician.techproblem SET userEmail=?, subject=?, solution=?, state=? WHERE ticketID=?");
        ps.setString(1, email);
        ps.setString(2, subject);
        ps.setString(3, solution);
        ps.setString(4, state);
        ps.setString(5, tid);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            isSuccess = true;
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return isSuccess;
}

public static boolean Insertproblem(Integer mid, String patchno, String date, String troubleshoot) {
	boolean isSuccess =false;
	
	 //create database connection
	
	String url="jdbc:mysql://localhost:3306/technician";
	String user= "root";
	String pass = "alone@1309";
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stat = con.createStatement();
		
		String sql = "Insert into maintenancedb values('"+mid+ "','"+patchno+ "','"+date+ "','"+troubleshoot+ "')";
		int  rs= stat.executeUpdate(sql); //return 2 values (0 or 1)
		
		if(rs>0) {
			
			isSuccess=true;
		}else
		{
			
			isSuccess=false;
			
		}
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return isSuccess;
}

public static boolean Updatemaintenance(Integer mid, String patchno, String date, String troubleshoot) {
	 boolean isSuccess = false;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/technician", "root", "alone@1309");

	        PreparedStatement ps = con.prepareStatement("UPDATE technician.maintenancedb SET patchNo=?, date=?, troubleshoot=? WHERE mid=?");
	        ps.setString(1, patchno);
	        ps.setString(2, date);
	        ps.setString(3, troubleshoot);
	        ps.setInt(4, mid);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            isSuccess = true;
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}
public static boolean updateProfile(String username, String name, String email, String gender, String phone) {
	boolean isSuccess =false;	  
	String url="jdbc:mysql://localhost:3306/technician";
	String user= "root";
	String pass = "alone@1309";
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stat = con.createStatement();
		String sql ="UPDATE technician.technicianlogin SET  Name='"+name+"', Email='"+email+"', Phone='"+phone+"', Gender='"+gender+"'  WHERE Username='"+username+"'";
		int rs=stat.executeUpdate(sql);
		
        if(rs>0) {
			
			isSuccess=true;
		}else
		{
			
			isSuccess=false;
			
		}
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;

}

public static List<Technician> getTechnicianDetails(String username){
	
	ArrayList<Technician> tech = new ArrayList<>();
	String url="jdbc:mysql://localhost:3306/technician";
	String user= "root";
	String pass = "alone@1309";
	
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stat = con.createStatement();
		String sql ="Select * from technician.technicianlogin Where Username='"+username+"'";
		ResultSet result = stat.executeQuery(sql);
		
		while(result.next()) {
			int TID = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);
			String phone = result.getString(4);
			String Password = result.getString(5);
			String Username = result.getString(6);
			String gender=result.getString(7);
		

			Technician t1= new Technician(TID, name, email, phone,  Password,  Username,gender);
			tech.add(t1);
			
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return tech;
}

public static List<Technician> getTechnician(String userName){
	ArrayList<Technician> technician = new ArrayList<>();
	String url="jdbc:mysql://localhost:3306/technician";
	String user= "root";
	String pass = "alone@1309";
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement stat = con.createStatement();
		String sql ="Select * from technician.technicianlogin Where Username='"+userName+"'";
		ResultSet result = stat.executeQuery(sql);
		
		while(result.next()) {
			int TID = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);
			String phone = result.getString(4);
			String Password = result.getString(5);
			String Username = result.getString(6);
			String gender=result.getString(7);
			
			Technician t1= new Technician(TID, name, email, phone,  Password,  Username,gender);
			technician.add(t1);
			
			
		}
	}catch(Exception e) {
		
	}
		

	
	
return technician;
}

 
}


	


