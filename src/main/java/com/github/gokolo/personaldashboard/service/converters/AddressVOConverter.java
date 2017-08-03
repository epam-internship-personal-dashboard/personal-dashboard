package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;

@Service
public class AddressVOConverter implements Converter<AddressVO, AddressDTO> {
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public AddressDTO convert(final AddressVO addressVO) {
        return mapper.map(addressVO, AddressDTO.class);
    }

}
