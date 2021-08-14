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


public class ManagerSelectRequestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome "+" "+userName+"</h1>");
		out.println("<h3>Request Ids Of All Employees</h3>");
		EmployeeReimbursementService reimbursementRequest = new EmployeeReimbursementServiceImpl();
		List<Integer> requestIdList =reimbursementRequest.getRequestId();
		System.out.println(requestIdList);
		for(Integer r: requestIdList)
		{
			System.out.println(r);
		}
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/ManagerViewRequestServlet'> ");
		out.println("<table border='2'>");
		out.println("<tr><td>Request Id</td>");
		out.println("<td><select name='requestId' >");
		for(Integer elist :requestIdList)
		{
			
			out.println("<option>"+elist+"</option>");
			
		}
		out.println("</select></td></tr>");
        out.println("</table>");
        out.println("<input type='submit' value='Submit'></form> ");
		out.println("</center>");
	    out.println("</body>");
	}
	}
