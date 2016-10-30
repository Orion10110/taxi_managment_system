package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.daodb.StatusDao;

@Repository
public class StatusDaoImpl extends GenericDaoImpl<Status,Long> implements StatusDao {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, Status entity) throws SQLException {
		ps.setString(1, entity.getStatus());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(Status entity) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(entity.getStatus());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return "insert into status (status) values(?)";
	}

	@Override
	protected String getSqlUpdate() {
			return "update status set status=? where id=?";
	}

	@Override
	protected String getTable() {
		return "status";
	}

	

}
