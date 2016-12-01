package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Street extends AbstractModel {
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
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
