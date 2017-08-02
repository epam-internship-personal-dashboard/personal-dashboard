package com.github.gokolo.personaldashboard.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dao.AddressDAO;
import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.service.models.AddressVO;
import com.github.gokolo.personaldashboard.service.models.UserVO;

/**
 * This is a service layer class. It holds the methods/actions for UserVO.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 *
 * @see com.github.gokolo.personaldashboard.data.dto.UserDTO
 * @see com.github.gokolo.personaldashboard.data.dao.UserDAO;
 * @see com.github.gokolo.personaldashboard.data.dto.AddressDTO;
 * @see com.github.gokolo.personaldashboard.data.dao.AddressDAO;
 */
@Service
@SuppressWarnings("PMD")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AddressDAO addressDAO;

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

    /**
     * This method uses the
     * {@link com.github.gokolo.personaldashboard.data.dao.UserDAO#findAll()}
     * and
     * {@link com.github.gokolo.personaldashboard.data.dao.AddressDAO#findAll()}
     * methods to get the Address and User DTO objects. Then it uses
     * {@link UserService#convertToVO(final UserDTO userDTO, final AddressDTO
     * addressDTO)} to convert them into one UserVO object and adds all the
     * objects to a List Collection of UserVOs.
     * 
     * @return List Collection of type UserVO
     * @author Grace_Okolo
     * @version 0.4.0
     * @since 02/08/2017
     */
    @Override
    public List<UserVO> findAll() {
        List<UserVO> userVOCollection = new ArrayList<>();

        List<UserDTO> userDTOCollection = userDAO.findAll();
        List<AddressDTO> addressDTOCollection = addressDAO.findAll();

        for (UserDTO userDTO : userDTOCollection) {
            for (AddressDTO addressDTO : addressDTOCollection) {
                if (userDTO.getAddressId() == addressDTO.getId()) {
                    userVOCollection.add(convertToVO(userDTO, addressDTO));
                }
            }
        }
        return userVOCollection;
    }

    /**
     * This method uses the
     * {@link com.github.gokolo.personaldashboard.data.dao.UserDAO#findByUsername(String username)}
     * and
     * {@link com.github.gokolo.personaldashboard.data.dao.AddressDAO#findById(int id)}
     * methods to get the User and Address DTO objects. Then it uses
     * {@link UserService#convertToVO(final UserDTO userDTO, final AddressDTO
     * addressDTO)} to convert them into one UserVO object.
     * 
     * @return UserVO object
     * @author Grace_Okolo
     * @version 0.4.0
     * @since 02/08/2017
     */
    @Override
    public UserVO findByUsername(String username) {
        UserDTO userDTO = userDAO.findByUsername(username);
        AddressDTO addressDTO = addressDAO.findById(userDTO.getAddressId());
        UserVO userVO = convertToVO(userDTO, addressDTO);
        return userVO;
    }

    @Override
    public AddressDTO convertAddressToDTO(final UserVO userVO) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(userVO.getAddress().getId());
        addressDTO.setHouseNumber(userVO.getAddress().getHouseNumber());
        addressDTO.setStreet(userVO.getAddress().getStreet());
        addressDTO.setCity(userVO.getAddress().getCity());
        addressDTO.setCountry(userVO.getAddress().getCountry());
        addressDTO.setZipCode(userVO.getAddress().getZipCode());
        return addressDTO;
    }

    @Override
    public UserDTO convertUserToDTO(final UserVO userVO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userVO.getId());
        userDTO.setName(userVO.getName());
        userDTO.setUsername(userVO.getUsername());
        userDTO.setPassword(userVO.getPassword());
        userDTO.setBirthday(userVO.getBirthday());
        userDTO.setAddressId(userVO.getAddress().getId());
        userDTO.setEmail(userVO.getEmail());
        userDTO.setGender(userVO.getGender());
        userDTO.setRole(userVO.getRole());
        return userDTO;
    }

    @Override
    public void save(UserVO userVO) {
        UserDTO userDTO = convertUserToDTO(userVO);
        AddressDTO addressDTO = convertAddressToDTO(userVO);
        userDAO.save(userDTO);
        addressDAO.save(addressDTO);
    }

    @Override
    public void modify(UserVO userVO) {
        UserDTO userDTO = convertUserToDTO(userVO);
        AddressDTO addressDTO = convertAddressToDTO(userVO);
        userDAO.modify(userDTO);
        addressDAO.modify(addressDTO);
    }

    @Override
    public void delete(UserVO userVO) {
        UserDTO userDTO = convertUserToDTO(userVO);
        AddressDTO addressDTO = convertAddressToDTO(userVO);
        userDAO.delete(userDTO);
        addressDAO.delete(addressDTO);

    }

    @Override
    public UserVO findByUsernamePassword(String username, String password) {
        UserDTO userDTO = userDAO.findByUsernamePassword(username, password);
        AddressDTO addressDTO = addressDAO.findById(userDTO.getAddressId());
        UserVO userVO = convertToVO(userDTO, addressDTO);
        return userVO;
    }

}
