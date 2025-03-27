package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    void deleteProduct(Long productId);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
}
