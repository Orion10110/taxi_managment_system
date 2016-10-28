package com.orion10110.training.managertaxi.daodb.impl;

import java.io.Serializable;
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

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.GenericDao;

public abstract class GenericDaoImpl  <T, PK extends Serializable> 
implements GenericDao<T, PK> {
	
	
	
	protected abstract Class<T> getType();
	protected abstract String getTable();
	protected abstract String getSqlInsert();
	
	@Inject
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public PK insert(T newInstance) {
		 final String INSERT_SQL = "insert into brand (name) values(?)";
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(
	                    Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(
	                        getSqlInsert(), new String[] { "id" });
	                ps.setString(1, brand.getName());
	                return ps;
	            }
	        }, keyHolder);

		  brand.setId(keyHolder.getKey().longValue());

	        return brand.getId();
	}

	@Override
	public void delete(T persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(PK id) {
		 return jdbcTemplate.queryForObject(
	                "select * from "+this.getTable()+" where id = ?",
	                new Object[] { id }, new BeanPropertyRowMapper<T>());
	}

	@Override
	public T update(T transientObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
