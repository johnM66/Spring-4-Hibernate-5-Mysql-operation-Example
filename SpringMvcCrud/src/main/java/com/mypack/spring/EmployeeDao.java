package com.mypack.spring;

import java.util.List;



public interface EmployeeDao {
	public void createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployeee(int id);
	public Employee getEmployeeId(int id);
	public List<Employee> getAllEmployee();

}
