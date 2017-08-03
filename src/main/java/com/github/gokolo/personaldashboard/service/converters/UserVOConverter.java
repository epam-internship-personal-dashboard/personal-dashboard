package com.github.gokolo.personaldashboard.service.converters;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
public class UserVOConverter implements Converter<UserVO, UserDTO> {
    @Override
    public UserDTO convert(UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userVO.getId());
        userDTO.setName(userVO.getName());
        userDTO.setUsername(userVO.getUsername());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setBirthday(new Date(userVO.getBirthday().getTime()));
        userDTO.setAddressId(userVO.getAddress().getId());
        userDTO.setEmail(userVO.getEmail());
        userDTO.setGender(userVO.getGender());
        userDTO.setRole(userVO.getRole());
        return userDTO;
    }

}
