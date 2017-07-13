package com.github.gokolo.personaldashboard.dao;

import java.util.List;

import com.github.gokolo.personaldashboard.dto.UserDTO;

public interface UserDAO {
    int save(UserDTO user);

    List<UserDTO> findAll();

    UserDTO findById(int id);

    UserDTO modify(UserDTO user);

    void delete(UserDTO user);
}
