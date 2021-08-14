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
import com.revature.model.Employee;
import com.revature.service.EmployeeRegService;
import com.revature.service.EmployeeRegServiceImpl;


public class UpdateProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome"+" "+userName+"</h1>");
		boolean genderFlag=false;
		EmployeeRegService regService=new EmployeeRegServiceImpl();
		List<EmployeeEntity> employeeList=regService.viewEmployeeDetails(userName);
		for(EmployeeEntity elist : employeeList)
		{
			System.out.println(elist.getEmployeeName());
			System.out.println(elist.getDob());
			System.out.println(elist.getAddress());
			System.out.println(elist.getAge());
			if(elist.getGender().equals("Male"))
			{
				genderFlag=true;
			}
			System.out.println(elist.getGender());
			System.out.println(userName);
			System.out.println(elist.getMobileNo());
			System.out.println(elist.getType());
		}
		
		out.println("<h4>Edit Profile</h4>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementSystem/UpdateEmployeeDetailsServlet' method='GET'>");
		out.println("<table border='2'>");
		for(EmployeeEntity elist : employeeList)
		{
			
			out.println("<tr><td>Employee Name</td>"+"<td>"+"<input type='text' name='name' value="+elist.getEmployeeName()+">"+"</td></tr>");
			out.println("<tr><td>Address</td>"+"<td>"+"<input type='text' name='address' value="+elist.getAddress()+">"+"</td></tr>");
			out.println("<tr><td>DOB</td>"+"<td>"+"<input type='date' name='dob' value="+elist.getDob()+">"+"</td></tr>");
			out.println("<tr><td>Age</td>"+"<td>"+"<input type='number' name='age' value="+elist.getAge()+">"+"</td></tr>");
			if(genderFlag)
			{
				out.println("<tr>");
				out.println("<th rowspan='2'> Gender</th>");
				out.println("<td><input type='radio' name='gender' checked value="+elist.getGender());
				out.println("<label for='male'>Male</label>");
				out.println("</td>");
				out.println("</tr");
				out.println("<tr>");
				out.println("<td><input type='radio' name='gender'value="+elist.getGender());
				out.println("<label for='female'>Female</label>");
				out.println("</td>");
				out.println("</tr");
			}
			else
			{
				out.println("<tr>");
				out.println("<th rowspan='2'> Gender</th>");
				out.println("<td><input type='radio' name='gender' value="+elist.getGender());
				out.println("<label for='male'>Male</label>");
				out.println("</td>");
				out.println("</tr");
				out.println("<tr>");
				out.println("<td><input type='radio' name='gender' checked value="+elist.getGender());
				out.println("<label for='female'>Female</label>");
				out.println("</td>");
				out.println("</tr");
			}
			out.println("<tr><td>Email</td>"+"<td>"+"<input type='email' name='email' value="+elist.getEmail()+">"+"</td></tr>");
			out.println("<tr><td>Mobile No</td>"+"<td>"+"<input type='text' name='mobileNo' value="+elist.getMobileNo()+">"+"</td></tr>");
			out.println("<tr><td>Employee Type");
			out.println("<td><select name='type' >");
			out.println("<option value='Manager'>Manager");
			out.println("<option value='Employee'>Employee");
			out.println("</select></td></tr>");
			out.println("<tr>");
			out.println("<center>");
			out.println("<td colspan='2'><center><input id='submitButton' type='submit' value='Update'></center>");
			out.println("</td>");
			out.println("</center>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
	}
}
