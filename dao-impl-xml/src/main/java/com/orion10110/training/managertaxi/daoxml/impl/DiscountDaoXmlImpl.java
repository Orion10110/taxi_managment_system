package com.orion10110.training.managertaxi.daoxml.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daoapi.DiscountDao;

@Repository
public class DiscountDaoXmlImpl extends GenericDaoXmlImpl<Discount> implements DiscountDao {

}
