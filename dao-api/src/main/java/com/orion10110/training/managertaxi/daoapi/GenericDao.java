package com.orion10110.training.managertaxi.daoapi;

import java.io.Serializable;
import java.util.List;
/**
 * DAO interface 
 * @author Калач Артур
 *
 * @param <T> класс сущности
 */
public interface GenericDao <T>  {
	/**
	 * Запись объекта в хранилище
	 * @param entity объект
	 * @return id Объекта
	 */
	Long insert(T entity);
	/**
	 * Удаление объекта из хранилища
	 * @param id id -объекта
	 */
	void delete(Long id);
	
	/**
	 * Получение объекта по id
	 * @param id - id объекта
	 * @return объект из хранилища
	 */
	T get(Long id);
	
	/**
	 * Обновление объекта в хранилище
	 * @param entity объект
	 */
	void update(T entity);
	
	/**
	 * Получение списка объектов из хранилища
	 * @return список объектов
	 */
	List<T> getAll();

	
}
