package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class TypeCar extends AbstractModel{
	
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String type;

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
