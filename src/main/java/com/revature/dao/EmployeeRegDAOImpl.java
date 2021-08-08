package com.revature.dao;

import org.hibernate.Session;

import com.revature.entity.EmployeeEntity;
import com.revature.mapper.EmployeeMapper;
import com.revature.model.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeRegDAOImpl implements EmployeeRegDAO {
	public void addEmployee(Employee employee) {
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();  
			
			EmployeeEntity ee=EmployeeMapper.mapEmployee(employee);
			session.save(ee);
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
 }



}
