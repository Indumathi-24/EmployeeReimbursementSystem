package com.revature.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ReimbursementRequest")
public class EmployeeReimbursementEntity {
	@ManyToOne
	@JoinColumn(name = "email", nullable = false)
	private EmployeeEntity userEmail;
	@Id
	@Column(nullable=false)
	private Integer requestId;
	@Column(nullable=false)
    private String date;
	@Column(nullable=false)
    private String type;
	@Column(nullable=false)
    private Integer amount;
	@Column(nullable=false)
    private String status;
	@Override
	public String toString() {
		return "EmployeeReimbursementEntity [userEmail=" + userEmail + ", requestId=" + requestId + ", date=" + date
				+ ", type=" + type + ", amount=" + amount + ", status=" + status + "]";
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployeeEntity getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(EmployeeEntity userEmail) {
		this.userEmail = userEmail;
	}
	
    
}
