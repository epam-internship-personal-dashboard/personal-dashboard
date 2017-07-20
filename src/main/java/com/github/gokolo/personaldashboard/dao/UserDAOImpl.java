package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.gokolo.personaldashboard.Gender;
import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.Role;
import com.github.gokolo.personaldashboard.dto.UserDTO;

public class UserDAOImpl implements UserDAO {
    private final Connection conn = MysqlConn.connect();

    @Override
    public int save(final UserDTO user) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO user (name,username,email,password,birthday,gender,role,address_id) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getRole().name());
            preparedStatement.setInt(8, user.getAddressId());
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
    public List<UserDTO> findAll() {
        Statement statement;
        ResultSet resultSet;
        List<UserDTO> userCollection = new ArrayList<>();
        try {
            statement = conn.createStatement();
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
    public UserDTO findById(final int id) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        UserDTO user = new UserDTO();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
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
    public void modify(final UserDTO user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(
                    "UPDATE user SET name=?,username=?,email=?,password=?,birthday=?,gender=?,role=? WHERE id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getRole().name());
            // preparedStatement.setInt(8, user.getAddressId());
            preparedStatement.setInt(8, user.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("User SQLException: " + ex.getMessage());
            System.out.println("User SQLState: " + ex.getSQLState());
            System.out.println("User VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void delete(final UserDTO user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("DELET FROM user WHERE id=?");
            preparedStatement.setInt(1, user.getId());
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    private UserDTO convert(ResultSet resultSet) throws SQLException {
        UserDTO user = new UserDTO();
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
