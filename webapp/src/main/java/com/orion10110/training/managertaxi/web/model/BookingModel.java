package com.orion10110.training.managertaxi.web.model;

import java.sql.Timestamp;

import com.orion10110.taximanager.datamodel.AbstractModel;

public class BookingModel extends AbstractModel {

	private Long idDriver;
	private Long idStatus;
	private String phoneNumber;
	private Timestamp dateOrder;
	private Long idStreetFrom;
	private Long idStreetTo;
	private Integer startValue;
	private Integer endValue;


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



}
