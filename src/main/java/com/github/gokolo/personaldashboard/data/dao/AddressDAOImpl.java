package com.github.gokolo.personaldashboard.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.gokolo.personaldashboard.data.ConnectionProvider;
import com.github.gokolo.personaldashboard.data.dto.AddressDTO;

@Repository
@SuppressWarnings("PMD")
public class AddressDAOImpl implements AddressDAO {
    private final Connection conn = ConnectionProvider.connect();
    private static final int PARA_ONE = 1;
    private static final int PARA_TWO = 2;
    private static final int PARA_THREE = 3;
    private static final int PARA_FOUR = 4;
    private static final int PARA_FIVE = 5;
    private static final int PARA_SIX = 6;

    @Override
    public AddressDTO save(final AddressDTO address) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO address (house_number,street,zip_code,city,country) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(PARA_ONE, address.getHouseNumber());
            preparedStatement.setString(PARA_TWO, address.getStreet());
            preparedStatement.setString(PARA_THREE, address.getZipCode());
            preparedStatement.setString(PARA_FOUR, address.getCity());
            preparedStatement.setString(PARA_FIVE, address.getCountry());
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

        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }

        return address;
    }

    @Override
    public List<AddressDTO> findAll() {
        Statement statement;
        ResultSet resultSet;
        List<AddressDTO> addressCollection = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM address");
            while (resultSet.next()) {
                addressCollection.add(convert(resultSet));
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return addressCollection;
    }

    @Override
    public AddressDTO findById(final int id) {
        AddressDTO address = new AddressDTO();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM address WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                address = convert(resultSet);
            }
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void modify(final AddressDTO address) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE address SET house_number=?,street=?,zip_code=?,city=?,country=? WHERE id =?");
            preparedStatement.setString(PARA_ONE, address.getHouseNumber());
            preparedStatement.setString(PARA_TWO, address.getStreet());
            preparedStatement.setString(PARA_THREE, address.getZipCode());
            preparedStatement.setString(PARA_FOUR, address.getCity());
            preparedStatement.setString(PARA_FIVE, address.getCountry());
            preparedStatement.setInt(PARA_SIX, address.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void delete(final AddressDTO address) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM address WHERE id=?");
            preparedStatement.setInt(PARA_ONE, address.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }
    }

    private AddressDTO convert(final ResultSet resultSet) throws SQLException {
        AddressDTO address = new AddressDTO();
        address.setId(resultSet.getInt("id"));
        address.setHouseNumber(resultSet.getString("house_number"));
        address.setStreet(resultSet.getString("street"));
        address.setZipCode(resultSet.getString("zip_code"));
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));
        return address;
    }

}
