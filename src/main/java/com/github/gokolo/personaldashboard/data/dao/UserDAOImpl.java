package com.github.gokolo.personaldashboard.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.gokolo.personaldashboard.data.enums.Gender;
import com.github.gokolo.personaldashboard.data.enums.Role;
import com.github.gokolo.personaldashboard.entities.UserEntity;

@Repository
@SuppressWarnings("PMD")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private DataSource dataSource;
    private static final int PARA_ONE = 1;
    private static final int PARA_TWO = 2;
    private static final int PARA_THREE = 3;
    private static final int PARA_FOUR = 4;
    private static final int PARA_FIVE = 5;
    private static final int PARA_SIX = 6;
    private static final int PARA_SEVEN = 7;
    private static final int PARA_EIGHT = 8;

    @Override
    public int save(final UserEntity user) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
                    "INSERT INTO user (name,username,email,password,birthday,gender,role,address_id) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(PARA_ONE, user.getName());
            preparedStatement.setString(PARA_TWO, user.getUsername());
            preparedStatement.setString(PARA_THREE, user.getEmail());
            preparedStatement.setString(PARA_FOUR, user.getPassword());
            preparedStatement.setDate(PARA_FIVE, user.getBirthday());
            preparedStatement.setString(PARA_SIX, user.getGender().name());
            preparedStatement.setString(PARA_SEVEN, user.getRole().name());
            preparedStatement.setInt(PARA_EIGHT, user.getAddressId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("User SQLException: " + ex.getMessage());
            System.out.println("User SQLState: " + ex.getSQLState());
            System.out.println("User VendorError: " + ex.getErrorCode());
        }
        return rowsAffected;
    }

    @Override
    public List<UserEntity> findAll() {
        Statement statement;
        ResultSet resultSet;
        List<UserEntity> userCollection = new ArrayList<>();
        try {
            statement = dataSource.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                userCollection.add(convert(resultSet));
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userCollection;
    }

    @Override
    public UserEntity findById(final int id) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        UserEntity user = new UserEntity();
        try {
            preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM user WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = convert(resultSet);
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserEntity findByUsernamePassword(final String username, final String password) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        UserEntity user = null;
        try {
            preparedStatement = dataSource.getConnection()
                    .prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = convert(resultSet);
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserEntity findByUsername(final String username) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        UserEntity user = null;
        try {
            preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM user WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = convert(resultSet);
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void modify(final UserEntity user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dataSource.getConnection().prepareStatement(
                    "UPDATE user SET name=?,username=?,email=?,password=?,birthday=?,gender=?,role=? WHERE id=?");
            preparedStatement.setString(PARA_ONE, user.getName());
            preparedStatement.setString(PARA_TWO, user.getUsername());
            preparedStatement.setString(PARA_THREE, user.getEmail());
            preparedStatement.setString(PARA_FOUR, user.getPassword());
            preparedStatement.setDate(PARA_FIVE, user.getBirthday());
            preparedStatement.setString(PARA_SIX, user.getGender().name());
            preparedStatement.setString(PARA_SEVEN, user.getRole().name());
            preparedStatement.setInt(PARA_EIGHT, user.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("User SQLException: " + ex.getMessage());
            System.out.println("User SQLState: " + ex.getSQLState());
            System.out.println("User VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void delete(final UserEntity user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dataSource.getConnection().prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setInt(PARA_ONE, user.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("u delete SQLException: " + ex.getMessage());
            System.out.println("u delete SQLState: " + ex.getSQLState());
            System.out.println("u delete VendorError: " + ex.getErrorCode());
        }
    }

    private UserEntity convert(final ResultSet resultSet) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAddressId(resultSet.getInt("address_id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setEmail(resultSet.getString("email"));
        user.setGender(Gender.valueOf(resultSet.getString("gender")));
        user.setRole(Role.valueOf(resultSet.getString("role")));
        return user;
    }

}
