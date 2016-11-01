package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.training.managertaxi.daodb.DriverDao;

@Repository
public class DriverDaoImpl extends GenericDaoImpl<Driver, Long> implements DriverDao {

	@Override
	protected String getSqlInsert() {
		return "insert into driver (first_name,second_name,patronymic,phone_number,date_of_birth,date_of_employment,category,id_district,id_car)"
				+ " values(:firstName,:secondName,:patronymic,:phoneNumber,:dateOfBirth,:dateOfEmployment,:category,:idDistrict,:idCar)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update driver set first_name=:firstName,second_name=:secondName,patronymic=:patronymic,phoneNumber=:phoneNumber,"
				+ "date_of_birth=:dateOfBirth,date_of_employment=:dateOfEmployment,category=:category,id_district=:idDistrict,"
				+ "idCar=:idCar where id=:id";
	}

	@Override
	protected String getTable() {
		return "driver";
	}

}
