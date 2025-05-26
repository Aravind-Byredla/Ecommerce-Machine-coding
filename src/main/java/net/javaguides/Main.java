package net.javaguides;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.*;
import net.javaguides.repository.BuyerRepository;
import net.javaguides.repository.OrderRepository;
import net.javaguides.repository.PincodeServiceabilityRepository;
import net.javaguides.repository.ProductRepository;
import net.javaguides.service.BuyerService; 
import net.javaguides.service.OrderService;
import net.javaguides.service.PincodeServiceabilityService;
import net.javaguides.service.ProductService;
import net.javaguides.service.impl.BuyerServiceImpl;
import net.javaguides.service.impl.OrderServiceImpl;
import net.javaguides.service.impl.PincodeServiceabilityServiceImpl;
import net.javaguides.service.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        BuyerRepository buyerRepository = new BuyerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();
        PincodeServiceabilityRepository pincodeServiceabilityRepository = new PincodeServiceabilityRepository();

        BuyerService buyerService = new BuyerServiceImpl(buyerRepository);
        ProductService productService = new ProductServiceImpl(productRepository);
        PincodeServiceabilityService pincodeServiceabilityService = new PincodeServiceabilityServiceImpl(pincodeServiceabilityRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository, productService, buyerService, pincodeServiceabilityService);

        Address address1 = new Address("Tag", "Vizag", "531162");
        Address address2 = new Address("Kondapur", "Hyderabad", "500084");
        Address address3 = new Address("Hubili", "Bengaluru", "536264");

        Product product1 = new Product("Denim-Jeans", 10, address1);
        Product product2 = new Product("Shoes", 10, address2);
        Product product3 = new Product("Casual Shirt", 10, address3);
        Product product4 = new Product("T-shirts", 10, address1);

        String product1Id = productService.addProduct(product1);
        String product2Id = productService.addProduct(product2);
        String product3Id = productService.addProduct(product3);
        String product4Id = productService.addProduct(product4);

        Buyer buyer1 = new Buyer("Aravind", address1);
        Buyer buyer2 = new Buyer("Hari", address2);
        Buyer buyer3 = new Buyer("Girish", address3);

        String buyerId1 = buyerService.addBuyer(buyer1);
        String buyerId2 = buyerService.addBuyer(buyer2);
        String buyerId3 = buyerService.addBuyer(buyer3);


        /*
            viz - hyd - prepaid
          viz - viz - prepaid
          hyd - ban - prepaid
          ban - viz - prepaid
        */

        pincodeServiceabilityService.createPincodeServiceability("531162", "500084",
                PaymentMode.PREPAID);
        pincodeServiceabilityService.createPincodeServiceability("531162", "531162",
                PaymentMode.PREPAID);
        pincodeServiceabilityService.createPincodeServiceability("500084", "536264",
                PaymentMode.PREPAID);
        pincodeServiceabilityService.createPincodeServiceability("536264", "531162",
                PaymentMode.PREPAID);

         Order order1 = new Order(product1Id, buyerId1, 5, PaymentMode.PREPAID);
         Order order3 = new Order(product1Id, buyerId1, 6, PaymentMode.PREPAID);
         Order order2 = new Order(product1Id, buyerId3, 5, PaymentMode.PREPAID);


         try {
             String order1Id = orderService.addOrder(order1);
             System.out.println("Order1 placed Successfully" + order1Id);

             String order3Id = orderService.addOrder(order3);
             System.out.println("Order1 placed Successfully" + order3Id);
         } catch (EcommerceException e) {
             System.out.println(e.getErrorCode()+"  "+e.getErrorMessage());
         }

        try{
            String order2Id = orderService.addOrder(order2);
            System.out.println("Order2 Placed Successfully "+ order2Id);
        }catch (EcommerceException e){
            System.out.println(e.getErrorCode()+"  "+e.getErrorMessage());
        }


    }
}












