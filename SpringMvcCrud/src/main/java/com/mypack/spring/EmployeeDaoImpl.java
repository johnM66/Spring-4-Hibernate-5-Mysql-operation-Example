package com.mypack.spring;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (employee != null) {
			try {
				session.saveOrUpdate(employee);
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		if (employee != null) {
			try {
				session.update(employee);
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}

		return employee;
	}

	@Override
	public void deleteEmployeee(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = new Employee();
		try {
			emp = session.get(Employee.class, id);
			session.delete(emp);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
	}

	@Override
	public Employee getEmployeeId(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = null;

		try {
			emp = session.get(Employee.class, id);
			if (emp != null) {
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		List list = session.createQuery("from com.mypack.spring.Employee").list();
		return list;
	}

}
