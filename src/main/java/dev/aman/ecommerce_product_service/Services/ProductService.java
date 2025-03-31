package dev.aman.ecommerce_product_service.Services;

import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import dev.aman.ecommerce_product_service.Models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getProduct(Long productId) throws ProductNotFoundException;
    Page<Product> getAllProducts(int pageNumber, int pageSize);
    void deleteProduct(Long productId) throws ProductNotFoundException;
    Product updateProduct(Long productId, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long productId, Product product) throws ProductNotFoundException;
    Product addProduct(Product product);
}
