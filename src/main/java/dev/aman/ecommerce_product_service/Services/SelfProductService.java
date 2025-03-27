package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Models.Product;

import java.util.List;

public class SelfProductService implements ProductService {

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
