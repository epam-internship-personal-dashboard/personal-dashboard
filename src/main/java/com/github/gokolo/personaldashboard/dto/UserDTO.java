package com.github.gokolo.personaldashboard.dto;

import java.sql.Date;

import com.github.gokolo.personaldashboard.Builder;
import com.github.gokolo.personaldashboard.Gender;
import com.github.gokolo.personaldashboard.Role;

/**
 * 
 * @author Grace_Okolo
 *
 */
@SuppressWarnings("all")
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @SuppressWarnings("PMD")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserDTO other = (UserDTO) obj;
        if (birthday == null) {
            if (other.birthday != null) {
                return false;
            }
        } else if (!birthday.equals(other.birthday)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (gender != other.gender) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (role != other.role) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", name=" + name + ", addressId=" + addressId + ", username=" + username
                + ", password=" + password + ", birthday=" + birthday + ", email=" + email + ", gender=" + gender
                + ", role=" + role + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(final int uId) {
        id = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String uName) {
        name = uName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String uUsername) {
        username = uUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String uPassword) {
        password = uPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date uBirthday) {
        birthday = uBirthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String uEmail) {
        email = uEmail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender uGender) {
        gender = uGender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role uRole) {
        role = uRole;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(final int address) {
        this.addressId = address;
    }

}
