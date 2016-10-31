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
	protected String getSqlInsert() {
		return "insert into client (first_name,second_name,patronymic,phone_number,id_discount)"
				+" values(:firstName,:secondName,:patronymic,:phoneNumber,:idDiscount)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update client set first_name=:firstName,second_name=:secondName,patronymic=:patronymic,phoneNumber=:phoneNumber,"
				+ "id_discount=:idDiscount where id=:id";
	}

	@Override
	protected String getTable() {
		return "client";
	}

}
