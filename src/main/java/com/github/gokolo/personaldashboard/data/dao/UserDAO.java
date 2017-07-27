package com.github.gokolo.personaldashboard.data.dao;

import java.util.List;

import com.github.gokolo.personaldashboard.data.dto.UserDTO;

public interface UserDAO {
    int save(UserDTO user);

    List<UserDTO> findAll();

    UserDTO findById(int id);

    void modify(UserDTO user);

    void delete(UserDTO user);

    UserDTO findByUsernamePassword(String username, String password);
}
