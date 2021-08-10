package com.revature.mapper;

import com.revature.entity.EmployeeEntity;
import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeLogin;

public class EmployeeLoginMapper {
	public static EmployeeLoginEntity mapEmployeeLogin(EmployeeLogin e) {
		EmployeeLoginEntity loginEntity=new EmployeeLoginEntity();
		EmployeeEntity entity=new EmployeeEntity();
		entity.setEmail(e.getEmail());
		loginEntity.setUserName(entity);
		loginEntity.setPassword(e.getPassword());
		loginEntity.setConfirmPswrd(e.getConfirmPswrd());;
		
		return loginEntity;
		
	}
}
