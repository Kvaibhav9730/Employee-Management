package com.netxssolutions.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netxssolutions.dao.EmployeeDao;

@WebServlet("/employeedelete")
public class DeleteEmployee extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	EmployeeDao employeedao2 = new EmployeeDao();
	employeedao2.deleteEmployee(id);
	
	RequestDispatcher requestdispatcher2 = req.getRequestDispatcher("GetEmployee");
	requestdispatcher2.forward(req, resp);
}
}
