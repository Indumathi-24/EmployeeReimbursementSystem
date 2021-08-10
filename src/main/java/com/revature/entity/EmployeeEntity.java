package com.revature.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Employee")
public class EmployeeEntity {
	
	@OneToOne(mappedBy="userName")
	private EmployeeLoginEntity user;
	private String employeeName;
	private String dob;
	private String address;
	private long mobileNo;
	@Id
	private String email;
	private Integer age;
	private String gender;
	private String type;
	public EmployeeLoginEntity getUser() {
		return user;
	}
	public void setUser(EmployeeLoginEntity user) {
		this.user = user;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", dob=" + dob + ", address=" + address + ", mobileNo="
				+ mobileNo + ", email=" + email + ", age=" + age + ", gender=" + gender + ", type=" + type + "]";
	}
	
	
	
}
