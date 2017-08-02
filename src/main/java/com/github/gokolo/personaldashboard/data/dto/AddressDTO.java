package com.github.gokolo.personaldashboard.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class AddressDTO {
    private int id;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;
}
