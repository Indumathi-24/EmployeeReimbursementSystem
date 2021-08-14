package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;

public class UpdateEmployeeDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String type = request.getParameter("type");
		System.out.print(name+" "+address+" "+dob+" "+email+" "+type+" "+age+" "+gender+" "+mobileNo);
		long mNo=Long.parseLong(mobileNo);
		int eAge=Integer.parseInt(age);
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmail(email);
		employee.setDob(dob);
		employee.setAge(eAge);
		employee.setGender(gender);
		employee.setMobileNo(mNo);
		employee.setAddress(address);
		employee.setType(type);
		EmployeeRegService employeeService = new EmployeeRegServiceImpl();
		employeeService.updateEmployeeDetails(employee);
		System.out.println("Updating Employee details is Success");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/Employee.html'> <input type='submit' value='Back to Home'></form> ");
	}

	
	}


