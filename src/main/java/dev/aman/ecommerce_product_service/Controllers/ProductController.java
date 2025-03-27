package dev.aman.ecommerce_product_service.Controllers;

import dev.aman.ecommerce_product_service.Models.Products;
import dev.aman.ecommerce_product_service.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Products getProduct(@PathVariable("id") Long id){
        return null;
    }
    public List<Products> getAllProducts(){
        return null;
    }
}
