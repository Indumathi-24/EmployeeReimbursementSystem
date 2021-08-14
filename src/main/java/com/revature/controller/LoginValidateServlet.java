package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		
		
	    System.out.println(email+" "+password);
	    Cookie cUserName=new Cookie("cusername",email);
		response.addCookie(cUserName);
		EmployeeLoginService employeeLoginService =new EmployeeLoginServiceImpl();
		String employeeType = employeeLoginService.getEmployeeType(email);
		List<EmployeeLoginEntity> eList=new ArrayList<EmployeeLoginEntity>();
		eList=employeeLoginService.validateEmployeeLogin();
		System.out.println("Enter in List");
		for(EmployeeLoginEntity e:eList) {
		   if(e.getUserName().getEmail().equals(email) && e.getPassword().equals(password) && employeeType.equals("Employee")) {
			   System.out.println("Login validation success");
				response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/Employee.html");
			}
		   if(e.getUserName().getEmail().equals(email) && e.getPassword().equals(password) && employeeType.equals("Manager")) {
			   System.out.println("Login validation success");
				response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/Manager.html");
			}
		   
		}	
		
	}
	}


