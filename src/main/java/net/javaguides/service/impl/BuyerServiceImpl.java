package net.javaguides.service.impl;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.Buyer;
import net.javaguides.repository.BuyerRepository;
import net.javaguides.service.BuyerService;

public class BuyerServiceImpl implements BuyerService {
    BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }


    @Override
    public String addBuyer(Buyer buyer) throws EcommerceException {
        Buyer createdBuyer = buyerRepository.createBuyer(buyer);

        return createdBuyer.getBuyerId();
    }

    @Override
    public Buyer getBuyer(String buyerId) throws EcommerceException {

        return buyerRepository.getBuyer(buyerId);
    }
}
