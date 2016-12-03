package com.orion10110.training.managertaxi.web.model;

import com.orion10110.taximanager.datamodel.AbstractModel;

public class DiscountModel extends AbstractModel {

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
