package com.orion10110.training.managertaxi.web.model;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.anotation.IgnoreField;

public class CarModel extends AbstractModel {

	private String name;
	private Long idBrand;
	private Long idType;
	private Integer place;
	private String gosNumber;
	private Integer stars;
	private Boolean active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public Integer getPlace() {
		return place;
	}
	public void setPlace(Integer place) {
		this.place = place;
	}
	public String getGosNumber() {
		return gosNumber;
	}
	public void setGosNumber(String gosNumber) {
		this.gosNumber = gosNumber;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
