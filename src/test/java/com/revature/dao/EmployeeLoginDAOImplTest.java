package com.revature.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.entity.EmployeeLoginEntity;

public class EmployeeLoginDAOImplTest {

	@Test
	public void testValidateEmployeeLogin() {
	   List<EmployeeLoginEntity> loginEntity=new ArrayList<EmployeeLoginEntity>();
	   EmployeeLoginDAO loginDAO =new EmployeeLoginDAOImpl();
	   loginEntity=loginDAO.validateEmployeeLogin();
	   assertNotNull(loginEntity);
	}
}
