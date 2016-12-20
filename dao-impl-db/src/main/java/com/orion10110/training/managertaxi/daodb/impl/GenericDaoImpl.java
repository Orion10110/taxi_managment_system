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

/**
 * Обобщеный класс запросов к бд
 * 
 * @author Калач Артур
 *
 * @param <T> класс сущности бд
 */
@Repository
public abstract class GenericDaoImpl<T extends AbstractModel> implements GenericDao<T> {
	/**
	 * Соеденение с бд
	 */
	@Inject
	protected JdbcTemplate jdbcTemplate;

	/**
	 * Соединение с передачей по именнованным параметрам.
	 */
	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Тип параметра обобщенного класса
	 */
	private Class<? extends T> daoType;

	/**
	 * Mapper для класса
	 */
	private RowMapper<?> rowMapper;

	/**
	 * Конструктор для определение параметра обобщеного класса, определение
	 * "Mapper" бд
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
		rowMapper = new BeanPropertyRowMapper<T>((Class<T>) daoType);
	}

	/**
	 * Получение Mapper класса
	 * 
	 * @return class Mapper
	 */
	protected RowMapper<?> getRowMapper() {
		return this.rowMapper;
	}

	/**
	 * Записывает объект в бд
	 * 
	 * @param entity
	 *            записываемый объект
	 * @return id записаного объекта
	 * 
	 * @see com.orion10110.training.managertaxi.daoapi.GenericDao#insert(java.lang.Object)
	 */
	@Override
	public Long insert(final T entity) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameterJdbcTemplate.update(GenerateSql.generateSqlInsert(daoType),
				new BeanPropertySqlParameterSource(entity), keyHolder, new String[] { "id" });
		Long key = keyHolder.getKey().longValue();
		entity.setId(key);
		return (Long) key;
	}

	/**
	 * Удаление объект из бд
	 * 
	 * @param id
	 *            записываемого объекта
	 *            
	 * @see com.orion10110.training.managertaxi.daoapi.GenericDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		this.jdbcTemplate.update(GenerateSql.generateSqlDelete(daoType), id);

	}

	/**
	 * Получение объекта по id
	 * 
	 * @param id
	 *          id  запрашиваемого объекта
	 * @return обьект из бд
	 * 
	 * @see com.orion10110.training.managertaxi.daoapi.GenericDao#get(java.lang.Long)
	 */
	@Override
	public T get(Long id) {
		return (T) jdbcTemplate.queryForObject(GenerateSql.generateSqlGetId(daoType), new Object[] { id },
				getRowMapper());
	}

	/**
	 * Изменеие объекта в бд
	 * 
	 * @param transientObject
	 *          объект для изменения
	 *          
	 * @see com.orion10110.training.managertaxi.daoapi.GenericDao#update(java.lang.Object)
	 */
	@Override
	public void update(T transientObject) {
			  this.namedParameterJdbcTemplate.update(GenerateSql.generateSqlUpdate(daoType),
						new BeanPropertySqlParameterSource(transientObject));
	}

	/**
	 * Получение всех значений таблицы бд
	 *
	 *@return Список объектов
	 *
	 * @see com.orion10110.training.managertaxi.daoapi.GenericDao#getAll()
	 */
	@Override
	public List<T> getAll() {
		return (List<T>) jdbcTemplate.query(GenerateSql.generateSqlSelect(daoType), getRowMapper());
	}

}
