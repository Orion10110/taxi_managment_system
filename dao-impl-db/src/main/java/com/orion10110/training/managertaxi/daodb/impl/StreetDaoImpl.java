package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.training.managertaxi.daodb.StreetDao;

@Repository
public class StreetDaoImpl extends GenericDaoImpl<Street,Long> implements StreetDao {

	@Override
	protected String getSqlInsert() {
		return "insert into street (name,id_district) values(:name,:idDistrict)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update street set name = :name, id_district = :idDistrict where id = :id";
	}

	@Override
	protected String getTable() {
		return "street";
	}

	

}
