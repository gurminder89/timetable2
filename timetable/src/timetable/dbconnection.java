package timetable;

import java.sql.*;


public class dbconnection {

	


	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost:3306/user_login";
		String user = "root";
		String password = "";
		
				
		
		try {
			
			// 1. get a connection database
			
			Connection myConn = DriverManager.getConnection (dbUrl, user, password);
			
			//2. create statement
			
			Statement myStmt= myConn.createStatement();
			
			//3. execute a SQL query
			
			ResultSet MyRs = myStmt.executeQuery("select * from timetable");
		
			
			//4. Process the result object
			
	         while (MyRs.next()){
	        	 System.out.println(MyRs.getString ("Studentname")+ "" + MyRs.getString("Student_ID"));
	         }
	         
	         myStmt.close();
	         myConn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
