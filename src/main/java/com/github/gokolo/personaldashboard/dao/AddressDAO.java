package com.github.gokolo.personaldashboard.dao;

import com.github.gokolo.personaldashboard.dto.AddressDTO;

public interface AddressDAO {

    AddressDTO save(AddressDTO address);

    AddressDTO findById(int id);

    void modify(AddressDTO address);

    void delete(AddressDTO address);
}
