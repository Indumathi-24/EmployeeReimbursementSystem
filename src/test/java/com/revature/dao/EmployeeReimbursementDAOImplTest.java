package com.revature.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.revature.entity.EmployeeReimbursementEntity;

public class EmployeeReimbursementDAOImplTest {
	EmployeeReimbursementDAO reimbursementDAO =new EmployeeReimbursementDAOImpl();
	@Test
	public void testViewAllPendingRequests() {
		List<EmployeeReimbursementEntity> entity=new ArrayList<EmployeeReimbursementEntity>();
		 entity=reimbursementDAO.viewAllPendingRequests();
		 assertNotNull(entity);
	}

	@Test
	public void testViewAllApprovedRequests() {
		List<EmployeeReimbursementEntity> entity=new ArrayList<EmployeeReimbursementEntity>();
		entity=reimbursementDAO.viewAllApprovedRequests();
		assertNotNull(entity);
	}

	@Test
	public void testViewAllDeniedRequests() {
		List<EmployeeReimbursementEntity> entity=new ArrayList<EmployeeReimbursementEntity>();
		 entity=reimbursementDAO.viewAllDeniedRequests();
		 assertNotNull(entity);
	}

	@Test
	public void testGetRequestId() {
		List<Integer> entity=new ArrayList<Integer>();
		 entity=reimbursementDAO.getRequestId();
		 assertNotNull(entity);
	}
}
