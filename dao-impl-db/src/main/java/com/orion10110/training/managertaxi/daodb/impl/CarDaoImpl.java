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
public class CarDaoImpl extends GenericDaoImpl<Car,Long> implements CarDao {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, Car entity) throws SQLException {
		ps.setString(1, entity.getName());
		ps.setLong(2, entity.getIdBrand());
		ps.setLong(3, entity.getIdType());
		ps.setInt(4, entity.getPlace());
		ps.setString(5, entity.getGosNumber());
		ps.setLong(6, entity.getStars());
		ps.setBoolean(7, entity.getActive());
		
		
	}

	@Override
	protected List<Object> setParamsForUpdate(Car entity) {
		ArrayList list =new ArrayList();
		list.add( entity.getName());
		list.add(  entity.getIdBrand());
		list.add(  entity.getIdType());
		list.add(  entity.getPlace());
		list.add(  entity.getGosNumber());
		list.add(  entity.getStars());
		list.add(  entity.getActive());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		
		return "insert into car (name,id_brand,id_type,place,gos_number,stars,active) values(?,?,?,?,?,?,?)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update car set name,id_brand=?,id_type=?,place=?,gos_number=?,stars=?,active=? where id=?";
	}

	@Override
	protected String getTable() {
		return "car";
	}

	@Override
	protected RowMapper<Car> getRowMapper(){
		return new CarMapper();
	}
	

}
