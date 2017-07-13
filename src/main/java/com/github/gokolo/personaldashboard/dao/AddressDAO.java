package com.github.gokolo.personaldashboard.dao;

import com.github.gokolo.personaldashboard.dto.AddressDTO;

public interface AddressDAO {

    int save(AddressDTO user);

    // List<AddressDTO> findAll();

    AddressDTO findById(int id);

    AddressDTO modify(AddressDTO user);

    void delete(AddressDTO user);
}
