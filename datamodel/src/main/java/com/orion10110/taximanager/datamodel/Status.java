package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Status extends AbstractModel{
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String Status;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}
