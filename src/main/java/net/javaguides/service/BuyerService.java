package net.javaguides.service;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.Buyer;

public interface BuyerService {
    String addBuyer(Buyer buyer) throws EcommerceException;
    Buyer getBuyer(String buyerId) throws EcommerceException;
}
