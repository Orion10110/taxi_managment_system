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
	protected void setParamsForInsert(PreparedStatement ps, Discount entity) throws SQLException {
		ps.setString(1, entity.getName());
		ps.setInt(2,entity.getDiscountPercent());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(Discount entity) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(entity.getName());
		list.add(entity.getDiscountPercent());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return "insert into discount (name,discount_percent) values(?,?)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update discount set name=?,discount_percent=? where id=?"; 
	}

	@Override
	protected String getTable() {
		return "discount";
	}

}
