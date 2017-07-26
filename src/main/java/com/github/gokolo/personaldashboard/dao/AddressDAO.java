package com.github.gokolo.personaldashboard.dao;

import java.util.List;

import com.github.gokolo.personaldashboard.dto.AddressDTO;

public interface AddressDAO {

    AddressDTO save(AddressDTO address);

    AddressDTO findById(int id);

    void modify(AddressDTO address);

    void delete(AddressDTO address);

    List<AddressDTO> findAll();
}
