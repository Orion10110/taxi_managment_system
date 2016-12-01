package com.orion10110.taximanager.datamodel;

import java.sql.Timestamp;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Driver extends AbstractModel {
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String secondName;
	private String patronymic;
	private String phoneNumber;
	private Timestamp dateOfBirth;
	private Timestamp dateOfEmployment;
	private Integer category;
	private Long idDistrict;
	private Long idCar;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

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
