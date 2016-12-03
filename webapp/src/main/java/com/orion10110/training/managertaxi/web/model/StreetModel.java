package com.orion10110.training.managertaxi.web.model;

import com.orion10110.taximanager.datamodel.AbstractModel;

public class StreetModel extends AbstractModel {

	private String name;
	private Long idDistrict;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(Long idDistrict) {
		this.idDistrict = idDistrict;
	}
}
