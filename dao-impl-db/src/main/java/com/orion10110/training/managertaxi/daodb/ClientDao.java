package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Client;

public interface ClientDao {
	Client get(Long id);

    void insert(Client entity);

    void update(Client entity);

    void delete(Long id);

    List<Client> getAll();
}
