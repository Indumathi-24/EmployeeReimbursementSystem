package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		EmployeeLoginService employeeLoginService =new EmployeeLoginServiceImpl();
		
		employeeLoginService.addEmployeeLogin(eLogin);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<script> alert('Login Success')</script>");
		out.println("</body>");
		out.println("<html>");
		
		
	}

}
