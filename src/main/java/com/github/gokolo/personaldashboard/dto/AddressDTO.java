package com.github.gokolo.personaldashboard.dto;

public final class AddressDTO {
    private int id;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "Address [street=" + street + ", houseNumber=" + houseNumber + ", zipCode=" + zipCode + ", city=" + city
                + "]";
    }

    @SuppressWarnings("PMD")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
        result = prime * result + id;
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    @SuppressWarnings("PMD")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressDTO other = (AddressDTO) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (houseNumber == null) {
            if (other.houseNumber != null)
                return false;
        } else if (!houseNumber.equals(other.houseNumber))
            return false;
        if (id != other.id)
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        if (zipCode == null) {
            if (other.zipCode != null)
                return false;
        } else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String uStreet) {
        street = uStreet;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(final String uHouseNumber) {
        houseNumber = uHouseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String uZipCode) {
        zipCode = uZipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String uCity) {
        city = uCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String uCountry) {
        country = uCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int uId) {
        id = uId;
    }
}
