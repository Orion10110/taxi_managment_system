package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.orion10110.taximanager.datamodel.AbstractModel;

@Transactional
@TransactionConfiguration(defaultRollback = true)
public abstract class CrudTest<T extends AbstractModel> extends AbstractTest {

	protected T testObject;

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

	/**
	 * Deletes specified object from database.
	 *
	 * @param testObject
	 *            object to delete from database
	 */
	public abstract void delete(T testObject);

	/**
	 * Retrieves specified object from database. Makes the copy of specified
	 * object.
	 *
	 * @param id
	 *            of the object to retrieve from db
	 * @return copy of the specified object, that is retrieved from database
	 */
	public abstract T select(Long id);

	/**
	 * Updates specified object within the database.
	 *
	 * @param testObject
	 *            object to update
	 */
	public abstract void update(T testObject);

	/**
	 * Inserts specified object within the database.
	 *
	 * @param testObject
	 *            object to insert into database
	 */
	public abstract void insert(T testObject);

	/**
	 * You should implement this method for your tests and change the your test
	 * object somehow
	 *
	 * @param testObject
	 *            object to change
	 */
	public abstract void changeTestObject(T testObject);

	/**
	 * Compares two methods for the equality.
	 *
	 * @param selected
	 *            the selected entity
	 * @param testObject
	 *            the object that is tested
	 */
	public void compare(T selected, T testObject) {
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
	public T getTestObject() {
		return testObject;
	}

	/**
	 * Sets the test object. The object should be injected before test begining.
	 *
	 * @param testObject
	 *            the object to test
	 */
	public void setTestObject(T testObject) {
		this.testObject = testObject;
	}
}