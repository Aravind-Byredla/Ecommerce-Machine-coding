package net.javaguides.model;

import net.javaguides.utils.Utils;

public class Buyer {
    private final String buyerId;
    private final String buyerName;
    private final Address address;


    public Buyer( String buyerName, Address address) {
        this.buyerId = Utils.generateId();
        this.buyerName = buyerName;
        this.address = address;
    }


    public String getBuyerId() {
        return buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Address getAddress() {
        return address;
    }
}
