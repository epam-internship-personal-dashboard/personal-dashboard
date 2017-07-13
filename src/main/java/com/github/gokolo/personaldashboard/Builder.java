package com.github.gokolo.personaldashboard;

import java.sql.Date;

import com.github.gokolo.personaldashboard.dto.UserDTO;

public class Builder {
    private final UserDTO user;

    public Builder() {
        this.user = new UserDTO();
    }

    public Builder id(final int id) {
        user.setId(id);
        return this;
    }

    public Builder name(final String name) {
        user.setName(name);
        return this;
    }

    public Builder username(final String username) {
        user.setUsername(username);
        return this;
    }

    public Builder password(final String password) {
        user.setPassword(password);
        return this;
    }

    public Builder birthday(final Date birthday) {
        user.setBirthday(birthday);
        return this;
    }

    public Builder email(final String email) {
        user.setEmail(email);
        return this;
    }

    public Builder gender(final Gender gender) {
        user.setGender(gender);
        return this;
    }

    public Builder role(final Role role) {
        user.setRole(role);
        return this;
    }

    public UserDTO build() {
        return this.user;
    }
}
