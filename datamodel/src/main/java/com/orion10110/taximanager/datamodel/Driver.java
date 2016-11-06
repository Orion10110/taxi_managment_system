package com.orion10110.taximanager.datamodel;

import java.sql.Timestamp;

public class Driver extends NameOfPerson{
	private String phoneNumber;
	private Timestamp dateOfBirth;
	private Timestamp dateOfEmployment;
	private Integer category;
	private Long idDistrict;
	private Long idCar;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Timestamp getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(Timestamp dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Long getIdDistrict() {
		return idDistrict;
	}
	public void setIdDistrict(Long idDistrict) {
		this.idDistrict = idDistrict;
	}
	public Long getIdCar() {
		return idCar;
	}
	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}


}
