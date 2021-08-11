package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
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
		try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeReimbursement reimbursement=new EmployeeReimbursement();
		reimbursement.getRequestId();
		reimbursement.getDate();
		reimbursement.getType();
		reimbursement.getAmount();
		reimbursement.getStatus();
		 
		EmployeeReimbursementService employeeService =new EmployeeReimbursementServiceImpl();
		employeeService.addEmployeeRequest(reimbursement);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<script> alert('Reimbursement request Sent Successfully')</script>");
		out.println("</body>");
		out.println("<html>");
		
		
	}

}
