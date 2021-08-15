package com.revature.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.entity.EmployeeEntity;
import com.revature.entity.EmployeeLoginEntity;

public class EmployeeRegDAOImplTest {
	EmployeeRegDAO regDAO =new EmployeeRegDAOImpl();
	@Test
	public void testGetUserEmail() {
		 List<String> regEntity=new ArrayList<String>();
		 regEntity=regDAO.getUserEmail();
		 assertNotNull(regEntity);
	}

	@Test
	public void testGetAllEmployee() {
		 List<EmployeeEntity> entity=new ArrayList<EmployeeEntity>();
		 entity=regDAO.getAllEmployee();
		 assertNotNull(entity);
	}

}
