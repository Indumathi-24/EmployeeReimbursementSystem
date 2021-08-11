package com.revature.dao;

import org.hibernate.Session;

import com.revature.entity.EmployeeEntity;
import com.revature.mapper.EmployeeMapper;
import com.revature.mapper.EmployeeReimbursementMapper;
import com.revature.model.Employee;
import com.revature.model.EmployeeReimbursement;
import com.revature.util.HibernateUtil;

public class EmployeeReimbursementDAOImpl implements EmployeeReimbursementDAO{
	public void addEmployee(EmployeeReimbursement employeeRequest) {
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();  
			
			EmployeeEntity ee=EmployeeReimbursementMapper.mapEmployeeReimbursement(employeeRequest);
			session.save(ee);
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
}
