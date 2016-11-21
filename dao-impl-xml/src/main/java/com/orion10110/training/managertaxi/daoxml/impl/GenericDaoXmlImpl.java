package com.orion10110.training.managertaxi.daoxml.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daoapi.GenericDao;
import com.orion10110.training.managertaxi.daoxml.util.UpdateFieldsReflectuin;
import com.thoughtworks.xstream.XStream;

@Repository
public abstract class GenericDaoXmlImpl<T extends AbstractModel> implements GenericDao<T> {
	
	private XStream xstream;
	private File file;

	@Value("${basePath}")
	private String basePath;

	Class classType;
	
//	public GenericDaoXmlImpl() {
//		Type t = getClass().getGenericSuperclass();
//		ParameterizedType pt = (ParameterizedType) t;
//		classType = (Class) pt.getActualTypeArguments()[0];
//	}
	
	@PostConstruct
	private void intialize() throws IOException {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		classType = (Class) pt.getActualTypeArguments()[0];
		xstream = new XStream();
		xstream.alias(classType.getSimpleName(), classType);

		file = new File(String.format("%s/%s.xml", basePath, classType.getSimpleName()));
		if (!file.exists()) {
			file.createNewFile();
			xstream.toXML(new ArrayList<>(), new FileOutputStream(file));
		}
	}

	@Override
	public T get(Long id) {
		List<T> allEntities = readCollection();

		for (T entity : allEntities) {
			if (entity.getId().equals(id)) {
				return entity;
			}
		}

		throw new EmptyResultDataAccessException(0);
	}

	@Override
	public void delete(Long id) {
		List<T> allEntities = readCollection();
		T deletedBrnad = getEntity(id, allEntities);
		allEntities.remove(deletedBrnad);
		writeCollection(allEntities);
	}

	@Override
	public List<T> getAll() {
		return readCollection();
	}

	@Override
	public Long insert(T entity) {
		List<T> allEntities = readCollection();
		Long id = getNextId(allEntities);

		allEntities.add(entity);

		entity.setId(new Long(id));

		writeCollection(allEntities);
		return id;
	}

	@Override
	public void update(T entity) {
		List<T> allBrands = readCollection();
		T changedEntity = getEntity(entity.getId(), allBrands);
		UpdateFieldsReflectuin<T> updater = new UpdateFieldsReflectuin<T>();
		updater.UpdateFields(changedEntity, entity);
		writeCollection(allBrands);
	}

	protected T getEntity(Long id, List<T> list) {
		Predicate<T> predicate = c -> c.getId().equals(id);
		T obj = list.stream().filter(predicate).findFirst().get();
		return obj;
	}

	protected List<T> readCollection() {
		return (List<T>) xstream.fromXML(file);
	}

	protected void writeCollection(List<T> newList) {
		try {
			xstream.toXML(newList, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	protected long getNextId(List<T> allEntities) {
		return allEntities.isEmpty() ? 1l : allEntities.get(allEntities.size() - 1).getId() + 1;
	}

}
