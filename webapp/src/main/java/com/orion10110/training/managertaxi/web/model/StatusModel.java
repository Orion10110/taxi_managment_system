package com.orion10110.training.managertaxi.web.model;

import com.orion10110.taximanager.datamodel.AbstractModel;

public class StatusModel extends AbstractModel {

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
