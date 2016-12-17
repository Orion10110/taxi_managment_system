package com.orion10110.training.managertaxi.web.model;

import com.orion10110.taximanager.datamodel.AbstractModel;

public abstract class TypeCarAbstractModel extends AbstractModel {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
