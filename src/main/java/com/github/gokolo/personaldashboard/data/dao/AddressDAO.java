package com.github.gokolo.personaldashboard.data.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;

@Component
public interface AddressDAO {

    AddressDTO save(AddressDTO address);

    AddressDTO findById(int id);

    void modify(AddressDTO address);

    void delete(AddressDTO address);

    List<AddressDTO> findAll();
}
