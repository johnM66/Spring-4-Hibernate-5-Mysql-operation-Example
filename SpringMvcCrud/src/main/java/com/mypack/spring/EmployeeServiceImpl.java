package com.mypack.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void createEmployee(Employee employee) {
		empDao.createEmployee(employee);

	}
	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.updateEmployee(employee);

	}
	@Transactional
	@Override
	public void deleteEmployeee(int id) {
		empDao.deleteEmployeee(id);
	}
	@Transactional
	@Override
	public Employee getEmployeeId(int id) {
		Employee emp=empDao.getEmployeeId(id);
		return emp;
	}
	@Transactional
	@Override
	public List<Employee> getAllEmployee() {
		
	List<Employee> empList = empDao.getAllEmployee();
	return empList;
	}

}
