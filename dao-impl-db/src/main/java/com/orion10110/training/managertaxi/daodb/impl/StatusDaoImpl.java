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
	protected String getSqlInsert() {
		return "insert into status (status) values(:status)";
	}

	@Override
	protected String getSqlUpdate() {
			return "update status set status=:status where id=:id";
	}

	@Override
	protected String getTable() {
		return "status";
	}

	

}
