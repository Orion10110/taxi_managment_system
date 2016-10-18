package com.orion10110.taximanager.datamodel;

public class Client extends NameOfPerson {
	private String phoneNumber;
	private Long idDiscount;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getIdDiscount() {
		return idDiscount;
	}
	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}


}
