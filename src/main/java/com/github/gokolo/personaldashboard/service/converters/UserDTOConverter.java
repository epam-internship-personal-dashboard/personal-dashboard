package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.entities.UserEntity;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
public class UserDTOConverter implements Converter<UserEntity, UserVO> {
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public UserVO convert(final UserEntity userDTO) {
        return mapper.map(userDTO, UserVO.class);
    }

}
