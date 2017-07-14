package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.UserDTO;

public class UserDAOImpl implements UserDAO {
    private final Connection conn = MysqlConn.connect();
    private ResultSet resultSet;
    private List<UserDTO> userCollection;

    @Override
    public int save(UserDTO user) {

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO user (name,username,email,password,birthday,gender,role,address_id) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setDate(6, user.getBirthday());
            stmt.setString(7, user.getGender().name());
            stmt.setString(7, user.getRole().name());
            stmt.setInt(1, user.getAddress().getId());
            stmt.execute();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
    }

    @Override
    public List<UserDTO> findAll() {
        try {
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT *FROM user");
            while (resultSet.next()) {
                UserDTO user = new UserDTO();
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
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userCollection;
    }

    @Override
    public UserDTO findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO modify(UserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(UserDTO user) {
        // TODO Auto-generated method stub

    }

}
