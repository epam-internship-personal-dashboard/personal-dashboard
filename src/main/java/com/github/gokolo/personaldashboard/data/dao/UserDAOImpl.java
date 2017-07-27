package com.github.gokolo.personaldashboard.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.gokolo.personaldashboard.data.ConnectionProvider;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.data.enums.Gender;
import com.github.gokolo.personaldashboard.data.enums.Role;

@SuppressWarnings("PMD")
public class UserDAOImpl implements UserDAO {
    private final Connection conn = ConnectionProvider.connect();
    private static final int PARA_ONE = 1;
    private static final int PARA_TWO = 2;
    private static final int PARA_THREE = 3;
    private static final int PARA_FOUR = 4;
    private static final int PARA_FIVE = 5;
    private static final int PARA_SIX = 6;
    private static final int PARA_SEVEN = 7;
    private static final int PARA_EIGHT = 8;

    @Override
    public int save(final UserDTO user) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
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
    public UserDTO findByUsernamePassword(final String username, final String password) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        UserDTO user = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
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
    public void modify(final UserDTO user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(
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
    public void delete(final UserDTO user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setInt(PARA_ONE, user.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("u delete SQLException: " + ex.getMessage());
            System.out.println("u delete SQLState: " + ex.getSQLState());
            System.out.println("u delete VendorError: " + ex.getErrorCode());
        }
    }

    private UserDTO convert(final ResultSet resultSet) throws SQLException {
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
