package com.orion10110.taximanager.datamodel;

public class Street extends AbstractModel {
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
