package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.EmployeeReimbursement;

import com.revature.service.EmployeeReimbursementService;
import com.revature.service.EmployeeReimbursementServiceImpl;


public class EmployeeReimbursementServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String requestId=request.getParameter("requestId");
		String date=request.getParameter("date");
		String amount=request.getParameter("amount");
		String type=request.getParameter("type");
		String status=request.getParameter("status");
		
		int reimburseAmount=Integer.parseInt(amount);
		int id=Integer.parseInt(requestId);
		
		EmployeeReimbursement reimbursement=new EmployeeReimbursement();
		reimbursement.setDate(date);
		reimbursement.setRequestId(id);
		reimbursement.setAmount(reimburseAmount);
		reimbursement.setStatus(status);
		reimbursement.setType(type);
		Cookie c[]=request.getCookies();
		String email=c[0].getValue();
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i].getName()+" "+c[i].getValue());
		}
		EmployeeReimbursementService employeeService =new EmployeeReimbursementServiceImpl();
		employeeService.addEmployeeRequest(reimbursement,email);
		System.out.println("Reimbursement Success");
		response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/Employee.html");
		
		
	}

}
