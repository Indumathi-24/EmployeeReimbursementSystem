package com.revature.dao;

import java.util.List;

import com.revature.entity.EmployeeEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeReimbursement;

public interface EmployeeRegDAO {
	public void addEmployee(Employee employee);
	public List<EmployeeEntity> viewEmployeeDetails(String email);
	public void updateEmployeeDetails(Employee employee);
	public List<String> getUserEmail();
	public List<EmployeeEntity> getAllEmployee();
}
