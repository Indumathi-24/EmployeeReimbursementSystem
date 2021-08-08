package com.revature.mapper;

import com.revature.entity.EmployeeEntity;
import com.revature.model.Employee;

public class EmployeeMapper {
	public static EmployeeEntity mapEmployee(Employee e) {
		EmployeeEntity entity=new EmployeeEntity();
		entity.setEmployeeName(e.getEmployeeName());
		entity.setAddress(e.getAddress());
		entity.setDob(e.getDob());
		entity.setEmail(e.getEmail());
		entity.setGender(e.getGender());
		entity.setMobileNo(e.getMobileNo());;
		entity.setType(e.getType());
		entity.setAge(e.getAge());
		return entity;
		
	}
}
