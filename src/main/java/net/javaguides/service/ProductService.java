package net.javaguides.service;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.Product;

public interface ProductService {
     String addProduct(Product product) throws EcommerceException;
     Product getProduct(String productId) throws EcommerceException;
     boolean checkInventory(int orderQuantity, String productId) throws EcommerceException;
}
