package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
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

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public UserVO convert(final UserDTO userDTO) {
        UserVO userVO = mapper.map(userDTO, UserVO.class);
        AddressDTO addressDTO = addressDAO.findById(userDTO.getAddressId());
        AddressVO addressVO = mapper.map(addressDTO, AddressVO.class);
        userVO.setAddress(addressVO);
        return userVO;
    }

}
