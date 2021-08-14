package com.revature.dao;

import java.util.ArrayList;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.entity.EmployeeEntity;
import com.revature.entity.EmployeeReimbursementEntity;
import com.revature.mapper.EmployeeMapper;
import com.revature.mapper.EmployeeReimbursementMapper;
import com.revature.model.Employee;
import com.revature.model.EmployeeReimbursement;
import com.revature.util.HibernateUtil;

public class EmployeeReimbursementDAOImpl implements EmployeeReimbursementDAO{
	public void addEmployeeRequest(EmployeeReimbursement employeeRequest,String email) {
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();  
			
			EmployeeReimbursementEntity ee=EmployeeReimbursementMapper.mapEmployeeReimbursement(employeeRequest,email);
			session.save(ee);
			System.out.println("employee inserted...");
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
}
	public List<EmployeeReimbursementEntity> viewPendingRequests(String email) {
		System.out.println("In DaO");
		List<EmployeeReimbursementEntity> pendingList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity where email=:userId and status=:status");
			query.setParameter("userId", email);
			query.setParameter("status", "Pending");
			pendingList = query.list();
            System.out.println(pendingList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return pendingList;
	}
	public List<EmployeeReimbursementEntity> viewApprovedRequests(String email) {
		System.out.println("In Approved Method DaO");
		List<EmployeeReimbursementEntity> approvedList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity  where email=:userId and status=:status");

			query.setParameter("userId", email);
			query.setParameter("status", "Approved");
			approvedList = query.list();
		     System.out.println(approvedList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("out Approved method DaO");
		return approvedList;
	}
	public List<EmployeeReimbursementEntity> viewDeniedRequests(String email) {
		System.out.println("In Denied Method DaO");
		List<EmployeeReimbursementEntity> deniedList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity  where email=:userId and status=:status");

			query.setParameter("userId", email);
			query.setParameter("status", "Denied");
			deniedList = query.list();
		    System.out.println(deniedList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("out Denied method DaO");
		return deniedList;
	}
	public List<EmployeeReimbursementEntity> viewAllPendingRequests() {
		System.out.println("In DaO");
		List<EmployeeReimbursementEntity> pendingList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity where status=:status");
			query.setParameter("status", "Pending");
			pendingList = query.list();
            System.out.println(pendingList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return pendingList;
	}
	public List<EmployeeReimbursementEntity> viewAllApprovedRequests() {
		System.out.println("In DaO");
		List<EmployeeReimbursementEntity> approvedList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity where status=:status");
			query.setParameter("status", "Approved");
			approvedList = query.list();
            System.out.println(approvedList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return approvedList;
	}
	public List<EmployeeReimbursementEntity> viewAllDeniedRequests() {
		System.out.println("In DaO");
		List<EmployeeReimbursementEntity> deniedList = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from EmployeeReimbursementEntity where status=:status");
			query.setParameter("status", "Denied");
			deniedList = query.list();
            System.out.println(deniedList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return deniedList;
	}
	public List<Integer> getRequestId(){
		List<Integer> requestIdList=new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		  Query query =session.createQuery("Select requestId from EmployeeReimbursementEntity where status=:status");
		  query.setParameter("status","Pending");
		  requestIdList=query.list();
		  System.out.println(requestIdList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return requestIdList;
	}
	
    public List<EmployeeReimbursementEntity> getRequestDetails(int requestId){
		List<EmployeeReimbursementEntity> requestList=new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		  Query query =session.createQuery("from EmployeeReimbursementEntity where requestId=:rId");
		  query.setParameter("rId", requestId);
		  requestList=query.list();
		  System.out.println(requestList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return requestList;
	}
    public void updateRequestStatus(int requestId, String managerView) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query=session.createQuery("update EmployeeReimbursementEntity set status=:status where requestId=:rId");
			query.setParameter("status",managerView);
			query.setParameter("rId", requestId);
		    query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Rows Updated");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
    public List<EmployeeReimbursementEntity> getUserRequestDetails(String email){
    	List<EmployeeReimbursementEntity> userRequestList=new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		  Query query =session.createQuery("from EmployeeReimbursementEntity where email=:eId");
		  query.setParameter("eId",email);
		  userRequestList=query.list();
		  System.out.println(userRequestList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Out DaO");
		return userRequestList;
    }
}