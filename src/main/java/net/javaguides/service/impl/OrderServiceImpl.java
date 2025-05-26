package net.javaguides.service.impl;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.ErrorCode;
import net.javaguides.model.Order;
import net.javaguides.repository.OrderRepository;
import net.javaguides.service.BuyerService;
import net.javaguides.service.OrderService;
import net.javaguides.service.PincodeServiceabilityService;
import net.javaguides.service.ProductService;
import net.javaguides.utils.ErrorCodeMap;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ProductService productService;
    BuyerService buyerService;
    PincodeServiceabilityService pincodeServiceabilityService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService,
                            BuyerService buyerService,
                            PincodeServiceabilityService pincodeServiceabilityService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.buyerService = buyerService;
        this.pincodeServiceabilityService = pincodeServiceabilityService;
    }

    @Override
    public String addOrder(Order order) throws EcommerceException {
        final String sourcePinCode = productService.getProduct(order.getProductId()).getAddress().getPincode();
        final String destinationPinCode = buyerService.getBuyer(order.getBuyerId()).getAddress().getPincode();

        if(!pincodeServiceabilityService.checkIsSrcAndDestnPincodeMatchesForPaymentType(
                sourcePinCode,
                destinationPinCode, order.getPaymentMode()
        )){
            throw new EcommerceException(
                    ErrorCode.PIN_CODE_UNSERVICEABLE,
                    ErrorCodeMap.errorCodeStringHashMap.get(ErrorCode.PIN_CODE_UNSERVICEABLE)
            );
        }

        if(productService.checkInventory(order.getQuantity(), order.getProductId())){
            Order createdOrder = orderRepository.createOrder(order);
            return createdOrder.getOrderId();
        }

        throw new EcommerceException(
                ErrorCode.ORDER_CREATION_FAILED,
                ErrorCodeMap.errorCodeStringHashMap.get(ErrorCode.PRODUCT_ALREADY_CREATED)
        );
    }

    @Override
    public Order getOrder(String orderId) throws EcommerceException {

        return orderRepository.getOrder(orderId);
    }
}
