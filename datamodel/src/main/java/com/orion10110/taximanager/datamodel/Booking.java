package com.orion10110.taximanager.datamodel;

import java.sql.Timestamp;
import java.util.Date;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Booking extends AbstractModel {
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private Long idClient;
	private Long idDriver;
	private Long idStatus;
	private String phoneNumber;
	private Timestamp dateOrder;
	private Long idStreetFrom;
	private Long idStreetTo;
	private Integer startValue;
	private Integer endValue;
	private Long idApplicationUser;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(Long idDriver) {
		this.idDriver = idDriver;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Long getIdStreetFrom() {
		return idStreetFrom;
	}

	public void setIdStreetFrom(Long idStreetFrom) {
		this.idStreetFrom = idStreetFrom;
	}

	public Long getIdStreetTo() {
		return idStreetTo;
	}

	public void setIdStreetTo(Long idStreetTo) {
		this.idStreetTo = idStreetTo;
	}

	public Integer getStartValue() {
		return startValue;
	}

	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}

	public Integer getEndValue() {
		return endValue;
	}

	public void setEndValue(Integer endValue) {
		this.endValue = endValue;
	}

	public Long getIdApplicationUser() {
		return idApplicationUser;
	}

	public void setIdApplicationUser(Long idApplicationUser) {
		this.idApplicationUser = idApplicationUser;
	}

}
