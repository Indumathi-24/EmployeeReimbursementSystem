package com.revature.model;

import java.util.Date;

public class EmployeeReimbursement {
      private Integer requestId;
      private Date date;
      private String type;
      private Integer amount;
      private String status;
      
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	
      
	@Override
	public String toString() {
		return "EmployeeReimbursement [requestId=" + requestId + ", date=" + date + ", type=" + type + ", amount="
				+ amount + ", status=" + status + "]";
	}
	
	public EmployeeReimbursement(Integer requestId, Date date, String type, Integer amount, String status) {
		super();
		this.requestId = requestId;
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.status = status;
	}
	public EmployeeReimbursement() {
		
	}
}
