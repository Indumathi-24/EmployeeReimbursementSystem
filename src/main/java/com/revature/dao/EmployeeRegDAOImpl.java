package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public List<EmployeeEntity> viewEmployeeDetails(String email) {
    List<EmployeeEntity> eList=new ArrayList<EmployeeEntity>();
    Session session=HibernateUtil.getSessionFactory().openSession();
    try {
			
			Query q=session.createQuery("from EmployeeEntity e where email=:id");
			q.setParameter("id", email);
			eList=q.list();
			}
       catch (Exception e1) {
	
	      e1.printStackTrace();
         }
      
      session.close();
      return eList;
    }
    public void updateEmployeeDetails(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			System.out.println("In update dao");
			session.beginTransaction();
			EmployeeEntity employeeRegEntity = EmployeeMapper.mapEmployee(employee);
			session.find(EmployeeEntity.class, employeeRegEntity.getEmail());
			EmployeeEntity employeeEntity = session.load(EmployeeEntity.class, employeeRegEntity.getEmail());
			employeeEntity.setEmployeeName(employeeRegEntity.getEmployeeName());
			employeeEntity.setAddress(employeeRegEntity.getAddress());
			employeeEntity.setDob(employeeRegEntity.getDob());
			employeeEntity.setAge(employeeRegEntity.getAge());
			employeeEntity.setGender(employeeRegEntity.getGender());
			employeeEntity.setEmail(employeeRegEntity.getEmail());
			employeeEntity.setMobileNo(employeeRegEntity.getMobileNo());
			employeeEntity.setType(employeeRegEntity.getType());
			session.merge(employeeEntity);
			session.flush();
			session.getTransaction().commit();
			System.out.println("Data updated successfully");
			System.out.println("Out update dao");
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		session.close();
	}
    public List<String> getUserEmail() {
    	List<String> emailList=new ArrayList<String>();
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query=session.createQuery("select email from EmployeeEntity");
			emailList=query.list();
			System.out.println(emailList);
			 session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 	
		return emailList;	
    }
    public List<EmployeeEntity> getAllEmployee(){
    	List<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();
    	Session session =HibernateUtil.getSessionFactory().openSession();
    	try {
    		Query query=session.createQuery("from EmployeeEntity where type=:eType");
    		query.setParameter("eType","Employee");
    		employeeList=query.list();
    		System.out.println(employeeList);
    		session.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return employeeList;
    }

}
;