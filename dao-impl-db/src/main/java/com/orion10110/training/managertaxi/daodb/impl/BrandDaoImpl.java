package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.BrandDao;


@Repository
public class BrandDaoImpl implements BrandDao  {

	
	@Inject
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Brand get(Long id) {
		 return jdbcTemplate.queryForObject(
	                "select * from brand where id = ?",
	                new Object[] { id }, new BeanPropertyRowMapper<Brand>(
	                        Brand.class));
	}

	@Override
	public Long insert(final Brand brand) {
		  final String INSERT_SQL = "insert into brand (name) values(?)";
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(
	                    Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(
	                        INSERT_SQL, new String[] { "id" });
	                ps.setString(1, brand.getName());
	                return ps;
	            }
	        }, keyHolder);

		  brand.setId(keyHolder.getKey().longValue());

	        return brand.getId();
	}

	@Override
	public void update(Brand brand) {
		 final String UPDATE_SQL = "update brand set name = ? where id = ?";
		 this.jdbcTemplate.update(UPDATE_SQL, brand.getId(), brand.getName());
		
	}

	@Override
	public void delete(Long id) {
		 final String DELETE_SQL = "delete from brand where id = ?";
		 this.jdbcTemplate.update(DELETE_SQL, Long.valueOf(id));
	}

	@Override
	public List<Brand> getAll() {
		 final String SELECT_LIST_SQL="select * from brand" ;
		return this.jdbcTemplate.query( SELECT_LIST_SQL, new BeanPropertyRowMapper<Brand>(
                Brand.class));
	}

}
