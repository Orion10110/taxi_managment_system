package com.orion10110.training.managertaxi.daodb.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.GenericDao;

@Repository
public abstract class GenericDaoImpl  <T extends AbstractModel, PK extends Serializable> 
implements GenericDao<T, PK> {
	
	protected abstract void setParamsForInsert(PreparedStatement ps,T entity) throws SQLException;
	protected abstract List<Object> setParamsForUpdate(T entity);
	protected Class<? extends T> daoType;
	protected abstract String getTable();
	protected abstract String getSqlSelectList() ;
	protected abstract String getSqlInsert();
	protected abstract String getSqlUpdate();
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
	
	
	@Inject
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public PK insert(final T transientObject) {
		
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(
	                    Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(
	                        getSqlInsert(), new String[] { "id" });
	                setParamsForInsert(ps ,transientObject);
	                return ps;
	            }

				
	        }, keyHolder);

		

	        return (PK) transientObject.getId();
	}

	@Override
	public void delete(PK id) {
		 this.jdbcTemplate.update("delete from "+getTable()+" where id = ?", id);
		
	}

	@Override
	public T get(PK id) {
		 return jdbcTemplate.queryForObject(
	                "select * from "+this.getTable()+" where id = ?",
	                new Object[] { id }, new BeanPropertyRowMapper<T>((Class<T>) daoType));
	}

	@Override
	public void update(T transientObject) {
		
		 this.jdbcTemplate.update(getSqlUpdate(), transientObject.getId(), setParamsForUpdate(transientObject));
	}

	
	@Override
	public List<T> getAll() {
		return this.jdbcTemplate.query( getSqlSelectList(),new BeanPropertyRowMapper<T>((Class<T>) daoType));
	}
	

}
