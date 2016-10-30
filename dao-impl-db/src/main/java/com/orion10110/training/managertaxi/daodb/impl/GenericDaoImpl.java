package com.orion10110.training.managertaxi.daodb.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.GenericDao;

@Repository
public abstract class GenericDaoImpl<T extends AbstractModel, PK extends Serializable> implements GenericDao<T, PK> {
	@Inject
	private JdbcTemplate jdbcTemplate;

	protected abstract void setParamsForInsert(PreparedStatement ps, T entity) throws SQLException;

	protected abstract List<Object> setParamsForUpdate(T entity);

	protected abstract String getSqlInsert();

	protected abstract String getSqlUpdate();

	protected abstract String getTable();

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
	public PK insert(final T transientObject) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(getSqlInsert(), new String[] { "id" });
				setParamsForInsert(ps, transientObject);
				return ps;
			}
		}, keyHolder);

		Long key = keyHolder.getKey().longValue();

		return (PK) key;
	}

	@Override
	public void delete(PK id) {
		this.jdbcTemplate.update("delete from " + getTable() + " where id = ?", id);

	}

	@Override
	public T get(PK id) {
		return (T)jdbcTemplate.queryForObject("select * from " + this.getTable() + " where id = ?", new Object[] { id },
				getRowMapper());
	}

	@Override
	public void update(T transientObject) {

		this.jdbcTemplate.update(getSqlUpdate(), transientObject.getId(), setParamsForUpdate(transientObject));
	}

	@Override
	public List<T> getAll() {
		return (List<T>)jdbcTemplate.query("select * from " + this.getTable(),
				getRowMapper());
	}

}
