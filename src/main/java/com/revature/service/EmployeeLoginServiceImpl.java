package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeLoginDAO;
import com.revature.dao.EmployeeLoginDAOImpl;
import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.EmployeeLogin;

public class EmployeeLoginServiceImpl implements EmployeeLoginService {
	EmployeeLoginDAO employeeLoginDao=new EmployeeLoginDAOImpl();
	 public void addEmployeeLogin(EmployeeLogin e) {
		 employeeLoginDao.addEmployeeLogin(e);
		 
	 }
	 List<EmployeeLoginEntity> eList=new ArrayList<EmployeeLoginEntity>();
	 public List<EmployeeLoginEntity> validateEmployeeLogin() {
		 eList=employeeLoginDao.validateEmployeeLogin();
		 return eList;
	 }
	 
	
	 public void updateForgotPassword(String email, String passWord) {
		 employeeLoginDao.updateForgotPassword(email,passWord);
		 
	 }
	 public String getEmployeeType(String email) {
		 return  employeeLoginDao.getEmployeeType(email);
	 }
	 
	 
}
