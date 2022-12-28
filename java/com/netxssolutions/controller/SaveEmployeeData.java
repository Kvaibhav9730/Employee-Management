package com.netxssolutions.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netxssolutions.dao.EmployeeDao;
import com.netxssolutions.dto.Employee;
@WebServlet("/emp_details")
public class SaveEmployeeData extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String address = req.getParameter("address");
	byte gender = Byte.parseByte(req.getParameter("gender"));
	Double salary = Double.parseDouble(req.getParameter("idnumber"));
	String date = req.getParameter("date");
	String date1 = "";
	char[] arr = date.toCharArray();
	for(char arr1:arr) {
		if(arr1=='-') {
			arr1 = '/';
		}
		date1+=arr1;
	}
	try {
		Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(date1);
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAddress(address);
		emp.setBirthdate(date2);
		emp.setGender(gender);
		emp.setSalary(salary);
		EmployeeDao employeedao = new EmployeeDao();
		employeedao.insertEmployee(emp);
		RequestDispatcher requestdispatcher = req.getRequestDispatcher("/GetEmployee");
		requestdispatcher.forward(req, resp);
	} catch (ParseException | SQLException e) {
		
		e.printStackTrace();
	}
}
}
