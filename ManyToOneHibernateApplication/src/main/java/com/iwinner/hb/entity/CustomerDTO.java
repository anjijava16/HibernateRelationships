package com.iwinner.hb.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CustomerVendor")
public class CustomerDTO {

	@Id
	@Column(name = "customerId")
	private Integer customerId;

	@Column(name = "customerName", nullable = false, length = 200)
	private String customerName;
	@Column(name = "customerAccessDate", nullable = false, length = 200)
	private Date customerAccessDate;

	@Column(name = "customerTimeStamp", nullable = false, length = 200)
	private Timestamp customerTimeStamp;

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

	public Date getCustomerAccessDate() {
		return customerAccessDate;
	}

	public void setCustomerAccessDate(Date customerAccessDate) {
		this.customerAccessDate = customerAccessDate;
	}

	public Timestamp getCustomerTimeStamp() {
		return customerTimeStamp;
	}

	public void setCustomerTimeStamp(Timestamp customerTimeStamp) {
		this.customerTimeStamp = customerTimeStamp;
	}

}
