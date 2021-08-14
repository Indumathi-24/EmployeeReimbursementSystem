package com.revature.dao;

import java.util.List;


import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeLogin;

public interface EmployeeLoginDAO {
	public void addEmployeeLogin(EmployeeLogin eLogin);
	public List<EmployeeLoginEntity> validateEmployeeLogin();
	public void updateForgotPassword(String email, String passWord);
	public String getEmployeeType(String email);
}
