package com.revature.service;

import com.revature.dao.EmployeeRegDAO;
import com.revature.dao.EmployeeRegDAOImpl;
import com.revature.model.Employee;

public class EmployeeRegServiceImpl implements EmployeeRegService{
	EmployeeRegDAO employeeDao=new EmployeeRegDAOImpl();
	 public void addEmployee(Employee e) {
		 employeeDao.addEmployee(e);
		 
	 }
}
