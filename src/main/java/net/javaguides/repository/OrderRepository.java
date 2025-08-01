package net.javaguides.repository;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.ErrorCode;
import net.javaguides.model.Order;
import net.javaguides.utils.ErrorCodeMap;

import java.util.HashMap;

public class OrderRepository {
    HashMap<String, Order> orders;


    public OrderRepository() {
        orders = new HashMap<>();
    }

    public Order createOrder(Order order){
        if(orders.get(order.getOrderId())!= null){
            throw new EcommerceException(
                    ErrorCode.ORDER_CREATION_FAILED,
                    ErrorCodeMap.errorCodeStringHashMap.get(ErrorCode.ORDER_CREATION_FAILED)
            );
        }
        orders.put(order.getOrderId(), order);
        return order;
    }

    public Order getOrder(String orderId){
        return orders.get(orderId);
    }


}
