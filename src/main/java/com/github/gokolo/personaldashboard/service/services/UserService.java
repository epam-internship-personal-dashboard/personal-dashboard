package com.github.gokolo.personaldashboard.service.services;

import java.util.List;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

/**
 * This is a data layer interface holds the methods and actions for UserVO.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 * @see com.github.gokolo.personaldashboard.data.dto.UserDTO
 */

public interface UserService {
    UserVO convertToVO(UserDTO user, AddressDTO address);

    UserVO convertToDTO(UserVO userVO);

    List<UserVO> findAll();

    UserVO findById(int id);

    void modify(UserVO user);

    void delete(UserVO user);

    UserVO findByUsernamePassword(String username, String password);

}
