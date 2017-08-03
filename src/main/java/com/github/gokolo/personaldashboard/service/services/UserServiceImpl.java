package com.github.gokolo.personaldashboard.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.dao.AddressDAO;
import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.data.dto.AddressDTO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
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

    @Autowired
    private ConversionService conversionService;

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
                    userVOCollection.add(conversionService.convert(userDTO, UserVO.class));
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
    public UserVO findByUsername(final String username) {
        UserDTO userDTO = userDAO.findByUsername(username);
        return conversionService.convert(userDTO, UserVO.class);
    }

    @Override
    public void save(final UserVO userVO) {
        UserDTO userDTO = conversionService.convert(userVO, UserDTO.class);
        AddressDTO addressDTO = conversionService.convert(userVO.getAddress(), AddressDTO.class);
        addressDTO = addressDAO.save(addressDTO);
        userDTO.setAddressId(addressDTO.getId());
        userDAO.save(userDTO);
    }

    @Override
    public void modify(final UserVO userVO) {
        UserDTO userDTO = conversionService.convert(userVO, UserDTO.class);
        AddressDTO addressDTO = conversionService.convert(userVO.getAddress(), AddressDTO.class);
        userDAO.modify(userDTO);
        addressDAO.modify(addressDTO);
    }

    @Override
    public void delete(final UserVO userVO) {
        UserDTO userDTO = conversionService.convert(userVO, UserDTO.class);
        AddressDTO addressDTO = conversionService.convert(userVO.getAddress(), AddressDTO.class);
        userDAO.delete(userDTO);
        addressDAO.delete(addressDTO);

    }

    @Override
    public UserVO findByUsernamePassword(final String username, final String password) {
        UserDTO userDTO = userDAO.findByUsernamePassword(username, password);
        return conversionService.convert(userDTO, UserVO.class);
    }

}
