package com.revature.dao;

import org.hibernate.Session;


import com.revature.entity.EmployeeLoginEntity;
import com.revature.mapper.EmployeeLoginMapper;
import com.revature.model.EmployeeLogin;
import com.revature.util.HibernateUtil;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {
	public void addEmployeeLogin(EmployeeLogin eLogin) {
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();  
			
			EmployeeLoginEntity ee=EmployeeLoginMapper.mapEmployee(eLogin);
			session.save(ee);
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
}
}