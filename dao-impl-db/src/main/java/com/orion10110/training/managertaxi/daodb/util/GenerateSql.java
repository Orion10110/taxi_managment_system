package com.orion10110.training.managertaxi.daodb.util;

import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class GenerateSql {

	public static String generateSqlInsert(Class model) {

		String dbName = UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName());

		List<String> nameFields = getListField(model);
		String insert = String.format("insert into %s (%s) values(:%s)", dbName,
				UPPER_CAMEL.to(LOWER_UNDERSCORE, String.join(",", nameFields)),
				String.join(",:", nameFields));
		return insert;
	}

	private static List<String> getListField(Class model) {
		Field[] fields = model.getDeclaredFields();
		List<String> vals = new ArrayList<>();

		for (Field field : fields) {
			vals.add(field.getName());
		}
		return vals;
	}

	public static String generateSqlUpdate(Class model) {
		String dbName = UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName());
		List<String> nameFields = getListField(model);
		StringBuilder values = new StringBuilder();
		for (String name : nameFields) {
			values.append(UPPER_CAMEL.to(LOWER_UNDERSCORE, name));
			values.append(String.format("=:%s,", name));
		}
		values.deleteCharAt(values.lastIndexOf(","));
		String update = String.format("update %s set %s where id=:id", dbName, values);
		return update;
	}

	public static String generateSqlDelete(Class model) {
		String delete = String.format("delete from %s where id = ?",
				UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName()));
		return delete;
	}

	public static String generateSqlSelect(Class model) {
		String select = String.format("Select * from %s", UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName()));
		return select;
	}

	public static String generateSqlGetId(Class model) {
		String select = String.format("Select * from %s where id=?",
				UPPER_CAMEL.to(LOWER_UNDERSCORE, model.getSimpleName()));
		return select;
	}
}
