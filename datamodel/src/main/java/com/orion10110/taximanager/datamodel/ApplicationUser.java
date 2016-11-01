package com.orion10110.taximanager.datamodel;

public class ApplicationUser extends AbstractModel {
	private String email;
	private Boolean emailConfirmed;
	private String passwordHash;
	private String phoneNumber;
	private Boolean phoneNumberConfirmed;
	private String userName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getPhoneNumberConfirmed() {
		return phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
