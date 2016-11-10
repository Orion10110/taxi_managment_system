package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.daodb.ClientDao;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client, Long> implements ClientDao {

	@Override
	protected String getSqlInsert() {
		String insert = String.format("insert into client (%s)  values(%s)", 
				"first_name,second_name,patronymic,phone_number,id_discount",
				":firstName,:secondName,:patronymic,:phoneNumber,:idDiscount");
		return insert;
	}

	@Override
	protected String getSqlUpdate() {
		String update = String.format("update client set %s", 
				"first_name=:firstName,second_name=:secondName,patronymic=:patronymic,phone_number=:phoneNumber,id_discount=:idDiscount where id=:id");
		return update;
	}

	@Override
	protected String getTable() {
		return "client";
	}

}
