package com.github.gokolo.personaldashboard.dao;

import com.github.gokolo.personaldashboard.dto.AddressDTO;

public interface AddressDAO {

    AddressDTO save(AddressDTO user);

    AddressDTO findById(int id);

    int modify(AddressDTO user);

    void delete(AddressDTO user);
}
