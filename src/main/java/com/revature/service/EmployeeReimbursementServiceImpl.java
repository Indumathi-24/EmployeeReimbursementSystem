package com.revature.service;


import java.util.List;

import com.revature.dao.EmployeeReimbursementDAO;
import com.revature.dao.EmployeeReimbursementDAOImpl;
import com.revature.entity.EmployeeReimbursementEntity;
import com.revature.model.EmployeeReimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService{
	EmployeeReimbursementDAO employeeReimbursementDao=new EmployeeReimbursementDAOImpl();
	 public void addEmployeeRequest(EmployeeReimbursement e,String email) {
		 employeeReimbursementDao.addEmployeeRequest(e,email);
		 
	 }
	 public List<EmployeeReimbursementEntity> viewPendingRequests(String email){
		 return employeeReimbursementDao.viewPendingRequests(email);
	 }
	 public List<EmployeeReimbursementEntity> viewApprovedRequests(String email){
		 return employeeReimbursementDao.viewApprovedRequests(email);
	 }
	 public List<EmployeeReimbursementEntity> viewDeniedRequests(String email){
		 return employeeReimbursementDao.viewDeniedRequests(email);
	 }
	 public List<EmployeeReimbursementEntity> viewAllPendingRequests(){
		 return employeeReimbursementDao.viewAllPendingRequests();
	 }
	 public List<EmployeeReimbursementEntity> viewAllApprovedRequests(){
		 return employeeReimbursementDao.viewAllApprovedRequests();
	 }
	 public List<EmployeeReimbursementEntity> viewAllDeniedRequests(){
		 return employeeReimbursementDao.viewAllDeniedRequests();
	 }
	 public List<Integer> getRequestId(){
		 return employeeReimbursementDao.getRequestId();
	 }
	 public List<EmployeeReimbursementEntity> getRequestDetails(int requestId){
		 return employeeReimbursementDao.getRequestDetails(requestId);
	 }
	 public void updateRequestStatus(int requestId, String managerView){
		  employeeReimbursementDao.updateRequestStatus(requestId,managerView);
	 }
	 public List<EmployeeReimbursementEntity> getUserRequestDetails(String email){
	     return employeeReimbursementDao.getUserRequestDetails(email);
	 }
}
