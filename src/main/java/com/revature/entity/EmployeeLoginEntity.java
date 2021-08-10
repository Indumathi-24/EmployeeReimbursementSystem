package com.revature.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeLogin")
public class EmployeeLoginEntity {
	@OneToOne
	@JoinColumn(name="email",nullable=false)
	private EmployeeEntity userName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String password;
	private String confirmPswrd;
	
	public EmployeeEntity getUserName() {
		return userName;
	}
	public void setUserName(EmployeeEntity userName) {
		this.userName = userName;
	}
	public EmployeeLoginEntity() {
		
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
	public EmployeeLoginEntity(String password, String confirmPswrd) {
		super();
		this.password = password;
		this.confirmPswrd = confirmPswrd;
	}
	
}
