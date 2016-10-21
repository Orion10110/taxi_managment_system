package com.orion10110.taximanager.datamodel;

import java.util.Date;

public class Order extends AbstractModel {
	private Long idClient;
	private Long idDriver;
	private Long idStatus;
	private String phoneNumber;
	private Date dateOrder;
	private Long idStreetFrom;
	private Long idStreetTo;
	private Integer startValueTaxim;
	private Integer endValueTaxim;
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

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
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

	public Integer getStartValueTaxim() {
		return startValueTaxim;
	}

	public void setStartValueTaxim(Integer startValueTaxim) {
		this.startValueTaxim = startValueTaxim;
	}

	public Integer getEndValueTaxim() {
		return endValueTaxim;
	}

	public void setEndValueTaxim(Integer endValueTaxim) {
		this.endValueTaxim = endValueTaxim;
	}

	public Long getIdApplicationUser() {
		return idApplicationUser;
	}

	public void setIdApplicationUser(Long idApplicationUser) {
		this.idApplicationUser = idApplicationUser;
	}

}
