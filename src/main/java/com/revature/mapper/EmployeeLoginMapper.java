package com.revature.mapper;

import com.revature.entity.EmployeeEntity;
import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeLogin;

public class EmployeeLoginMapper {
	public static EmployeeLoginEntity mapEmployee(EmployeeLogin e) {
		EmployeeLoginEntity entity=new EmployeeLoginEntity();
		entity.setEmail(e.getEmail());
		entity.setPassword(e.getPassword());
		entity.setConfirmPswrd(e.getConfirmPswrd());;
		
		return entity;
		
	}
}
