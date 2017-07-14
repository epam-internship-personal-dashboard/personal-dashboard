package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.AddressDTO;

public class AddressDAOImpl implements AddressDAO {
    final Connection conn = MysqlConn.connect();

    @Override
    public AddressDTO save(AddressDTO address) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO address (name,house_number,street,zip_code,city,country) VALUES (?,?,?,?,?,?)");
            stmt.setString(2, address.getHouseNumber());
            stmt.setString(3, address.getStreet());
            stmt.setString(4, address.getZipCode());
            stmt.setString(5, address.getCity());
            stmt.setString(6, address.getCountry());
            stmt.execute();

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AddressDTO modify(AddressDTO user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(AddressDTO user) {
        // TODO Auto-generated method stub

    }

}
