package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.helper.MyDBConnection;
import com.dal.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	
	@Override
	public void insertEmployee(Employee emp) {
	     
		try {
			con  = MyDBConnection.getDbConnection();
			ps=con.prepareStatement("insert into dalemp values(?,?)");
			
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showEmployee() {	
		try {
			con  = MyDBConnection.getDbConnection();
			stmt= con.createStatement();
			rs = stmt.executeQuery("select * from dalemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}


	public void updateEmployee(Employee emp) {
		try {
			
			
			con  = MyDBConnection.getDbConnection();
			ps=con.prepareStatement("update dalemp set empname =? where empid=?");
			
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getEid());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got updated... ");
			showEmployee();
			//ResultSet rs = stmt.executeQuery(QUERY);
			
			//System.out.println(  + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int eid) {
		try {
			con  = MyDBConnection.getDbConnection();
			//ps=con.createStatement();
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM dalemp WHERE empid="+eid;
			System.out.println(eid);
			stmt.executeUpdate(sql);
			System.out.println("Employee deleted Succesfully");
			showEmployee();
			//ResultSet rs = stmt.executeQuery(QUERY);
			
			//System.out.println(  + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	


}
