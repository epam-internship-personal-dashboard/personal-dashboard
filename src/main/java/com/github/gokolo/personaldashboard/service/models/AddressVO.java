package com.github.gokolo.personaldashboard.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a service layer class derived from AddressDTO to model an Address
 * object.
 * 
 * @author Grace_Okolo
 * @version 0.4.0
 * @since 01/08/2017
 *
 * @see com.github.gokolo.personaldashboard.entities.AddressEntity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVO {
    private int id;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;
}
