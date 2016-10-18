package com.orion10110.taximanager.datamodel;

import java.util.Date;

public class LocationOrder extends AbstractModel {
	private String phoneNumber;
	private Date dateOrder;
	private Date dateComeFrom;
	private Date dateComeTo;
	private Long idStreetFrom;
	private String addresFrom;
	private String addresTo;
	private Long idStreetTo;

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

	public Date getDateComeFrom() {
		return dateComeFrom;
	}

	public void setDateComeFrom(Date dateComeFrom) {
		this.dateComeFrom = dateComeFrom;
	}

	public Date getDateComeTo() {
		return dateComeTo;
	}

	public void setDateComeTo(Date dateComeTo) {
		this.dateComeTo = dateComeTo;
	}

	public Long getIdStreetFrom() {
		return idStreetFrom;
	}

	public void setIdStreetFrom(Long idStreetFrom) {
		this.idStreetFrom = idStreetFrom;
	}

	public String getAddresFrom() {
		return addresFrom;
	}

	public void setAddresFrom(String addresFrom) {
		this.addresFrom = addresFrom;
	}

	public String getAddresTo() {
		return addresTo;
	}

	public void setAddresTo(String addresTo) {
		this.addresTo = addresTo;
	}

	public Long getIdStreetTo() {
		return idStreetTo;
	}

	public void setIdStreetTo(Long idStreetTo) {
		this.idStreetTo = idStreetTo;
	}

}
