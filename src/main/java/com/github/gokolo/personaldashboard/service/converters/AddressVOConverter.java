package com.github.gokolo.personaldashboard.service.converters;

import org.springframework.core.convert.converter.Converter;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;

public class AddressVOConverter implements Converter<AddressVO, AddressDTO> {

    @Override
    public AddressDTO convert(AddressVO addressVO) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressVO.getId());
        addressDTO.setHouseNumber(addressVO.getHouseNumber());
        addressDTO.setStreet(addressVO.getStreet());
        addressDTO.setCity(addressVO.getCity());
        addressDTO.setCountry(addressVO.getCountry());
        addressDTO.setZipCode(addressVO.getZipCode());
        return addressDTO;
    }

}
