package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.UserDTO;

public class UserDAOImpl implements UserDAO {
    private final Connection conn = MysqlConn.connect();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private UserDTO user;
    private int rowsAffected;

    @Override
    public int save(final UserDTO user) {
        try {
            preparedStatement = conn.prepareStatement(
                    "INSERT INTO user (name,username,email,password,birthday,gender,role,address_id) VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getRole().name());
            preparedStatement.setInt(8, user.getAddress().getId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rowsAffected;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userCollection = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                // user.setAddress(address);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setEmail(resultSet.getString("email"));
                // gender
                // role
                userCollection.add(user);
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userCollection;
    }

    @Override
    public UserDTO findById(final int id) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
            preparedStatement.setInt(1, user.getId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                // user.setAddress(address);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setEmail(resultSet.getString("email"));
                // gender
                // role
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int modify(final UserDTO user) {
        try {
            preparedStatement = conn.prepareStatement(
                    "UPDATE user SET name=?,username=?,email=?,password=?,birthday=?,gender=?,role=?,address_id=? WHERE id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getRole().name());
            preparedStatement.setInt(8, user.getAddress().getId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rowsAffected;
    }

    @Override
    public int delete(final UserDTO user) {
        try {
            preparedStatement = conn.prepareStatement("DELET FROM user WHERE id=?");
            preparedStatement.setInt(1, user.getId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rowsAffected;
    }

}
