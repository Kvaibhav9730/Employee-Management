package com.netxssolutions.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netxssolutions.dao.EmployeeDao;
@WebServlet("/GetEmployee")
public class GetEmployeeList extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EmployeeDao employeedao1 = new EmployeeDao(); 
	ResultSet rs1 =  employeedao1.getAllEmployeeDetails();
	HttpSession hs = req.getSession();
	hs.setAttribute("1", rs1);
	
	RequestDispatcher requestdispatcher1 = req.getRequestDispatcher("emp.jsp");
	requestdispatcher1.forward(req, resp);
}
}
