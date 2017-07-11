package com.github.gokolo.personaldashboard;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String birthday;
    private String email;
    private Gender gender;
    private Role role;

    @Override
    @SuppressWarnings("PMD")
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

    @Override
    @SuppressWarnings("PMD")
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
        User other = (User) obj;
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
        return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", birthday="
                + birthday + ", email=" + email + ", gender=" + gender + ", role=" + role + "]";
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

    public void setpassword(final String uPassword) {
        password = uPassword;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(final String uBirthday) {
        birthday = uBirthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String uEmail) {
        email = uEmail;
    }

}
