package com.mypack.spring;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String email;
	@Column
	private long salary;

	public Employee() {

	}

	public Employee(int empid, String fname, String lname, String email, long salary) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", salary="
				+ salary + "]";
	}

}
