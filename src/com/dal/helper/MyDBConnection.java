package com.dal.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class MyDBConnection {
	static Connection con;

	public static Connection getDbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba", "P@55word");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

	public static void main(String[] args) {
		System.out.println(getDbConnection());
	}
//	public static void main(String[] args) {
//		System.out.println(getDbConnection());
//        String query = "select * from patients";
//        Statement st;
//		try {
//			st = con.createStatement();
//			ResultSet rs = st.executeQuery(query); 
//	        while(rs.next()){
//	            System.out.print("FirstName: " + rs.getString("firstname"));
//	            System.out.print(", LastName: " + rs.getString("lastname"));
//	            System.out.print(", Age: " + rs.getString("age"));
//	         }	        
//	        st.close(); // close statement
//	        con.close(); // close connection
//	 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//              
//	}

}
