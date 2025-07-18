package net.javaguides.repository;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.ErrorCode;
import net.javaguides.model.Product;
import net.javaguides.utils.ErrorCodeMap;

import java.util.HashMap;

public class ProductRepository {
    HashMap<String, Product> products;

    public ProductRepository(){
        products = new HashMap<>();
    }

    public Product createProduct(Product product){
        if(products.get(product.getProductId())!=null){
            throw new EcommerceException(
                    ErrorCode.PRODUCT_ALREADY_CREATED,
                    ErrorCodeMap.errorCodeStringHashMap.get(ErrorCode.PRODUCT_ALREADY_CREATED)
            );
        }
        products.put(product.getProductId(), product);
        return product;
    }

    public Product getProduct(String productId){
        return products.get(productId);
    }
}
