package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Models.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Long id);
    List<Product> getAllProducts();
}
