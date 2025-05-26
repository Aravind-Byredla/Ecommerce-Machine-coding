package net.javaguides.service.impl;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.ErrorCode;
import net.javaguides.model.Product;
import net.javaguides.repository.ProductRepository;
import net.javaguides.service.ProductService;
import net.javaguides.utils.ErrorCodeMap;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(Product product) throws EcommerceException {
        Product createdProduct = productRepository.createProduct(product);

        return createdProduct.getProductId();
    }

    @Override
    public Product getProduct(String productId) throws EcommerceException {

        return productRepository.getProduct(productId);
    }

    @Override
    public boolean checkInventory(int orderedQuantity, String productId) throws EcommerceException {
        synchronized (this){
            Product product = productRepository.getProduct(productId);
            if(orderedQuantity<=product.getQuantity()){
                product.setProductQuantity(product.getQuantity()-orderedQuantity);
                return true;
            }else{
                throw new EcommerceException(ErrorCode.IN_SUFFICIENT_INVENTORY,
                        ErrorCodeMap.errorCodeStringHashMap.get(ErrorCode.IN_SUFFICIENT_INVENTORY));
            }
        }
    }
}
