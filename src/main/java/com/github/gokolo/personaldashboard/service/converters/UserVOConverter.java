package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.entities.UserEntity;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
public class UserVOConverter implements Converter<UserVO, UserEntity> {
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public UserEntity convert(final UserVO userVO) {
        return mapper.map(userVO, UserEntity.class);
    }

}
