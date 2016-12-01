package com.orion10110.taximanager.datamodel;

import java.io.Serializable;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public abstract class AbstractModel implements Serializable {
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
