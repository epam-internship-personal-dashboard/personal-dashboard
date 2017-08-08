package com.github.gokolo.personaldashboard.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.github.gokolo.personaldashboard.data.entities.UserEntity;
import com.github.gokolo.personaldashboard.data.repository.UserRepository;
import com.github.gokolo.personaldashboard.service.models.UserVO;

/**
 * This is a service layer class. It holds the methods/actions for UserVO.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 *
 * @see com.github.gokolo.personaldashboard.data.entities.UserEntity
 * @see com.github.gokolo.personaldashboard.data.dao.UserDAO;
 * @see com.github.gokolo.personaldashboard.data.dto.AddressDTO;
 * @see com.github.gokolo.personaldashboard.data.dao.AddressDAO;
 */
@Service
@SuppressWarnings("PMD")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

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
        List<UserVO> users = new ArrayList<>();
        // lambda expression
        // It can be used to implement functional (one-method) interfaces in a
        // more concise way instead of anonym classes
        userRepo.findAll().forEach(user -> users.add(conversionService.convert(user, UserVO.class)));
        return users;
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
    public void save(final UserVO userVO) {
        UserEntity userEntity = conversionService.convert(userVO, UserEntity.class);
        userRepo.save(userEntity);
    }

    @Override
    public void delete(final UserVO userVO) {
        UserEntity userEntity = conversionService.convert(userVO, UserEntity.class);
        userRepo.delete(userEntity);
    }

}
