<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Employee List</h1>
<hr width="1300">
<%ResultSet rs2 = (ResultSet)session.getAttribute("1"); %>
<table cellpadding="3px" align="center" border="" >
<th>employeeid</th>
<th>Name</th>
<th>Address</th>
<th>Gender</th>
<th>Salary</th>
<th>Birthdate</th>
<th>Delete</th>
<% while(rs2.next()){%>
<tr>
<td> <%=rs2.getInt(1) %></td>
<td> <%=rs2.getString(2) %></td>
<td> <%=rs2.getString(3) %></td>
<td> <%=rs2.getInt(4) %></td>
<td> <%=rs2.getDouble(5) %></td>
<td> <%=rs2.getDate(6) %></td>
<td> <a href="employeedelete?id=<%=rs2.getInt(1)%>">Delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>