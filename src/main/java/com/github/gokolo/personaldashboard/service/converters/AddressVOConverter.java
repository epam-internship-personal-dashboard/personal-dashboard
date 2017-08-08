package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.entities.AddressEntity;
import com.github.gokolo.personaldashboard.service.models.AddressVO;

@Service
public class AddressVOConverter implements Converter<AddressVO, AddressEntity> {
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public AddressEntity convert(final AddressVO addressVO) {
        return mapper.map(addressVO, AddressEntity.class);
    }

}
