package com.github.gokolo.personaldashboard.service.models;

import java.util.Date;

import com.github.gokolo.personaldashboard.data.enums.Gender;
import com.github.gokolo.personaldashboard.data.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a service layer class derived from UserDTO to model a User object
 * containing its address object.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 *
 * @see com.github.gokolo.personaldashboard.data.entities.UserEntity
 * @see com.github.gokolo.personaldashboard.service.models.AddressVO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private int id;
    private String name;
    private AddressVO address;
    private String username;
    private String password;
    private Date birthday;
    private String email;
    private int enabled;
    private Gender gender;
    private Role role;
}
