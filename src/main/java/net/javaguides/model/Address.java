package net.javaguides.model;

public class Address {
    private final String address1;
    private final String city;
    private final String pincode;

    public Address(String address1, String city, String pincode) {
        this.address1 = address1;
        this.city = city;
        this.pincode = pincode;
    }


    public String getAddress1() {
        return address1;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
