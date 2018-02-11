<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: red;
}
</style>
<title>All Employees</title>
</head>
<body>
<h1>List Employees</h1>
<h3><a href="add.html">Add More Employee</a></h3>

		<h2>List Employees</h2>
		<table id="customers">
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Salary</th>
				
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.empid}</td>
					<td>${employee.fname}</td>
					<td>${employee.lname}</td>
					<td>${employee.email}</td>
					<td>${employee.salary}</td>
 
				</tr>
			</c:forEach>
		</table>
	