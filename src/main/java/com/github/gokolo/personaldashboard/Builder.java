package com.github.gokolo.personaldashboard;

public class Builder {
    private final User user;

    public Builder() {
        this.user = new User();
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

    public Builder birthday(final String birthday) {
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

    public User build() {
        return this.user;
    }
}
