package com.orion10110.training.managertaxi.mapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orion10110.taximanager.datamodel.Car;

public final class CarMapper implements RowMapper<Car> {
	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String gosNumber = rs.getString("gos_number");
		Boolean active = rs.getBoolean("active");
		Long idBrand = rs.getLong("id_brand");
		Long idType = rs.getLong("id_type");
		String name = rs.getString("name");
		Integer place = rs.getInt("place");
		Integer stars =rs.getInt("stars");
		Car entity = new Car();
		entity.setActive(active);
		entity.setGosNumber(gosNumber);
		entity.setIdBrand(idBrand);
		entity.setIdType(idType);
		entity.setName(name);
		entity.setPlace(place);
		entity.setStars(stars);
		return entity;
	}
}