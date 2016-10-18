package com.orion10110.taximanager.datamodel;

public class ValueTximeter extends AbstractModel {
	private Integer startValue;
	private Integer endValue;
	public Integer getStartValue() {
		return startValue;
	}
	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}
	public Integer getEndValue() {
		return endValue;
	}
	public void setEndValue(Integer endValue) {
		this.endValue = endValue;
	}
}
