package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Order;
import com.orion10110.training.managertaxi.daodb.OrderDao;
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order,Long> implements OrderDao {

	@Override
	protected String getSqlInsert() {
			return "insert [order] (phone_number,id_client,id_status,date_order,start_value,"
					+ "end_value,id_application_user,id_street_from,id_street_to,id_driver)"
					+" values(:phoneNumber,:idClient,:idStatus,:idStatus,:startValue,"
					+ ":endValue,:idApplicationUser,:idStreetFrom,:idStreetTo,:idDriver)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update [order] phone_number=:phoneNumber,id_client=:idClient,id_status=:idStatus,date_order=:idStatus,"
				+ "start_value=:startValue,end_value=:endValue,id_application_user=:idApplicationUser,id_street_from=:idStreetFrom,"
				+ "id_street_to=:idStreetTo,id_driver=:idDriver where id = :id";
	}

	@Override
	protected String getTable() {
		return "[order]";
	}

}
