package com.iwinner.hb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_UserAccount")
public class UserAccountDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emailId", nullable = false, length = 200)
	private String emailId;
	@Column(name = "firstName", nullable = true, length = 200)
	private String firstName;
	@Column(name = "lastName", nullable = true, length = 200)
	private String lastName;
	@Column(name = "companyName", nullable = true, length = 200)
	private String companyName;
	@Column(name = "password", nullable = true, length = 200)
	private String password;
	@Column(name = "userMobileNumber", nullable = true, length = 200)
	private Long userMobileNumber;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "profileId")
	private ProfileDTO userProfile;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public ProfileDTO getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(ProfileDTO userProfile) {
		this.userProfile = userProfile;
	}

}
