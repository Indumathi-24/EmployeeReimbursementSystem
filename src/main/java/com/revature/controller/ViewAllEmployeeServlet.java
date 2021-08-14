package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.EmployeeEntity;
import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;


public class ViewAllEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String email=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome"+" "+email+"</h1>");
		EmployeeRegService employeeRegServiceImpl=new EmployeeRegServiceImpl();
		List<EmployeeEntity> employeeList=employeeRegServiceImpl.getAllEmployee();
		for(EmployeeEntity elist : employeeList)
		{
			System.out.println(elist.getEmployeeName());
			System.out.println(elist.getEmail());
			System.out.println(elist.getMobileNo());
			System.out.println(elist.getGender());
			System.out.println(elist.getDob());
			System.out.println(elist.getAge());
			System.out.println(elist.getAddress());
			System.out.println(elist.getType());
		}
		out.println("<table border='2'>");
		out.println("<caption><h4>All Employee Details</h4></caption>");
		out.println("<tr><td>EmployeeName</td>");
		out.println("<td>Email</td>");
		out.println("<td>DOB</td>");
		out.println("<td>Age</td>");
		out.println("<td>Address</td>");
		out.println("<td>Type</td>");
		out.println("<td>Mobile No</td>");
		out.println("<td>Gender</td></tr>");
		for(EmployeeEntity elist : employeeList)
		{
			
			out.println("<tr><td>"+elist.getEmployeeName()+"</td>");
			out.println("<td>"+elist.getEmail()+"</td>");
			out.println("<td>"+elist.getDob()+"</td>");
			out.println("<td>"+elist.getAge()+"</td>");
			out.println("<td>"+elist.getAddress()+"</td>");
			out.println("<td>"+elist.getType()+"</td>");
			out.println("<td>"+elist.getMobileNo()+"</td>");
			out.println("<td>"+elist.getGender()+"</td></tr>");
		}
        out.println("</table>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/Manager.html'> <input type='submit' value='Back to Home'></form> ");
		out.println("</center>");
        out.println("</body>");
	
	}

}


