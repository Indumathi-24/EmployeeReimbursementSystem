package com.revature.model;


public class Employee {
	private String employeeName;
	private String dob;
	private String address;
	private long mobileNo;
	private String email;
	private Integer age;
	private String gender;
	private String type;
	public Employee(){
		
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
	public Employee(String employeeName, String dob, String address, long mobileNo, String email, Integer age,
			String gender, String type) {
		super();
		this.employeeName = employeeName;
		this.dob = dob;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.type = type;
	}
	
	
}
