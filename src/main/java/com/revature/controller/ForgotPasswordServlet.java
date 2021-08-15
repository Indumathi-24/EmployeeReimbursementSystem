package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeLoginService;
import com.revature.service.EmployeeLoginServiceImpl;

public class ForgotPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("email");
		String passWord = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		System.out.println(userName + " " + passWord + " " + confirmPassword);
		if (!passWord.equals(confirmPassword)) {
			out.println("<h1>Password and Confirm Password doesn't Match</h1>");
		} else {
			EmployeeLoginService loginServiceImpl = new EmployeeLoginServiceImpl();
			loginServiceImpl.updateForgotPassword(userName, passWord);
			System.out.println("Password Updated Successfully");
			response.sendRedirect("http://localhost:8080/EmployeeReimbursementSystem/LoginValidation.html");
	}

}
}