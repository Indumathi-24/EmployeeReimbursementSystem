package com.revature.service;

import com.revature.dao.EmployeeLoginDAO;
import com.revature.dao.EmployeeLoginDAOImpl;
import com.revature.model.EmployeeLogin;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {
	EmployeeLoginDAO employeeLoginDao=new EmployeeLoginDAOImpl();
	 public void addEmployeeLogin(EmployeeLogin e) {
		 employeeLoginDao.addEmployeeLogin(e);
		 
	 }
}
