package com.orion10110.taximanager.datamodel;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class Discount extends AbstractModel {
	/**
	 * 
	 */
	@IgnoreField
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer discountPercent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

}
