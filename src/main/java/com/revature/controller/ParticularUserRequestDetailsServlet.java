package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.EmployeeReimbursementEntity;
import com.revature.service.EmployeeReimbursementService;
import com.revature.service.EmployeeReimbursementServiceImpl;

public class ParticularUserRequestDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		String eId=request.getParameter("email");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome "+" "+userName+"</h1>");
		out.println("<h3>Request Details of Particular User</h3>");
		EmployeeReimbursementService reimbursementRequest = new EmployeeReimbursementServiceImpl();
		List<EmployeeReimbursementEntity> requestDetailsList =reimbursementRequest.getUserRequestDetails(eId);
		for (EmployeeReimbursementEntity re : requestDetailsList) {
			System.out.println(re.getRequestId());
			System.out.println(re.getUserEmail().getEmail());
			System.out.println(re.getUserEmail().getEmployeeName());
			System.out.println(re.getDate());
			System.out.println(re.getStatus());
			System.out.println(re.getType());
			System.out.println(re.getAmount());
		}
		
		out.println("<table border='2'>");
		for(EmployeeReimbursementEntity re : requestDetailsList)
		{
			out.println("<tr><td>Employee Email</td>"+"<td>"+"<input type='text' name='email' value="+re.getUserEmail().getEmail()+">"+"</td></tr>");
			out.println("<tr><td>Employee Name</td>"+"<td>"+"<input type='text' name='name' value="+re.getUserEmail().getEmployeeName()+">"+"</td></tr>");
			out.println("<tr><td>Request Id</td>"+"<td>"+"<input type='text' name='requestId' value="+re.getRequestId()+">"+"</td></tr>");
			out.println("<tr><td>Date</td>"+"<td>"+"<input type='date' name='date' value="+re.getDate()+">"+"</td></tr>");
			out.println("<tr><td>Type</td>"+"<td>"+"<input type='text' name='type' value="+re.getType()+">"+"</td></tr>");
			out.println("<tr><td>Amount</td>"+"<td>"+"<input type='number' name='amount' value="+re.getAmount()+">"+"</td></tr>");
			out.println("<tr><td>Status</td>"+"<td>"+"<input type='text' name='status' value="+re.getStatus()+">"+"</td></tr>");
		}
		out.println("</table>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/Manager.html'><input id='submitButton' type='submit' value='Back To Home'>");
		out.println("</center>");
		out.println("</form>");
		out.println("</body>");
		
	}
	}


