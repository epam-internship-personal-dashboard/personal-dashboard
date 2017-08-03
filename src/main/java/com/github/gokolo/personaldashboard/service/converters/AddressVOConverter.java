package com.github.gokolo.personaldashboard.service.converters;

import org.dozer.DozerBeanMapper;
import org.springframework.core.convert.converter.Converter;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;

public class AddressVOConverter implements Converter<AddressVO, AddressDTO> {
    private final DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public AddressDTO convert(final AddressVO addressVO) {
        return mapper.map(addressVO, AddressDTO.class);
    }

}
