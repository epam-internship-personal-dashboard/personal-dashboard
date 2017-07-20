package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.AddressDTO;

public class AddressDAOImpl implements AddressDAO {
    private final Connection conn = MysqlConn.connect();

    @Override
    public AddressDTO save(final AddressDTO address) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO address (house_number,street,zip_code,city,country) VALUES (?,?,?,?,?)",
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

            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                address.setId(resultSet.getInt(1));
            } else {
                throw new SQLException("Creating Address failed, no ID obtained.");
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }

        return address;
    }

    @Override
    public AddressDTO findById(int id) {
        AddressDTO address = new AddressDTO();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM address WHERE id = ?");
            preparedStatement.setInt(1, address.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

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
    public void modify(AddressDTO address) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE address SET name=?,house_number=?,street=?,zip_code=?,city=?,country=? WHERE id =?");
            preparedStatement.setString(1, address.getHouseNumber());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getZipCode());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getCountry());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void delete(AddressDTO address) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELET FROM address WHERE id=?");
            preparedStatement.setInt(1, address.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }
    }

}
