package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Models.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Products getProduct(Long id) {
        return null;
    }

    @Override
    public List<Products> getAllProducts() {
        return List.of();
    }
}
