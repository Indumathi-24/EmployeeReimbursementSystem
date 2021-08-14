package com.revature.service;

import java.util.List;

import com.revature.entity.EmployeeReimbursementEntity;
import com.revature.model.Employee;
import com.revature.model.EmployeeReimbursement;

public interface EmployeeReimbursementService {
	public void addEmployeeRequest(EmployeeReimbursement employeeRequest,String email);
	public List<EmployeeReimbursementEntity> viewPendingRequests(String email);
	public List<EmployeeReimbursementEntity> viewApprovedRequests(String email);
	public List<EmployeeReimbursementEntity> viewDeniedRequests(String email);
	public List<EmployeeReimbursementEntity> viewAllPendingRequests();
	public List<EmployeeReimbursementEntity> viewAllApprovedRequests();
	public List<EmployeeReimbursementEntity> viewAllDeniedRequests();
	public List<Integer> getRequestId();
	public List<EmployeeReimbursementEntity> getRequestDetails(int requestId);
	public void updateRequestStatus(int requestId, String managerView);
	public List<EmployeeReimbursementEntity> getUserRequestDetails(String email);
}
