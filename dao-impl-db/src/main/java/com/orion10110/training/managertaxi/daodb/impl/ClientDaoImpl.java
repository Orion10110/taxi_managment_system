package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.daodb.ClientDao;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client,Long> implements ClientDao {

	@Override
	protected void setParamsForInsert(PreparedStatement ps, Client entity) throws SQLException {
		ps.setString(1,entity.getFirstName());
		ps.setString(2, entity.getSecondName());
		ps.setString(3, entity.getPatronymic());
		ps.setString(4, entity.getPhoneNumber());
		ps.setLong(5, entity.getIdDiscount());
		
	}

	@Override
	protected List<Object> setParamsForUpdate(Client entity) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(entity.getFirstName());
		list.add(entity.getSecondName());
		list.add(entity.getPatronymic());
		list.add(entity.getPhoneNumber());
		list.add(entity.getIdDiscount());
		return list;
	}

	@Override
	protected String getSqlInsert() {
		return "insert into client (first_name,second_name,patronymic,phone_number,id_discount)"
				+" values(?,?,?,?,?)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update client set first_name=?,second_name=?,patronymic=?,phone_number=?,id_discount=?"
				+"where id=?";
	}

	@Override
	protected String getTable() {
		return "client";
	}

}
