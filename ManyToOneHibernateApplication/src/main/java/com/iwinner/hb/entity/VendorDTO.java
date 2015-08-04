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
@Table(name = "TBL_Vendor")
public class VendorDTO {

	@Id
	@Column(name = "vendorId")
	private Integer vendorId;

	@Column(name = "vendorName", unique = true, length = 45)
	private String vendorName;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = CustomerDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendorCusotmerId", referencedColumnName = "vendorId")
	private Set<CustomerDTO> vendorDTO;

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

	public Set<CustomerDTO> getVendorDTO() {
		return vendorDTO;
	}

	public void setVendorDTO(Set<CustomerDTO> vendorDTO) {
		this.vendorDTO = vendorDTO;
	}

}
