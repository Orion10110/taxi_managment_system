package com.orion10110.taximanager.datamodel;

public class Order extends AbstractModel{
	private Long idClient;
	private Long idDriver;
	private Long idStatus;
	private Long idApplicationUser;
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(Long idDriver) {
		this.idDriver = idDriver;
	}
	public Long getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}
	public Long getIdApplicationUser() {
		return idApplicationUser;
	}
	public void setIdApplicationUser(Long idApplicationUser) {
		this.idApplicationUser = idApplicationUser;
	}
}
