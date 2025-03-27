package dev.aman.ecommerce_product_service;

import dev.aman.ecommerce_product_service.Models.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceProductServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ECommerceProductServiceApplication.class, args);
        Products product = new Products();
        product.getDescription();


    }

}
