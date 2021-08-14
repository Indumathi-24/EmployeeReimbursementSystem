package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;


public class ParticularUserRequestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome "+" "+userName+"</h1>");
		out.println("<h3>Email Ids Of All Employees</h3>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/ParticularUserRequestDetailsServlet'>");
		EmployeeRegService regService = new EmployeeRegServiceImpl();
		List<String> emailList =regService.getUserEmail();
		for(String email:emailList) {
			System.out.println(email);
		}
		out.println("<table>");
		out.println("<tr><td>Email Id</td>");
		out.println("<td><select name='email'>");
		for(String email:emailList) {
			out.println("<option>"+email+"</option>");
		}
		out.println("</select></td></tr>");
		out.println("</table>");
	    out.println("<input type='submit' value='Submit'></form> ");
	    out.println("</center>");
		out.println("</body>");
	}

}
