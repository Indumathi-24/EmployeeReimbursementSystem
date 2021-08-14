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
import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;

public class EmployeeLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cPassword=request.getParameter("confirmPassword");
		
		EmployeeLogin eLogin = new EmployeeLogin();
		eLogin.setEmail(email);
		eLogin.setPassword(password);
		eLogin.setConfirmPswrd(cPassword);
		EmployeeLoginEntity loginEntity= new EmployeeLoginEntity();
		EmployeeLoginService employeeLoginService =new EmployeeLoginServiceImpl();
		employeeLoginService.addEmployeeLogin(eLogin);
		System.out.println("Login Success");
		response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/LoginValidation.html");	
		
	}

}
