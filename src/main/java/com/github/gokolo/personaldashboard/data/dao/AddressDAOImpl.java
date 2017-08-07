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

import com.github.gokolo.personaldashboard.entities.AddressEntity;

@Repository
@SuppressWarnings("PMD")
public class AddressDAOImpl implements AddressDAO {
    @Autowired
    private DataSource dataSource;
    private static final int PARA_ONE = 1;
    private static final int PARA_TWO = 2;
    private static final int PARA_THREE = 3;
    private static final int PARA_FOUR = 4;
    private static final int PARA_FIVE = 5;
    private static final int PARA_SIX = 6;

    @Override
    public AddressEntity save(final AddressEntity address) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
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
    public List<AddressEntity> findAll() {
        Statement statement;
        ResultSet resultSet;
        List<AddressEntity> addressCollection = new ArrayList<>();
        try {
            statement = dataSource.getConnection().createStatement();
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
    public AddressEntity findById(final int id) {
        AddressEntity address = new AddressEntity();
        try {
            PreparedStatement preparedStatement = dataSource.getConnection()
                    .prepareStatement("SELECT * FROM address WHERE id = ?");
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
    public void modify(final AddressEntity address) {
        try {
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
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
    public void delete(final AddressEntity address) {
        try {
            PreparedStatement preparedStatement = dataSource.getConnection()
                    .prepareStatement("DELETE FROM address WHERE id=?");
            preparedStatement.setInt(PARA_ONE, address.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException ex) {
            // handle any errors
            System.out.println("address SQLException: " + ex.getMessage());
            System.out.println("address SQLState: " + ex.getSQLState());
            System.out.println("address VendorError: " + ex.getErrorCode());
        }
    }

    private AddressEntity convert(final ResultSet resultSet) throws SQLException {
        AddressEntity address = new AddressEntity();
        address.setId(resultSet.getInt("id"));
        address.setHouseNumber(resultSet.getString("house_number"));
        address.setStreet(resultSet.getString("street"));
        address.setZipCode(resultSet.getString("zip_code"));
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));
        return address;
    }

}
