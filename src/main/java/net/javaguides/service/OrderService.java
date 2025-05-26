package net.javaguides.service;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.Order;

public interface OrderService {
    String addOrder(Order order) throws EcommerceException;
    Order getOrder(String orderId) throws EcommerceException;
}
