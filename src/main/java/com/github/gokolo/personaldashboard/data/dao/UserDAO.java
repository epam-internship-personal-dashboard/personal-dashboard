package com.github.gokolo.personaldashboard.data.dao;

import java.util.List;

import com.github.gokolo.personaldashboard.entities.UserEntity;

/**
 * This is a data layer interface holds the methods and actions for UserDTO.
 * 
 * @author Grace_Okolo
 *
 * @see com.github.gokolo.personaldashboard.entities.UserEntity
 */
public interface UserDAO {
    int save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findById(int id);

    void modify(UserEntity user);

    void delete(UserEntity user);

    UserEntity findByUsernamePassword(String username, String password);

    UserEntity findByUsername(String username);
}
