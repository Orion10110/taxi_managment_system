package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.BrandDao;


@Repository
public class BrandDaoImpl extends GenericDaoImpl<Brand,Long> implements BrandDao  {


	@Override
	protected String getSqlInsert() {
		return "insert into brand (name) values(:name)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update brand set name=:name where id=:id";
	}

	@Override
	protected String getTable() {
		return "brand";
	}

	

}
