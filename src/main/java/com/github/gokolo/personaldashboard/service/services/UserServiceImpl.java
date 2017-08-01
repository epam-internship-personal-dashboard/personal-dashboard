package com.github.gokolo.personaldashboard.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

@Service
@SuppressWarnings("PMD")
public class UserServiceImpl implements UserService {

    @Override
    public UserVO convertToVO(final UserDTO userDTO, final AddressDTO addressDTO) {
        UserVO userVO = new UserVO();
        AddressVO addressVO = new AddressVO();
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

    @Override
    public List<UserVO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserVO findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void modify(UserVO user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(UserVO user) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserVO findByUsernamePassword(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserVO convertToDTO(UserVO userVO) {
        // TODO Auto-generated method stub
        return null;
    }

}
