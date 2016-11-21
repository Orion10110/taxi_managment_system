package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.orion10110.taximanager.datamodel.AbstractModel;

public abstract class CrudTest<T extends AbstractModel> extends AbstractTest {

	protected T testObject;

	private Class<? extends T> testClass;

	@Autowired
	ApplicationContext context;

	public CrudTest() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		testClass = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Tests the CRUD(create, read, update, delete) operations.First, it inserts
	 * the test object into database. Second, it retrieves the saved data and
	 * compares with test object. Third, it makes update to database and repeats
	 * the second step. Then it deletes test object from database and tries to
	 * obtain it from database. If the retrieved object is not null, then the
	 * object was not deleted from database and assertion would fail.
	 */
	@Test
	public void testCRUD() {
		List<T> listTest = createList();
		saveAll(listTest);
		compareList(listTest);
		insert(testObject);
		T selected = select(testObject.getId());
		compare(selected, testObject);

		changeTestObject(testObject);
		update(testObject);
		selected = select(testObject.getId());
		compare(selected, testObject);

		delete(testObject);

		try {
			selected = select(testObject.getId());
			fail("Expected an EmptyResultDataAccessException to be thrown");
		} catch (EmptyResultDataAccessException anEmptyResultDataAccessException) {

		}

	}

	private List<T> createList() {
		ArrayList<T> listTestObject = new ArrayList<T>();
		for (int i = 0; i < 10; i++) {
			listTestObject.add(context.getBean(testClass));
		}
		return listTestObject;
	}

	private void compareList(List<T> listObject) {
		T selected;
		for (T t : listObject) {
			selected = select(t.getId());
			compare(t, selected);
		}
	}

	/**
	 * Deletes specified object from database.
	 *
	 * @param testObject
	 *            object to delete from database
	 */
	protected abstract void delete(T testObject);

	/**
	 * Retrieves specified object from database. Makes the copy of specified
	 * object.
	 *
	 * @param id
	 *            of the object to retrieve from db
	 * @return copy of the specified object, that is retrieved from database
	 */
	protected abstract T select(Long id);

	/**
	 * Updates specified object within the database.
	 *
	 * @param testObject
	 *            object to update
	 */
	protected abstract void update(T testObject);

	/**
	 * Inserts specified object within the database.
	 *
	 * @param testObject
	 *            object to insert into database
	 */
	protected abstract void insert(T testObject);

	/**
	 * You should implement this method for your tests and change the your test
	 * object somehow
	 *
	 * @param testObject
	 *            object to change
	 */
	protected abstract void changeTestObject(T testObject);

	protected abstract void saveAll(List<T> testObject);

	/**
	 * Compares two methods for the equality.
	 *
	 * @param selected
	 *            the selected entity
	 * @param testObject
	 *            the object that is tested
	 */
	protected void compare(T selected, T testObject) {
		assertNotNull("selected is null", selected);
		assertTrue(selected.equals(testObject));
	}

	/**
	 * Gets the object that is tested, which is specified in the constructor of
	 * the class.
	 *
	 * @return the object that is tested, which is specified in the constructor
	 *         of the class
	 */
	protected T getTestObject() {
		return testObject;
	}

	/**
	 * Sets the test object. The object should be injected before test begining.
	 *
	 * @param testObject
	 *            the object to test
	 */
	protected void setTestObject(T testObject) {
		this.testObject = testObject;
	}
}