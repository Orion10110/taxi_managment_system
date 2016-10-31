package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.daodb.DistrictDao;

@Repository
public class DistrictDaoImpl extends GenericDaoImpl<District,Long> implements DistrictDao {


	@Override
	protected String getSqlInsert() {
		return  "insert into district (name) values(:name)";
	}

	@Override
	protected String getSqlUpdate() {
		
		return "update district set name = :name where id = :id";
	}

	@Override
	protected String getTable() {
		return "district";
	}

	
	

}
