package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class District extends AbstractModel{
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
