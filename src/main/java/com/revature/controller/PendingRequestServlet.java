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


public class PendingRequestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Pending Requests of "+" "+userName+"</h1>");
		EmployeeReimbursementService reimbursementRequest = new EmployeeReimbursementServiceImpl();
		List<EmployeeReimbursementEntity> pendingList =reimbursementRequest.viewPendingRequests(userName);
		System.out.println(pendingList);
		for(EmployeeReimbursementEntity r: pendingList)
		{
			System.out.println(r.getDate());
			System.out.println(userName);
			System.out.println(r.getStatus());
			System.out.println(r.getType());
			System.out.println(r.getAmount());
			System.out.println(r.getRequestId());
		}
		out.println("<table border='2'>");
		out.println("<tr><td>Request Id</td>");
		out.println("<td>Type</td>");
		out.println("<td>Amount</td>");
		out.println("<td>Status</td>");
		out.println("<td>Date</td></tr>");
		for(EmployeeReimbursementEntity elist :pendingList)
		{
			
			out.println("<tr><td>"+elist.getRequestId()+"</td>");
			out.println("<td>"+elist.getType()+"</td>");
			out.println("<td>"+elist.getAmount()+"</td>");
			out.println("<td>"+elist.getStatus()+"</td>");
			out.println("<td>"+elist.getDate()+"</td></tr>");
		}
        out.println("</table>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/Employee.html'> <input type='submit' value='Back to Home'></form> ");
		out.println("</center>");
	    out.println("</body>");
	}
	
}


