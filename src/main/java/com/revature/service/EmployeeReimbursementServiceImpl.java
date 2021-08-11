package com.revature.service;


import com.revature.dao.EmployeeReimbursementDAO;
import com.revature.dao.EmployeeReimbursementDAOImpl;
import com.revature.model.EmployeeReimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService{
	EmployeeReimbursementDAO employeeReimbursementDao=new EmployeeReimbursementDAOImpl();
	 public void addEmployeeRequest(EmployeeReimbursement e) {
		 employeeReimbursementDao.addEmployeeRequest(e);
		 
	 }
}
