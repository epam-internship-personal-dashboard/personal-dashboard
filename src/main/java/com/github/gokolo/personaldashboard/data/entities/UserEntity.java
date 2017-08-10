package com.github.gokolo.personaldashboard.data.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {
    private String name;
    private int enabled;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    private String username;
    private String password;
    private Date birthday;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;
}
