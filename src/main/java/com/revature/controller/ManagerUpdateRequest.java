package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeReimbursementService;
import com.revature.service.EmployeeReimbursementServiceImpl;


public class ManagerUpdateRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerAction = "";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie c[] = request.getCookies();
		String userName = c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome" + " " + userName + "</h1>");
		String requestId = request.getParameter("requestId");
		String action = request.getParameter("managerAction");
		int rId=Integer.parseInt(requestId);
		if (action.equals("Approve")) {
			managerAction = "Approved";
		} else {
			managerAction = "Denied";
		}
		System.out.println(requestId + " " + managerAction);
		EmployeeReimbursementService requestService = new EmployeeReimbursementServiceImpl();
		requestService.updateRequestStatus(rId, managerAction);
			out.println("<center>");
			out.println("<a href='http://localhost:8080/EmployeeReimbursementSystem/Manager.html'><input type='submit' value='Back To Home Page'></a>");
			out.println("</center>");
			out.println("</body>");
	}

}
