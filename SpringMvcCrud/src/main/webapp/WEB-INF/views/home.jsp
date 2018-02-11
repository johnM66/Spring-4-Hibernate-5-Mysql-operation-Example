<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Crud Operation</title>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 12px;
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
</head>
<body>
	<h2>Add Employee</h2>
	<form:form method="POST" action="save">
		<table >
			<tr>
				<td><form:label path="empid">Employee Id:</form:label></td>
				<td><form:input path="empid" value="${employee.empid}"
						readonly="true" disabled="true"/></td>
			</tr>
			<tr>
				<td><form:label path="fname">Employee First Name:</form:label></td>
				<td><form:input path="fname" value="${employee.fname}" /></td>
			</tr>
			<tr>
				<td><form:label path="lname">Employee Last Name:</form:label></td>
				<td><form:input path="lname" value="${employee.lname}" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Employee Email:</form:label></td>
				<td><form:input path="email" value="${employee.email}" /></td>
			</tr>

			<tr>
				<td><form:label path="salary">Employee salary:</form:label></td>
				<td><form:input path="salary" value="${employee.salary}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	
		<h2>List Employees</h2>
		<table id="customers">
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Salary</th>
				<th>Click For Edit/Delete</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.empid}</td>
					<td>${employee.fname}</td>
					<td>${employee.lname}</td>
					<td>${employee.email}</td>
					<td>${employee.salary}</td>
 <td align="center"><a href="update?empid=${employee.empid}">Edit</a> <a href="delete?id=${employee.empid}">Delete</a></td>					
				</tr>
			</c:forEach>
		</table>
		
</body>
</html>
