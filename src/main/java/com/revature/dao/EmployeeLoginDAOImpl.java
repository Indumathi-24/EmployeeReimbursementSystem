package com.revature.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.entity.EmployeeEntity;
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

public void updateForgotPassword(String email, String passWord) {
	List<Integer> idList = new ArrayList<>();
	List<String> passWordList = new ArrayList<String>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
		Query query = session.createQuery("select id from  EmployeeLoginEntity  where email=:userName");
		query.setParameter("userName", email);
		idList = query.list();
		int loginId = idList.get(0);
		Query passWordQuery = session.createQuery("select password from EmployeeLoginEntity  where email=:userName");
		passWordQuery.setParameter("userName", email);
		passWordList = passWordQuery.list();
		String previousPassWord = passWordList.get(0);
		if (!passWord.equals(previousPassWord)) { 
			session.beginTransaction();
			Query newPasswordQuery = session.createQuery("UPDATE EmployeeLoginEntity set password=:pwd,confirmPswrd=:cPwd" + " where id=:userId");
			newPasswordQuery.setParameter("pwd", passWord);
			newPasswordQuery.setParameter("cPwd",passWord);
			newPasswordQuery.setParameter("userId", loginId);
			int count =newPasswordQuery.executeUpdate();
			System.out.println(count + " " + "Rows updated");
			session.close();
		}
	} catch (HibernateException e) {
		e.printStackTrace();
	} 
	}
	public String getEmployeeType(String email) {
		List<EmployeeEntity> entityList=new ArrayList<>();
		String empType=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query=session.createQuery("from EmployeeEntity where email=:userId");
			query.setParameter("userId",email);
			entityList=query.list();
			for(EmployeeEntity entity:entityList) {
				empType=entity.getType();
				session.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			}
		return empType;
		}
}
