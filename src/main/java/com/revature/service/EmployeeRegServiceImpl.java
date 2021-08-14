package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeRegDAO;
import com.revature.dao.EmployeeRegDAOImpl;
import com.revature.entity.EmployeeEntity;
import com.revature.model.Employee;

public class EmployeeRegServiceImpl implements EmployeeRegService{
	EmployeeRegDAO employeeDao=new EmployeeRegDAOImpl();
	 public void addEmployee(Employee e) {
		 employeeDao.addEmployee(e);
		 
	 }
	 
	 public List<EmployeeEntity> viewEmployeeDetails(String email) {
		 List<EmployeeEntity> eList=new ArrayList<EmployeeEntity>();
		 eList=employeeDao.viewEmployeeDetails(email);	
		 return eList;
	 }
	 
	 public void updateEmployeeDetails(Employee e) {
		 employeeDao.updateEmployeeDetails(e);
		 
	 }
	 public List<String> getUserEmail(){
		 return employeeDao.getUserEmail();
	 }
	 public List<EmployeeEntity> getAllEmployee(){
		 return employeeDao.getAllEmployee();
	 }
}
