package com.iwinner.hb.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_REL_VENDORDTO")
public class VendorDTO {

	@Id
	@Column(name = "vendorId")
	private Integer vendorId;

	@Column(name = "vendorName")
	private String vendorName;

	@Column(name = "vendorAdd")
	private String vendorAdd;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = CustomerDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "VENDOR_FK", referencedColumnName = "vendorId")
	private Set<CustomerDTO> customerDTO;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAdd() {
		return vendorAdd;
	}

	public void setVendorAdd(String vendorAdd) {
		this.vendorAdd = vendorAdd;
	}

	public Set<CustomerDTO> getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(Set<CustomerDTO> customerDTO) {
		this.customerDTO = customerDTO;
	}

}
