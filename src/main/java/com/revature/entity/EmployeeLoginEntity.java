package com.revature.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeLogin")
public class EmployeeLoginEntity {
	@Id
	private String email;
	private String password;
	private String confirmPswrd;
	public EmployeeLoginEntity() {
		
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
	public String getConfirmPswrd() {
		return confirmPswrd;
	}
	public void setConfirmPswrd(String confirmPswrd) {
		this.confirmPswrd = confirmPswrd;
	}
	public EmployeeLoginEntity(String email, String password, String confirmPswrd) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPswrd = confirmPswrd;
	}
	
}
