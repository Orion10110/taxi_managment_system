package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Status extends AbstractModel{
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String status;
	private String statusEn;
	
	public String getStatusEn() {
		return statusEn;
	}

	public void setStatusEn(String statusEn) {
		this.statusEn = statusEn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
