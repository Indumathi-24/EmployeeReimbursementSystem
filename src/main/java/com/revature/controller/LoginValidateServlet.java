package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.EmployeeLoginEntity;
import com.revature.model.EmployeeLogin;
import com.revature.service.EmployeeLoginService;
import com.revature.service.EmployeeLoginServiceImpl;


public class LoginValidateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		
	
		EmployeeLoginService employeeLoginService =new EmployeeLoginServiceImpl();
		
		List<EmployeeLoginEntity> eList=new ArrayList<EmployeeLoginEntity>();
		eList=employeeLoginService.validateEmployeeLogin();
		System.out.println("Enter in List");
		for(EmployeeLoginEntity e:eList) {
			System.out.println(e.getUserName()+ " "+e.getPassword());
		}
		//for(EmployeeLoginEntity e:eList) {
			//if(e.getUserName().equals(email) && e.getPassword().equals(password)) {
				
				//response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/Employee.html");
			//}
		//}
		
		
		
		
	}
	}


