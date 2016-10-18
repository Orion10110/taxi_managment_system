package com.orion10110.taximanager.datamodel;

public class Discount extends AbstractModel {
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
