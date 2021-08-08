package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;


public class EmployeeRegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String dob=request.getParameter("dob");
			String email=request.getParameter("email");
			String type=request.getParameter("type");
			String age=request.getParameter("age");
			String gender=request.getParameter("gender");
			String mobileNo=request.getParameter("mobileNo");
			long mNo=Long.parseLong(mobileNo);
			int eAge=Integer.parseInt(age);
			Employee employee=new Employee();
			employee.setEmployeeName(name);
			employee.setDob(dob);
			employee.setAddress(address);
			employee.setType(type);
			employee.setEmail(email);
			employee.setGender(gender);
			employee.setAge(eAge);
			employee.setMobileNo(mNo);
			 
			EmployeeRegService employeeService =new EmployeeRegServiceImpl();
			
			employeeService.addEmployee(employee);
			
			out.println("<html>");
			out.println("<body>");
			out.println("<script> alert('Registration Success')</script>");
			out.println("</body>");
			out.println("<html>");
			
			
			//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			
			//rd.forward(request, response);
			
	}

}
