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


public class ViewProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String email=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome"+" "+email+"</h1>");
		EmployeeRegService employeeRegServiceImpl=new EmployeeRegServiceImpl();
		List<EmployeeEntity> employeeList=employeeRegServiceImpl.viewEmployeeDetails(email);
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
		out.println("<caption><h4>Personal Information</h4></caption>");
		for(EmployeeEntity elist : employeeList)
		{
			
			out.println("<tr><td>EmployeeName</td>"+"<td>"+elist.getEmployeeName()+"</td></tr>");
			out.println("<tr><td>Email</td>"+"<td>"+elist.getEmail()+"</td></tr>");
			out.println("<tr><td>DOB</td>"+"<td>"+elist.getDob()+"</td></tr>");
			out.println("<tr><td>Age</td>"+"<td>"+elist.getAge()+"</td></tr>");
			out.println("<tr><td>Address</td>"+"<td>"+elist.getAddress()+"</td></tr>");
			out.println("<tr><td>Type</td>"+"<td>"+elist.getType()+"</td></tr>");
			out.println("<tr><td>Mobile No</td>"+"<td>"+elist.getMobileNo()+"</td></tr>");
			out.println("<tr><td>Gender</td>"+"<td>"+elist.getGender()+"</td></tr>");
		}
        out.println("</table>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/Employee.html'> <input type='submit' value='Back to Home'></form> ");
		out.println("</center>");
        out.println("</body>");
	
	}

	}


