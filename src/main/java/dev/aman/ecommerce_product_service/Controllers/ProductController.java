package dev.aman.ecommerce_product_service.Controllers;

import dev.aman.ecommerce_product_service.Models.Product;
import dev.aman.ecommerce_product_service.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{products}")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }
    public List<Product> getAllProducts(){
        return null;
    }
}
