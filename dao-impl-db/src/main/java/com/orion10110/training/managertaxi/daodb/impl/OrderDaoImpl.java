package com.orion10110.training.managertaxi.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	@Override
	public Long InsertToMap(final Order order) {
		final String INSERT_SQL = "insert [order] (phone_number,id_client,id_status,date_order,start_value,"
					+ "end_value,id_application_user,id_street_from,id_street_to,id_driver)"
					+" values(?,?,?,?,?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(
                    Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        INSERT_SQL, new String[] { "id" });
                ps.setString(1, order.getPhoneNumber());
                ps.setLong(2, order.getIdClient());
                ps.setLong(3, order.getIdStatus());
                ps.setTimestamp(4,order.getDateOrder() );
                ps.setInt(5, order.getStartValue());
                ps.setInt(6, order.getEndValue());
                ps.setLong(7, order.getIdApplicationUser());
                ps.setLong(8, order.getIdStreetFrom());
                ps.setLong(9, order.getIdStreetTo());
                ps.setLong(10, order.getIdDriver());
                return ps;
            }
        }, keyHolder);

        order.setId(keyHolder.getKey().longValue());

        return order.getId();
	}

}
