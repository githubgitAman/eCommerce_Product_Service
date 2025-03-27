package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Models.Products;

import java.util.List;

public interface ProductService {

    Products getProduct(Long id);
    List<Products> getAllProducts();
}
