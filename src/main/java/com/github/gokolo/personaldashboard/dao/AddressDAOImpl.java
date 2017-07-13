package com.github.gokolo.personaldashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.gokolo.personaldashboard.MysqlConn;
import com.github.gokolo.personaldashboard.dto.AddressDTO;

public class AddressDAOImpl implements AddressDAO {
    final Connection conn = MysqlConn.connect();

    @Override
    public int save(AddressDTO user) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO address (name,house_number,street,zip_code,city,country) VALUES (?,?,?,?,?,?)");
            stmt.setString(2, user.getHouseNumber());
            stmt.setString(3, user.getStreet());
            stmt.setString(4, user.getZipCode());
            stmt.setString(5, user.getCity());
            stmt.setString(6, user.getCountry());

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return 0;
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
