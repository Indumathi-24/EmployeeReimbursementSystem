package com.revature.dao;

import java.util.ArrayList;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.entity.EmployeeLoginEntity;
import com.revature.mapper.EmployeeLoginMapper;
import com.revature.model.EmployeeLogin;
import com.revature.util.HibernateUtil;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {
	public void addEmployeeLogin(EmployeeLogin eLogin) {
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();  
			
			EmployeeLoginEntity ee=EmployeeLoginMapper.mapEmployeeLogin(eLogin);
			session.save(ee);
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
}
	
public List<EmployeeLoginEntity> validateEmployeeLogin() {
	  List<EmployeeLoginEntity> eList=new ArrayList<EmployeeLoginEntity>();
      try {
			System.out.println("In dao");
			Session session=HibernateUtil.getSessionFactory().openSession();
			Query q=session.createQuery("from EmployeeLoginEntity e");
			eList=q.list();
			}
       catch (Exception e1) {
	
	      e1.printStackTrace();
         }
 
      return eList;
}
}