package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.AddressDTO;

public class AddressDAOImpl implements AddressDAO {
    private AddressDTO address = new AddressDTO();
    final Connection conn = MysqlConn.connect();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private int rowsAffected;
    private ResultSet resultSet;

    @Override
    public AddressDTO save(final AddressDTO address) {
        try {
            preparedStatement = conn.prepareStatement(
                    "INSERT INTO address (name,house_number,street,zip_code,city,country) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getHouseNumber());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getZipCode());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getCountry());
            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating Address failed, no rows affected.");
            }

            try (final ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    address.setId(resultSet.getInt(1));
                } else {
                    throw new SQLException("Creating Address failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return address;
    }

    @Override
    public AddressDTO findById(int id) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
            preparedStatement.setInt(1, address.getId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                address.setId(resultSet.getInt("id"));
                address.setHouseNumber(resultSet.getString("house_number"));
                address.setStreet(resultSet.getString("street"));
                address.setZipCode(resultSet.getString("zip_code"));
                address.setCity(resultSet.getString("city"));
                address.setCountry(resultSet.getString("country"));
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public int modify(AddressDTO user) {
        try {
            preparedStatement = conn.prepareStatement(
                    "UPDATE address SET name=?,house_number=?,street=?,zip_code=?,city=?,country=? WHERE id =?");
            preparedStatement.setString(1, address.getHouseNumber());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getZipCode());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getCountry());
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
    public void delete(AddressDTO user) {
        // TODO Auto-generated method stub

    }

}
