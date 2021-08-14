package com.revature.mapper;

import com.revature.entity.EmployeeEntity;
import com.revature.entity.EmployeeLoginEntity;
import com.revature.entity.EmployeeReimbursementEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeReimbursement;

public class EmployeeReimbursementMapper {
	public static EmployeeReimbursementEntity mapEmployeeReimbursement(EmployeeReimbursement e,String email) {
		EmployeeReimbursementEntity entity=new EmployeeReimbursementEntity();
		EmployeeEntity regEntity = new EmployeeEntity();
		regEntity.setEmail(email);
		entity.setUserEmail(regEntity);
		entity.setAmount(e.getAmount());
		entity.setStatus(e.getStatus());
		entity.setType(e.getType());
		entity.setRequestId(e.getRequestId());
		entity.setDate(e.getDate());
		return entity;
}
}
	
