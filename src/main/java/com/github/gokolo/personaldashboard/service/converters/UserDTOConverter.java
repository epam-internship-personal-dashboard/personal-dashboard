package com.github.gokolo.personaldashboard.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dao.AddressDAO;
import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
public class UserDTOConverter implements Converter<UserDTO, UserVO> {
    @Autowired
    private AddressDAO addressDAO;

    @Override
    public UserVO convert(UserDTO userDTO) {
        UserVO userVO = new UserVO();
        AddressVO addressVO = new AddressVO();
        AddressDTO addressDTO = addressDAO.findById(userDTO.getAddressId());
        userVO.setId(userDTO.getId());
        userVO.setName(userDTO.getName());
        userVO.setUsername(userDTO.getUsername());
        userVO.setPassword(userDTO.getPassword());
        userVO.setBirthday(userDTO.getBirthday());
        userVO.setEmail(userDTO.getEmail());
        userVO.setGender(userDTO.getGender());
        userVO.setRole(userDTO.getRole());

        addressVO.setHouseNumber(addressDTO.getHouseNumber());
        addressVO.setStreet(addressDTO.getStreet());
        addressVO.setCity(addressDTO.getCity());
        addressVO.setZipCode(addressDTO.getZipCode());
        addressVO.setCountry(addressDTO.getCountry());

        userVO.setAddress(addressVO);
        return userVO;
    }

}
