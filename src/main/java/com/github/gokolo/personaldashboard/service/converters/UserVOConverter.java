package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
public class UserVOConverter implements Converter<UserVO, UserDTO> {

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public UserDTO convert(final UserVO userVO) {
        UserDTO userDTO = mapper.map(userVO, UserDTO.class);
        userDTO.setAddressId(userVO.getAddress().getId());
        return userDTO;
    }

}
