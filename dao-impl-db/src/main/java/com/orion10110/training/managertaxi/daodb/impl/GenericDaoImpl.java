package com.orion10110.training.managertaxi.daodb.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.daoapi.GenericDao;
import com.orion10110.training.managertaxi.daodb.util.GenerateSql;

@Repository
public abstract class GenericDaoImpl<T extends AbstractModel> implements GenericDao<T> {
	@Inject
	protected JdbcTemplate jdbcTemplate;
	
	@Inject
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private Class<? extends T> daoType;
	
	private RowMapper<?> rowMapper;
	
	

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
		rowMapper = new BeanPropertyRowMapper<T>((Class<T>) daoType);
	}

	protected RowMapper<?> getRowMapper(){
		return this.rowMapper;
	}
	
	
	@Override
	public Long insert(final T transientObject) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
				
		this.namedParameterJdbcTemplate.update(GenerateSql.generateSqlInsert(daoType), new BeanPropertySqlParameterSource(transientObject),
				keyHolder, new String[] { "id" });

		Long key = keyHolder.getKey().longValue();
		transientObject.setId(key);
		return (Long) key;
	}

	@Override
	public void delete(Long id) {
		this.jdbcTemplate.update(GenerateSql.generateSqlDelete(daoType), id);

	}

	@Override
	public T get(Long id) {
		return (T)jdbcTemplate.queryForObject(GenerateSql.generateSqlGetId(daoType), new Object[] { id },
				getRowMapper());
	}

	@Override
	public void update(T transientObject) {

		this.namedParameterJdbcTemplate.update(GenerateSql.generateSqlUpdate(daoType), new BeanPropertySqlParameterSource(transientObject));
	}

	@Override
	public List<T> getAll() {
		return (List<T>)jdbcTemplate.query(GenerateSql.generateSqlSelect(daoType),
				getRowMapper());
	}

}
