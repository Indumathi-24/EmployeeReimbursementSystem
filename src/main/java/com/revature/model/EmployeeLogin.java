package com.revature.model;

public class EmployeeLogin {
      private String email;
      private String password;
      private String confirmPswrd;
      public EmployeeLogin() {
    	  
      }
	public String getConfirmPswrd() {
		return confirmPswrd;
	}
	public void setConfirmPswrd(String confirmPswrd) {
		this.confirmPswrd = confirmPswrd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeLogin(String email, String password, String confirmPswrd) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPswrd = confirmPswrd;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [email=" + email + ", password=" + password + ", confirmPswrd=" + confirmPswrd + "]";
	}
	
      
}
