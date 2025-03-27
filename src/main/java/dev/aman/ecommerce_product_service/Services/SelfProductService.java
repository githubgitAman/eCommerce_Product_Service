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

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
