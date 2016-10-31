package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daodb.DiscountDao;

@Repository
public class DiscountDaoImpl extends GenericDaoImpl<Discount,Long> implements DiscountDao {


	@Override
	protected String getSqlInsert() {
		return "insert into discount (name,discount_percent) values(:name,:discountPercent)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update discount set name=:name,discount_percent=:discountPercent where id=:id"; 
	}

	@Override
	protected String getTable() {
		return "discount";
	}

}
