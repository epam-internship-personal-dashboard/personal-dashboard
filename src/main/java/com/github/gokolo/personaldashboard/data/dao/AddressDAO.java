package com.github.gokolo.personaldashboard.data.dao;

import java.util.List;

import com.github.gokolo.personaldashboard.entities.AddressEntity;

public interface AddressDAO {

    AddressEntity save(AddressEntity address);

    AddressEntity findById(int id);

    void modify(AddressEntity address);

    void delete(AddressEntity address);

    List<AddressEntity> findAll();
}
