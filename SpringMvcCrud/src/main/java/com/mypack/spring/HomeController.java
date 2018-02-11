package com.mypack.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	@Autowired
	private EmployeeService services;

	public void setService(EmployeeService services) {
		this.services = services;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("command") Employee employee,BindingResult result) {
		
		
		services.createEmployee(employee);
		
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("redirect:index");
	}
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	 public ModelAndView listEmployees() {
		Employee e = new Employee();
	  Map<String, Object> model = new HashMap<String ,Object>();
	  model.put("emp", e);
	  model.put("employees", services.getAllEmployee());
	  return new ModelAndView("employeesList", model);
	 }
	
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public ModelAndView saveEmployee(@ModelAttribute("command")Employee employee,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("employees",services.getAllEmployee());
	  return new ModelAndView("home", model);
	 }
	
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	 public ModelAndView welcome() {
	   return new ModelAndView("index");
	  }
	
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public ModelAndView editEmployee(@ModelAttribute("command")Employee employee,@RequestParam int id,BindingResult result) {
		 services.deleteEmployeee(id);
	   Map<String, Object> model = new HashMap<String, Object>();
	   model.put("employee", null);
	   model.put("employees",services.getAllEmployee());
	   return new ModelAndView("home", model);
	  }
	  
	 @RequestMapping(value = "/update", method = RequestMethod.GET)
	 public ModelAndView updateEmployee(@ModelAttribute("command") Employee employee,@RequestParam int empid,
	    BindingResult result) {
	   Map<String, Object> model = new HashMap<String, Object>();
	   Employee e=services.getEmployeeId(empid);
	   e.setEmail(employee.getEmail());
	   e.setFname(employee.getFname());
	   e.setLname(employee.getLname());
	   e.setSalary(employee.getSalary());
	   services.updateEmployee(e);
	   
	  
	   model.put("employee", services.getEmployeeId(empid));
	  // model.put("employee", services.updateEmployee(e));
	   model.put("employees",services.getAllEmployee());
	   return new ModelAndView("update", model);
	   
	   
	  }
	 
	

	/*@RequestMapping(value = "/index")
	public String home(Map<String, Object> map) {
		Employee e = new Employee();
		map.put("emp", e);
		map.put("empList", service.getAllEmployee());

		return "home";
	}
	@RequestMapping(value = "/employee.do",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Employee emp,BindingResult result,String action,Map<String,Object>map) {
		Employee e=new Employee();
		switch (action.toLowerCase()) {
		case "add":
			service.createEmployee(emp);
			e=emp;
			break;
		case "update":
			service.updateEmployee(emp);
			e=emp;
			break;
		case "delete":
			service.deleteEmployeee(emp.getEmpid());
			e=new Employee();
			break;
		case "search":
			Employee singleEmp = service.getEmployeeId(emp.getEmpid());
			e=singleEmp!=null?singleEmp:new Employee();
			break;

		default:
			map.put("emp", e);
			map.put("empList", service.getAllEmployee());
			break;
		}
		return "student";
	}

*/}
