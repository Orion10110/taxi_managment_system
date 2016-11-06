package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.training.managertaxi.daodb.BookingDao;
@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking,Long> implements BookingDao {

	@Override
	protected String getSqlInsert() {
			return "insert booking (phone_number,id_client,id_status,date_order,start_value,"
					+ "end_value,id_application_user,id_street_from,id_street_to,id_driver)"
					+" values(:phoneNumber,:idClient,:idStatus,:dateOrder,:startValue,"
					+ ":endValue,:idApplicationUser,:idStreetFrom,:idStreetTo,:idDriver)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update booking set phone_number=:phoneNumber,id_client=:idClient,id_status=:idStatus,date_order=:idStatus,"
				+ "start_value=:startValue,end_value=:endValue,id_application_user=:idApplicationUser,id_street_from=:idStreetFrom,"
				+ "id_street_to=:idStreetTo,id_driver=:idDriver where id = :id";
	}

	@Override
	protected String getTable() {
		return "booking";
	}

}
