package com.netxssolutions.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.netxssolutions.dto.Employee;

public class EmployeeDao {
     public void insertEmployee(Employee emp) throws SQLException {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "root");
			PreparedStatement preparestatement = connection.prepareStatement("insert into emp(Name,Address,Gender,Salary,Birthdate) values(?,?,?,?,?)");
			preparestatement.setString(1, emp.getName());
			preparestatement.setString(2, emp.getAddress());
			preparestatement.setInt(3, emp.getGender());
			preparestatement.setDouble(4, emp.getSalary());
			java.sql.Date date =  (java.sql.Date) new java.sql.Date(emp.getBirthdate().getTime());
			preparestatement.setDate(5, date);
			preparestatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
    	 
     }
     public void deleteEmployee(int id) {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "root");
			PreparedStatement preparestatement = connection.prepareStatement("delete from emp where employeeid = ?");
			preparestatement.setInt(1, id);
			preparestatement.execute();
			preparestatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
     }
     public ResultSet getAllEmployeeDetails() {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from emp");
			return rs;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
     }
}
