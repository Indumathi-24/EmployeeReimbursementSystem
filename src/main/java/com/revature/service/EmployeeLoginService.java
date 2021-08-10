package com.revature.service;

import java.util.List;

import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.EmployeeLogin;

public interface EmployeeLoginService {
     public void addEmployeeLogin(EmployeeLogin eLogin);
     public List<EmployeeLoginEntity> validateEmployeeLogin();
}
