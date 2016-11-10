package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.daodb.CarDao;
import com.orion10110.training.managertaxi.mapper.CarMapper;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car, Long> implements CarDao {

	@Override
	protected String getSqlInsert() {
		String insert = String.format("insert into car (%s) values(%s)",
				"name,id_brand,id_type,place,gos_number,stars,active",
				":name,:idBrand,:idType,:place,:gosNumber,:stars,:active");
		return insert;
	}

	@Override
	protected String getSqlUpdate() {
		String update = String.format("update car set %s",
				"name=:name,id_brand=:idBrand,id_type=:idType,place=:place,gos_number=:gosNumber,stars=:stars,active=:active where id=:id");
		return update;
	}

	@Override
	protected String getTable() {
		return "car";
	}

//	@Override
//	protected RowMapper<Car> getRowMapper() {
//		return new CarMapper();
//	}

}
