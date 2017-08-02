package com.github.gokolo.personaldashboard.data.dto;

import java.sql.Date;

import com.github.gokolo.personaldashboard.data.enums.Gender;
import com.github.gokolo.personaldashboard.data.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Grace_Okolo
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class UserDTO {
    private int id;
    private String name;
    private int addressId;
    private String username;
    private String password;
    private Date birthday;
    private String email;
    private Gender gender;
    private Role role;
}
