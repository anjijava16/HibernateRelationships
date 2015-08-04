package com.iwinner.hb.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_REL_CustomerDTO")
public class CustomerDTO {

	@Id
	@Column(name = "customerId")
	private Integer customerId;

	@Column(name = "customerName", nullable = false, length = 200)
	private String customerName;
	@Column(name = "customerAdd", nullable = false, length = 200)
	private String customerAdd;
	@Column(name = "customerRegDate", nullable = true, length = 200)
	private Date customerRegDate;
	@Column(name = "customerRegTime", nullable = true, length = 200)
	private Timestamp customerRegTime;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAdd() {
		return customerAdd;
	}

	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}

	public Date getCustomerRegDate() {
		return customerRegDate;
	}

	public void setCustomerRegDate(Date customerRegDate) {
		this.customerRegDate = customerRegDate;
	}

	public Timestamp getCustomerRegTime() {
		return customerRegTime;
	}

	public void setCustomerRegTime(Timestamp customerRegTime) {
		this.customerRegTime = customerRegTime;
	}

}
