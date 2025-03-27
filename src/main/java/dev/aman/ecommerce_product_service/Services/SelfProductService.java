package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Models.Products;

import java.util.List;

public class SelfProductService implements ProductService {

    @Override
    public Products getProduct(Long id) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }
}
