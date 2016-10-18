package com.orion10110.taximanager.datamodel;

import java.util.Date;

public class Driver extends NameOfPerson{
	private String phoneNumber;
	private Date dateOfBirth;
	private Date dateOfEmployment;
	private Integer category;
	private Long idDistrict;
	private Long idCar;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
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
