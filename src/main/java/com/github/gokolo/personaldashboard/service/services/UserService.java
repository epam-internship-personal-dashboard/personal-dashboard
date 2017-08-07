package com.github.gokolo.personaldashboard.service.services;

import java.util.List;

import com.github.gokolo.personaldashboard.service.models.UserVO;

/**
 * This is a data layer interface holds the methods and actions for UserVO.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 * @see com.github.gokolo.personaldashboard.entities.UserEntity
 */

public interface UserService {

    List<UserVO> findAll();

    UserVO findByUsername(String username);

    void modify(UserVO userVO);

    void delete(UserVO userVO);

    UserVO findByUsernamePassword(String username, String password);

    void save(UserVO userVO);

}
