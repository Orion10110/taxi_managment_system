package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.training.managertaxi.daodb.DriverDao;

@Repository
public class DriverDaoImpl extends GenericDaoImpl<Driver, Long> implements DriverDao {

	@Override
	protected String getSqlInsert() {
		String insert = String.format("insert into driver (%s) values(%s)",
				"first_name,second_name,patronymic,phone_number,date_of_birth,date_of_employment,category,id_district,id_car",
				":firstName,:secondName,:patronymic,:phoneNumber,:dateOfBirth,:dateOfEmployment,:category,:idDistrict,:idCar");
		return insert;
	}

	@Override
	protected String getSqlUpdate() {
		String update = String.format("update driver set %s %s",
				"first_name=:firstName,second_name=:secondName,patronymic=:patronymic,phone_number=:phoneNumber,",
				"date_of_birth=:dateOfBirth,date_of_employment=:dateOfEmployment,category=:category,id_district=:idDistrict,id_car=:idCar where id=:id");
		return update;
	}

	@Override
	protected String getTable() {
		return "driver";
	}

}
