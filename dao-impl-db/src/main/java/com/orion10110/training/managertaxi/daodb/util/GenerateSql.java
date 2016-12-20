package com.orion10110.training.managertaxi.daodb.util;

import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.orion10110.taximanager.datamodel.anotation.IgnoreField;
/**
 * Класс создание sql запросов по классам
 * 
 * @author Калач Артур
 *
 */
public final class GenerateSql {

	/**
	 * Создание запроса insert
	 * @param model type of class
	 * @return строка запроса
	 */
	public static String generateSqlInsert(Class model) {
		List<String> nameFields = getListField(model); // Получение полей таблицы
		String insert = String.format("insert into %s (%s) values(:%s)", getTableName(model),
				UPPER_CAMEL.to(LOWER_UNDERSCORE, String.join(",", nameFields)),
				String.join(",:", nameFields));
		return insert;
	}
	
	/**
	 * Создание запроса update
	 * @param model type of class
	 * @return запрос Update
	 */
	public static String generateSqlUpdate(Class model) {
		List<String> nameFields = getListField(model); //Получение имен полей
		StringBuilder values = new StringBuilder();
		for (String name : nameFields) {
			values.append(UPPER_CAMEL.to(LOWER_UNDERSCORE, name));		//добавление имени поля таблицы
			values.append(String.format("=:%s,", name));				//добавление значения
		}
		values.deleteCharAt(values.lastIndexOf(","));					//удаление последней запятой
		return String.format("update %s set %s where id=:id",  getTableName(model), values);
	}

	/**
	 * Создание запроса на удаление записи
	 * @param model type of class
	 * @return запрос Delete
	 */
	public static String generateSqlDelete(Class model) {
		return String.format("delete from %s where id = ?",getTableName(model)); 
	}

	/**
	 * Создание запроса Select
	 * @param model  type of class
	 * @return запрос Select
	 */
	public static String generateSqlSelect(Class model) {
		return String.format("Select * from %s",getTableName(model));
	}

	/**
	 * Создание запроса Select по id
	 * @param model type of class
	 * @return запрос Select by id
	 */
	public static String generateSqlGetId(Class model) {
		String select = String.format("Select * from %s where id=?",getTableName(model));
		return select;
	}
	/**
	 * Получение имени таблицы
	 * @param model type of class
	 * @return имя таблицы
	 */
	private static String getTableName(Class model) {
		return UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName());
	}

	/**
	 * Получение имен полей
	 * @param model type of class
	 * @return список полей
	 */
	private static List<String> getListField(Class model) {
		Field[] fields = model.getDeclaredFields();
		List<String> vals = new ArrayList<>();

		for (Field field : fields) {
			if (field.getAnnotation(IgnoreField.class) == null) { //Игнорируем поле при наличии анотации
				vals.add(field.getName());
			}

		}
		return vals;
	}
	
	
}
